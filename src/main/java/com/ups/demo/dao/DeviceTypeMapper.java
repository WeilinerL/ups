package com.ups.demo.dao;

import com.ups.demo.pojo.DeviceType;

public interface DeviceTypeMapper {
    int deleteByPrimaryKey(String strTypeId);

    int insert(DeviceType record);

    int insertSelective(DeviceType record);

    DeviceType selectByPrimaryKey(String strTypeId);

    int updateByPrimaryKeySelective(DeviceType record);

    int updateByPrimaryKey(DeviceType record);
}