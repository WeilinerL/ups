package com.ups.demo.pojo;

import org.springframework.stereotype.Component;

@Component
public class DeviceType {
    private Integer intDtypeId;

    private String strTypeName;

    public Integer getIntDtypeId() {
        return intDtypeId;
    }

    public void setIntDtypeId(Integer intDtypeId) {
        this.intDtypeId = intDtypeId;
    }

    public String getStrTypeName() {
        return strTypeName;
    }

    public void setStrTypeName(String strTypeName) {
        this.strTypeName = strTypeName == null ? null : strTypeName.trim();
    }
}