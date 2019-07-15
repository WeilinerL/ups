package com.ups.demo.pojo;

public class DeviceGroupKey {
    private String strGroupName;

    private String strDeviceId;

    public String getStrGroupName() {
        return strGroupName;
    }

    public void setStrGroupName(String strGroupName) {
        this.strGroupName = strGroupName == null ? null : strGroupName.trim();
    }

    public String getStrDeviceId() {
        return strDeviceId;
    }

    public void setStrDeviceId(String strDeviceId) {
        this.strDeviceId = strDeviceId == null ? null : strDeviceId.trim();
    }
}