package com.ups.demo.dao;

import com.ups.demo.pojo.DeviceManagerKey;

public interface DeviceManagerMapper {
    int deleteByPrimaryKey(DeviceManagerKey key);

    int insert(DeviceManagerKey record);

    int insertSelective(DeviceManagerKey record);
}