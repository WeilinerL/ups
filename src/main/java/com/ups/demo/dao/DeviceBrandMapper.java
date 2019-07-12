package com.ups.demo.dao;

import com.ups.demo.pojo.DeviceBrand;

public interface DeviceBrandMapper {
    int deleteByPrimaryKey(String strBrandId);

    int insert(DeviceBrand record);

    int insertSelective(DeviceBrand record);

    DeviceBrand selectByPrimaryKey(String strBrandId);

    int updateByPrimaryKeySelective(DeviceBrand record);

    int updateByPrimaryKey(DeviceBrand record);
}