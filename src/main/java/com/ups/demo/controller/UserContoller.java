package com.ups.demo.controller;

import com.ups.demo.pojo.User;
import com.ups.demo.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "user")
public class UserContoller {

    @Autowired
    private UserService userService;

    private final static Log log = LogFactory.getLog(UserContoller.class);

    @GetMapping(value = "/get_user_info/{telNumber}")
    public User getUserInfo(@PathVariable String telNumber) {
        if(telNumber != null) {
            if(log.isTraceEnabled()) {
                log.trace("查询电话号码为: " + telNumber + "的用户的个人详细信息" );
            }
            return userService.getUserInfo(telNumber);
        }
        return null;
    }

    @PostMapping(value = "/user_info_modify")
    public Map<String,String> getUserInfo(@RequestBody User user) {
        Map<String,String> result = new HashMap<>();
        if(user != null) {
            if(log.isTraceEnabled()) {
                log.trace("修改电话号码为" + user.getStrTelNumber() + "的个人信息");
            }
            if(userService.userInfoModify(user) != 0) {
                result.put("result","success");
                return result;
            }
            result.put("result","fail");
            return result;
        }
        result.put("result","fail");
        return result;
    }

    @GetMapping(value = "/user_password_modify")
    public Map<String,String> getUserInfo(@RequestParam(value = "telNumber") String telNumber, @RequestParam(value = "newPassword") String newPassword) {
        Map<String,String> result = new HashMap<>();
        if(telNumber != null && newPassword != null) {
            if(log.isTraceEnabled()) {
                log.trace("修改电话号码为" + telNumber + "的密码");
            }
            if(userService.userPasswordModify(newPassword,telNumber) != 0) {
                result.put("result","success");
                return result;
            }
            result.put("result","fail");
            return result;
        }
        result.put("result","fail");
        return result;
    }
}
