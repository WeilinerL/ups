package com.ups.demo.controller;

import com.ups.demo.pojo.Device;
import com.ups.demo.service.DeviceService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/device_list")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    private final static Log log = LogFactory.getLog(DeviceController.class);

    @GetMapping
    @PreAuthorize("hasRole('reader')")
    public List<Device> getAll() {
        if(log.isTraceEnabled()) {
            log.trace("get all devices");
        }
        return deviceService.getAllDevice();
    }
}
