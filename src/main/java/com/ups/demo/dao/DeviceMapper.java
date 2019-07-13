package com.ups.demo.dao;

import com.ups.demo.pojo.Device;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface DeviceMapper {
    @Select("select * from t_device")
    public List<Device> getAllDevice();

    int deleteByPrimaryKey(String strId);

    int insert(Device record);

    int insertSelective(Device record);

    Device selectByPrimaryKey(String strId);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);
}