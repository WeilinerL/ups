package com.ups.demo.dao;

import com.ups.demo.pojo.DeviceDetail;
import org.springframework.stereotype.Component;

@Component
public interface DeviceDetailMapper {
    int deleteByPrimaryKey(Integer intDetailId);

    int insert(DeviceDetail record);

    int insertSelective(DeviceDetail record);

    DeviceDetail selectByPrimaryKey(Integer intDetailId);

    int updateByPrimaryKeySelective(DeviceDetail record);

    int updateByPrimaryKey(DeviceDetail record);
}