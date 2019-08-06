package com.ups.demo.dao;

import com.ups.demo.pojo.Device;
import org.springframework.stereotype.Component;

@Component
public interface DeviceMapper {
    int deleteByPrimaryKey(String strId);

    int insert(Device record);

    int insertSelective(Device record);

    Device selectByPrimaryKey(String strId);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);
}