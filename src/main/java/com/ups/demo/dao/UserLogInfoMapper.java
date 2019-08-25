package com.ups.demo.dao;

import com.ups.demo.pojo.UserLogInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface UserLogInfoMapper {

    @Delete("delete from t_user_log_info where str_token = #{token}")
    int deleteByToken(String token);

    int deleteByPrimaryKey(String strUsername);

    int insert(UserLogInfo record);

    int insertSelective(UserLogInfo record);

    UserLogInfo selectByPrimaryKey(String strUsername);

    int updateByPrimaryKeySelective(UserLogInfo record);

    int updateByPrimaryKey(UserLogInfo record);
}