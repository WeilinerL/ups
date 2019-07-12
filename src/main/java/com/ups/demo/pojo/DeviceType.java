package com.ups.demo.pojo;

public class DeviceType {
    private String strTypeId;

    private String strTypeName;

    private String strCoreId;

    public String getStrTypeId() {
        return strTypeId;
    }

    public void setStrTypeId(String strTypeId) {
        this.strTypeId = strTypeId == null ? null : strTypeId.trim();
    }

    public String getStrTypeName() {
        return strTypeName;
    }

    public void setStrTypeName(String strTypeName) {
        this.strTypeName = strTypeName == null ? null : strTypeName.trim();
    }

    public String getStrCoreId() {
        return strCoreId;
    }

    public void setStrCoreId(String strCoreId) {
        this.strCoreId = strCoreId == null ? null : strCoreId.trim();
    }
}