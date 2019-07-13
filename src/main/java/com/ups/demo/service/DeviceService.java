package com.ups.demo.service;

import com.ups.demo.dao.DeviceMapper;
import com.ups.demo.pojo.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeviceService {
    @Autowired
    private DeviceMapper deviceMapper;
    @Autowired
    private Device device;

    @Transactional(readOnly = true)
    public List<Device> getAllDevice() {
        try {
            Thread.sleep(10);
        }catch(Exception e) {

        }
        return deviceMapper.getAllDevice();
    }
}
