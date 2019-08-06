package com.ups.demo.pojo;

import org.springframework.stereotype.Component;

@Component
public class Data {
    private String strReadTime;

    private Integer intDataId;

    private Integer intDeviceId;

    private String strDataName;

    private Double doubleReadValues;

    private String strNumberType;

    public String getStrReadTime() {
        return strReadTime;
    }

    public void setStrReadTime(String strReadTime) {
        this.strReadTime = strReadTime == null ? null : strReadTime.trim();
    }

    public Integer getIntDataId() {
        return intDataId;
    }

    public void setIntDataId(Integer intDataId) {
        this.intDataId = intDataId;
    }

    public Integer getIntDeviceId() {
        return intDeviceId;
    }

    public void setIntDeviceId(Integer intDeviceId) {
        this.intDeviceId = intDeviceId;
    }

    public String getStrDataName() {
        return strDataName;
    }

    public void setStrDataName(String strDataName) {
        this.strDataName = strDataName == null ? null : strDataName.trim();
    }

    public Double getDoubleReadValues() {
        return doubleReadValues;
    }

    public void setDoubleReadValues(Double doubleReadValues) {
        this.doubleReadValues = doubleReadValues;
    }

    public String getStrNumberType() {
        return strNumberType;
    }

    public void setStrNumberType(String strNumberType) {
        this.strNumberType = strNumberType == null ? null : strNumberType.trim();
    }
}