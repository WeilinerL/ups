package com.ups.demo.dao;

import com.ups.demo.pojo.Data;

public interface DataMapper {
    int deleteByPrimaryKey(String strDataId);

    int insert(Data record);

    int insertSelective(Data record);

    Data selectByPrimaryKey(String strDataId);

    int updateByPrimaryKeySelective(Data record);

    int updateByPrimaryKey(Data record);
}