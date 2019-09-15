package com.ups.demo.pojo;

import org.springframework.stereotype.Component;

@Component
public class Device {
    private Integer intDeviceId;

    private Integer intCoreId;

    private Integer intUserId;

    private String strSharedUserId;

    private String strDeviceName;

    private String strDeviceAddress;

    private String strCodeId;

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

    public String getStrSharedUserId() {
        return strSharedUserId;
    }

    public void setStrSharedUserId(String strSharedUserId) {
        this.strSharedUserId = strSharedUserId == null ? null : strSharedUserId.trim();
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

    public String getStrCodeId() {
        return strCodeId;
    }

    public void setStrCodeId(String strCodeId) {
        this.strCodeId = strCodeId == null ? null : strCodeId.trim();
    }
}