package com.ups.demo.pojo;

public class Device {
    private String strId;

    private String strDeviceName;

    private String strModelId;

    public String getStrId() {
        return strId;
    }

    public void setStrId(String strId) {
        this.strId = strId == null ? null : strId.trim();
    }

    public String getStrDeviceName() {
        return strDeviceName;
    }

    public void setStrDeviceName(String strDeviceName) {
        this.strDeviceName = strDeviceName == null ? null : strDeviceName.trim();
    }

    public String getStrModelId() {
        return strModelId;
    }

    public void setStrModelId(String strModelId) {
        this.strModelId = strModelId == null ? null : strModelId.trim();
    }
}