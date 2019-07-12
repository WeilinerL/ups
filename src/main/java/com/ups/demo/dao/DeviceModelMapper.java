package com.ups.demo.dao;

import com.ups.demo.pojo.DeviceModel;

public interface DeviceModelMapper {
    int deleteByPrimaryKey(String strModelId);

    int insert(DeviceModel record);

    int insertSelective(DeviceModel record);

    DeviceModel selectByPrimaryKey(String strModelId);

    int updateByPrimaryKeySelective(DeviceModel record);

    int updateByPrimaryKey(DeviceModel record);
}