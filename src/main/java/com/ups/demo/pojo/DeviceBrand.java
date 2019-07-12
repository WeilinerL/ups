package com.ups.demo.pojo;

public class DeviceBrand {
    private String strBrandId;

    private String strBrandName;

    public String getStrBrandId() {
        return strBrandId;
    }

    public void setStrBrandId(String strBrandId) {
        this.strBrandId = strBrandId == null ? null : strBrandId.trim();
    }

    public String getStrBrandName() {
        return strBrandName;
    }

    public void setStrBrandName(String strBrandName) {
        this.strBrandName = strBrandName == null ? null : strBrandName.trim();
    }
}