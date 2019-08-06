package com.ups.demo.dao;

import com.ups.demo.pojo.User;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper {
    int deleteByPrimaryKey(String strUserId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String strUserId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}