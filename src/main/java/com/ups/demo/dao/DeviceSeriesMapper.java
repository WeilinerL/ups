package com.ups.demo.dao;

import com.ups.demo.pojo.DeviceSeries;

public interface DeviceSeriesMapper {
    int deleteByPrimaryKey(String strSeriesId);

    int insert(DeviceSeries record);

    int insertSelective(DeviceSeries record);

    DeviceSeries selectByPrimaryKey(String strSeriesId);

    int updateByPrimaryKeySelective(DeviceSeries record);

    int updateByPrimaryKey(DeviceSeries record);
}