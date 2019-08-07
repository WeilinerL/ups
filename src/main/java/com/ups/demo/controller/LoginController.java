package com.ups.demo.controller;

import com.ups.demo.service.TokenService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/")
public class LoginController {

    private final static Log log = LogFactory.getLog(LoginController.class);

    @Autowired
    private TokenService tokenService;

    @PostMapping(value = "login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> userInfo,
                                                     @RequestHeader(value="User-Agent") String userAgent){
        String userName = userInfo.get("username");
        String password = userInfo.get("password");

        HashMap<String, Object> result = new HashMap<>();
        String token = tokenService.loginCheck(userName, password,userAgent);
        if(token == null) {
            result.put("message", "invalid username or password");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
        }else {
            if(log.isTraceEnabled()) {
                log.trace("用户名为"+ tokenService.getUserFromToken(token).getUsername() + "的用户成功登录");
            }
            result.put("用户名",tokenService.getUserFromToken(token).getUsername());
            result.put("token", token);
            result.put("客户端",userAgent);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        }
    }

    @DeleteMapping
    public Map<String, Object> logout(HttpServletRequest request){
        HashMap<String, Object> result = new HashMap<>();
        String token = null;
        String requestHeader = request.getHeader("Authorization");
        if (requestHeader != null && requestHeader.startsWith("Bearer ")) {
            token = requestHeader.substring(7);
            if(log.isTraceEnabled() && tokenService.getUserFromToken(token) != null) {
                log.trace("will delete token : " + token);
                result.put("注销用户",tokenService.getUserFromToken(token).getUsername());
                tokenService.logout(token);
                return result;
            } else {
                result.put("注销失败","无此用户登录信息!");
                return result;
            }
        } else{
            result.put("注销失败","无此用户登录信息!");
            return result;
        }
    }
}
