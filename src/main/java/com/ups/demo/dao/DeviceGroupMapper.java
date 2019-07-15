package com.ups.demo.dao;

import com.ups.demo.pojo.DeviceGroupKey;

public interface DeviceGroupMapper {
    int deleteByPrimaryKey(DeviceGroupKey key);

    int insert(DeviceGroupKey record);

    int insertSelective(DeviceGroupKey record);
}