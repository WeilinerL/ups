package com.ups.demo.controller;

import com.ups.demo.pojo.DeviceGroup;
import com.ups.demo.pojo.DeviceGroupShow;
import com.ups.demo.service.DeviceGroupService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/device_group/")
public class DeviceGroupController {

    @Autowired
    private DeviceGroupService deviceGroupService;

    private final static Log log = LogFactory.getLog(DeviceController.class);

    @GetMapping(value = "get_all_device_group")
    public List<DeviceGroupShow> getAllDeviceGroup() {
        if(log.isTraceEnabled()) {
            log.trace("获取所有的分组信息");
        }
        return deviceGroupService.getAllDeviceGroup();
    }

    @PutMapping(value = "rename_group/{oldName}/{newName}")
    public Map<String,String> renameGroup(@PathVariable String oldName, @PathVariable String newName) {
        Map<String,String> result = new HashMap<>();
        if(!newName.equals("")) {
            if(deviceGroupService.renameGroup(oldName,newName) != 0) {
                result.put("result","success");
                return result;
            }
            result.put("result","fail");
            return result;
        }else {
            result.put("result","fail");
            return result;
        }
    }

}
