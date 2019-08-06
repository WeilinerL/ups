package com.ups.demo.dao;

import com.ups.demo.pojo.Data;
import org.springframework.stereotype.Component;

@Component
public interface DataMapper {
    int deleteByPrimaryKey(String strReadTime);

    int insert(Data record);

    int insertSelective(Data record);

    Data selectByPrimaryKey(String strReadTime);

    int updateByPrimaryKeySelective(Data record);

    int updateByPrimaryKey(Data record);
}