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

    public int addGroup(String groupName) {
        DeviceGroup deviceGroup = new DeviceGroup();
        deviceGroup.setStrLabel(groupName);
        deviceGroup.setStrType("parent");
        deviceGroup.setStrShow("false");
        return deviceGroupMapper.insert(deviceGroup);
    }

    public int deleteGroup(String groupName) {
        int resultCount = 0;
        DeviceGroup deviceGroup = deviceGroupMapper.selectByLabel(groupName);
        if(deviceGroup.getStrChildren() != null) {
            resultCount += deviceGroupMapper.deleteByLabel(groupName);
            String[] childrenId = deviceGroup.getStrChildren().split(";");
            for(String id : childrenId) {
                int childId = Integer.parseInt(id);
                resultCount += deviceGroupMapper.deleteByPrimaryKey(childId);
            }
            if(resultCount == childrenId.length + 1) {
                return 1;
            }else {
                return 0;
            }
        }else {
            return deviceGroupMapper.deleteByLabel(groupName);
        }
    }
}
