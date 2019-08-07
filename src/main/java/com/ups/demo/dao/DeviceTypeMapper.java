package com.ups.demo.dao;

import com.ups.demo.pojo.DeviceType;
import org.springframework.stereotype.Component;

@Component
public interface DeviceTypeMapper {
    int deleteByPrimaryKey(Integer intDtypeId);

    int insert(DeviceType record);

    int insertSelective(DeviceType record);

    DeviceType selectByPrimaryKey(Integer intDtypeId);

    int updateByPrimaryKeySelective(DeviceType record);

    int updateByPrimaryKey(DeviceType record);
}