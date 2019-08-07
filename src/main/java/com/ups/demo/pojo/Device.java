package com.ups.demo.pojo;

import org.springframework.stereotype.Component;

@Component
public class Device {
    private Integer intDeviceId;

    private Integer intCoreId;

    private Integer intUserId;

    private String strDeviceName;

    private String strDeviceAddress;

    public Integer getIntDeviceId() {
        return intDeviceId;
    }

    public void setIntDeviceId(Integer intDeviceId) {
        this.intDeviceId = intDeviceId;
    }

    public Integer getIntCoreId() {
        return intCoreId;
    }

    public void setIntCoreId(Integer intCoreId) {
        this.intCoreId = intCoreId;
    }

    public Integer getIntUserId() {
        return intUserId;
    }

    public void setIntUserId(Integer intUserId) {
        this.intUserId = intUserId;
    }

    public String getStrDeviceName() {
        return strDeviceName;
    }

    public void setStrDeviceName(String strDeviceName) {
        this.strDeviceName = strDeviceName == null ? null : strDeviceName.trim();
    }

    public String getStrDeviceAddress() {
        return strDeviceAddress;
    }

    public void setStrDeviceAddress(String strDeviceAddress) {
        this.strDeviceAddress = strDeviceAddress == null ? null : strDeviceAddress.trim();
    }
}