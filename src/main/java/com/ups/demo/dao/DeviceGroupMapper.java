package com.ups.demo.dao;

import com.ups.demo.pojo.DeviceGroup;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DeviceGroupMapper {

    @Select("select * from t_device_group")
    List<DeviceGroup> selectAll();

    @Select("select * from t_device_group where str_label = #{oldName}")
    DeviceGroup selectByLabel(String oldName);

    int deleteByPrimaryKey(Integer intId);

    int insert(DeviceGroup record);

    int insertSelective(DeviceGroup record);

    DeviceGroup selectByPrimaryKey(Integer intId);

    int updateByPrimaryKeySelective(DeviceGroup record);

    int updateByPrimaryKey(DeviceGroup record);
}