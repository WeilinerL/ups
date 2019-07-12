package com.ups.demo.pojo;

public class DeviceModel {
    private String strModelId;

    private String strModelName;

    private String strTableId;

    public String getStrModelId() {
        return strModelId;
    }

    public void setStrModelId(String strModelId) {
        this.strModelId = strModelId == null ? null : strModelId.trim();
    }

    public String getStrModelName() {
        return strModelName;
    }

    public void setStrModelName(String strModelName) {
        this.strModelName = strModelName == null ? null : strModelName.trim();
    }

    public String getStrTableId() {
        return strTableId;
    }

    public void setStrTableId(String strTableId) {
        this.strTableId = strTableId == null ? null : strTableId.trim();
    }
}