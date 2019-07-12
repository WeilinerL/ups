package com.ups.demo.pojo;

public class DeviceManagerKey {
    private String strId;

    private String strUserId;

    public String getStrId() {
        return strId;
    }

    public void setStrId(String strId) {
        this.strId = strId == null ? null : strId.trim();
    }

    public String getStrUserId() {
        return strUserId;
    }

    public void setStrUserId(String strUserId) {
        this.strUserId = strUserId == null ? null : strUserId.trim();
    }
}