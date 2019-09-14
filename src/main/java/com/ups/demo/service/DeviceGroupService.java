package com.ups.demo.service;

import com.ups.demo.dao.DeviceGroupMapper;
import com.ups.demo.pojo.DeviceGroup;
import com.ups.demo.pojo.DeviceGroupShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceGroupService {

    @Autowired
    private DeviceGroupMapper deviceGroupMapper;

    public List<DeviceGroupShow> getAllDeviceGroup() {
        DeviceGroupShow deviceGroupShow = new DeviceGroupShow();
        return deviceGroupShow.findChildren(deviceGroupMapper.selectAll());
    }

    public int renameGroup(String oldName, String newName) {
        DeviceGroup deviceGroup = deviceGroupMapper.selectByLabel(oldName);
        deviceGroup.setStrLabel(newName);
        return deviceGroupMapper.updateByPrimaryKey(deviceGroup);
    }
}
