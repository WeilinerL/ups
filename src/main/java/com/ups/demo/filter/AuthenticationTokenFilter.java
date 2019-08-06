package com.ups.demo.filter;

import com.auth0.jwt.interfaces.Claim;
import com.ups.demo.dao.UserLogInfoMapper;
import com.ups.demo.dao.UserMapper;
import com.ups.demo.service.TokenService;
import com.ups.demo.utils.GetIPAddress;
import com.ups.demo.utils.JwtToken;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 从request中获取token，并把token转换成用户，放置到当前的spring context内。
 * 这个类必须写一个@Service注解，否则spring不会加载它作为filter
 * 由于我配置了@WebFilter 所以不用写 @Service 注解 否则会加载两次
 */
//@WebFilter(urlPatterns = "/device_list/*")
public class AuthenticationTokenFilter extends OncePerRequestFilter {
    private final static Log log = LogFactory.getLog(AuthenticationTokenFilter.class);

    private TokenService tokenService = new TokenService();// AuthTokenConfig new 了这个filter类
    @Autowired
    private UserLogInfoMapper userLogInfoMapper;
    @Autowired
    private UserMapper userMapper;
    // 如果这里的tokenService用@Autowired自动注入,那么这个对象的tokenService将会是null
    //如果不用 AuthTokenConfig配置 则可直接@Autowired注入(主要是该类new了这个filter)

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        String authToken = null;
        
        // 下面的代码从Http Header的Authorization中获取token，也可以从其他header,cookie等中获取，看客户端怎么传递token
        String requestHeader = request.getHeader("Authorization");
        if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
            authToken = requestHeader.substring(7);
        }
        if (log.isTraceEnabled()) {
            log.trace("token is " + authToken);
            log.trace("ip address is " + GetIPAddress.getRealIp(request));
        }
        
        if (authToken != null) {
            boolean flag = false;
            UserDetails user = null;
            //查询token对应的用户
            try {
                //检查token的有效性
                Map<String, Claim> claimMap = JwtToken.verifyToken(authToken);
                if(claimMap != null) {
                    //出于安全考虑这里即使丢失了spring tokenMap里的用户临时登录信息也不找回
                    //用户再次登陆即可获得相应信息
//                    if(!TokenService.tokenMap.containsKey(authToken)) {
//                        String userName = userLogInfoMapper.selectByToken(authToken);
//                        User user2 = userMapper.selectByPrimaryKey(userName);
//                        TokenService.tokenMap.put(authToken,tokenService.createUser(user2.getStrName(),user2.getStrPassword(),new String[]{user2.getStrRank()}));
//                    }
                    flag = true;
                    user = tokenService.getUserFromToken(authToken);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            if(user != null && flag == true) {
                // 把user设置到SecurityContextHolder内，以spring使用
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null,
                        user.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        
        chain.doFilter(request, response);
    }
}
