package com.ups.demo.dao;

import com.ups.demo.pojo.DeviceData;
import org.springframework.stereotype.Component;

@Component
public interface DeviceDataMapper {
    int deleteByPrimaryKey(Integer intDataId);

    int insert(DeviceData record);

    int insertSelective(DeviceData record);

    DeviceData selectByPrimaryKey(Integer intDataId);

    int updateByPrimaryKeySelective(DeviceData record);

    int updateByPrimaryKey(DeviceData record);
}