package com.ups.demo.service;

import com.ups.demo.dao.UserMapper;
import com.ups.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User getUserInfo(String telNumber) {return userMapper.selectByTelNumber(telNumber);}

    public int userInfoModify(User user) {return userMapper.updateByPrimaryKey(user);}

    public int userPasswordModify(String newPassword, String telNumber) {return userMapper.updataByTelNumber(newPassword,telNumber);}
}
