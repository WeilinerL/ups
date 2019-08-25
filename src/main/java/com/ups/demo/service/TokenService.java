package com.ups.demo.service;

import com.auth0.jwt.interfaces.Claim;
import com.ups.demo.controller.LoginController;
import com.ups.demo.dao.UserLogInfoMapper;
import com.ups.demo.dao.UserMapper;
import com.ups.demo.pojo.User;
import com.ups.demo.pojo.UserLogInfo;
import com.ups.demo.utils.JwtToken;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class TokenService {

    private final static Log log = LogFactory.getLog(LoginController.class);

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserLogInfoMapper userLogInfoMapper;
    // 一般是把token和用户对应关系放在数据库或高速缓存(例如readis/memcache等），放在一个单例类的成员变量里仅适合很小规模的情形
    //这里我也存客户的一部分信息 主要信息存在数据库 再根据数据库存的信息来匹配临时信息
    private static Map<String, UserDetails> tokenMap = new HashMap<>();

    /**
     * 这个方法在每次访问都会被调用；为了提示效率应该使用@Cacheable注解缓存；
     */
    public UserDetails getUserFromToken(String token) {
        if(token == null) {
            return null;
        }
        return tokenMap.get(token);
    }

    /*
     登录人数过多时效率太低
     */
//    public boolean loginCheck(String username) {
//        Iterator<Map.Entry<String,UserDetails>> iterator = tokenMap.entrySet().iterator();
//        while (iterator.hasNext()) {
//            Map.Entry<String,UserDetails> entry = iterator.next();
//            if(entry.getValue().getUsername().equals(username)) {
//                return true;
//            }
//        }
//        return false;
//    }

    /**
     * 从数据库获取相应的登录信息
     * @param userName 用户名
     * @return
     */

    public UserLogInfo getLogInfo(String userName) {
        UserLogInfo userLogInfo = userLogInfoMapper.selectByPrimaryKey(userName);
        return userLogInfo;
    }

    /**
     * 检查用户登录
     * @param userName
     * @param password
     * @param userAgent
     * @return
     */

    public String loginCheck(String userName, String password, String userAgent, String userType) {
        User userLogin = userMapper.selectByTelNumber(userName);
        Boolean loginFlag = false;
        if(userLogin != null) {
            if(userLogin.getStrUserType().equals(userType) || userLogin.getStrUserType().equals("admin")) {
                loginFlag = true;
            }
        }
        if(userLogin != null && userLogin.getStrPassword().equals(password) && loginFlag) {
            UserLogInfo userLogInfo = getLogInfo(userName);
            boolean flag = false;
            if(userLogInfo != null) {//避免空指针
                Map<String, Claim> claimMap = JwtToken.verifyToken(userLogInfo.getStrToken());
                if(claimMap != null) {
                    flag = true;
                }
            }
            //有用户登录信息且用户此次登录设备为同一种设备且token令牌未过期
            //则把令牌返回给该用户(防止重复登录)
            if(userLogInfo != null && userLogInfo.getStrUserAgent().equals(userAgent) && flag) {
                if(log.isTraceEnabled()) {
                    log.trace("同一设备有效登录");
                }
                //如果spring tokenMap临时信息丢失
                if(!tokenMap.containsKey(userLogInfo.getStrToken())) {
                    User user = userMapper.selectByTelNumber(userName);
                    tokenMap.put(userLogInfo.getStrToken(),createUser(userName,password,new String[]{user.getStrUserType()}));
                }
                return userLogInfo.getStrToken();
            }
            //此时用户换了个设备登录且在token令牌有效期内
            else if(userLogInfo != null && !userLogInfo.getStrUserAgent().equals(userAgent) && flag) {
                if(log.isTraceEnabled()) {
                    log.trace("换另外的设备有效登录");
                }
                //原设备强制下线 更新token
                logout(userLogInfo.getStrToken());
                userLogInfoMapper.deleteByPrimaryKey(userName);
                return login(userName,password,userAgent);
            }
            //用户第一次登录或者token令牌已过期
            else {
                if(log.isTraceEnabled()) {
                    log.trace("第一次登录或原登录token令牌已失效");
                }
                //删除相应用户的登录信息
                if(userLogInfoMapper.selectByPrimaryKey(userName) != null) {
                    userLogInfoMapper.deleteByPrimaryKey(userName);
                }
                return login(userName,password,userAgent);
            }
        }else {
            return null;
        }
    }

    /**
     * 登录，成功返回token
     * @param userName 用户名
     * @param password 密码
     * @param userAgent 客户端
     * @return
     */
    public String login(String userName, String password,String userAgent) {
            UserDetails ud = null;
            User user = userMapper.selectByTelNumber(userName);
            // 支持两种用户：customerer/admin
            if(user != null && user.getStrPassword().equals(password)) {
                ud = createUser(userName, password, new String[] {user.getStrUserType()});
            }
            if(ud != null) {
                Date date = new Date();
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String time = df.format(date);
                String token = JwtToken.createToken(userName);
                //在数据库创建对应的登录信息
                UserLogInfo userLogInfo2 = new UserLogInfo();
                userLogInfo2.setStrToken(token);
                userLogInfo2.setStrUsername(userName);
                userLogInfo2.setStrUserAgent(userAgent);
                userLogInfo2.setStrLoginTime(time);
                userLogInfoMapper.insert(userLogInfo2);
                tokenMap.put(token, ud);
                return token;
            }else {
                return null;
            }

    }

    /**
     * 退出，移除token
     * @param token 令牌
     */
    public boolean logout(String token) {
        if(getUserFromToken(token) != null) {
            userLogInfoMapper.deleteByToken(token);
            tokenMap.remove(token);
            return true;
        } else{
            return false;
        }

    }

    /**
     * 检查用户的令牌是否有效
     * @param userName
     * @param token
     * @return
     */

    public boolean tokenCheck(String userName, String token) {
        if(userName.equals("") && token.equals("")) {return false;}
        if(token.equals(userLogInfoMapper.selectByPrimaryKey(userName).getStrToken())) {
            return true;
        }
        return false;
    }

    private UserDetails createUser(String userName, String password, String[] roles) {
        return new UserDetails() {

            private static final long serialVersionUID = 6905138725952656074L;

            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

                //这是增加了一种名为query的权限，可以使用 @hasAuthority("query") 来判断
                SimpleGrantedAuthority authority = new SimpleGrantedAuthority("query");
                authorities.add(authority);

                //这是增加到xxx角色，可以用hasRole("xxx")来判断；需要注意所有的角色在这里增加时必须以ROLE_前缀，使用时则没有ROLES_前缀
                for(String role : roles) {
                    SimpleGrantedAuthority sga = new SimpleGrantedAuthority("ROLE_" + role);
                    authorities.add(sga);
                }
                return authorities;
            }

            @Override
            public String getPassword() {
                return password;
            }

            @Override
            public String getUsername() {
                return userName;
            }

            @Override
            public boolean isAccountNonExpired() {
                return true;
            }

            @Override
            public boolean isAccountNonLocked() {
                return true;
            }

            @Override
            public boolean isCredentialsNonExpired() {
                return true;
            }

            @Override
            public boolean isEnabled() {
                return true;
            }

        };
    }
}
