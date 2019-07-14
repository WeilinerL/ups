package com.ups.demo.pojo;

import org.springframework.stereotype.Component;

@Component
public class Data {
    private String strReadTime;

    private String strDataType;

    private String strDataName;

    private Double doubleReadValues;

    private Double doubleParsedValues;

    private String strDataAddress;

    private String strBits;

    private String strUnit;

    private String strNumberType;

    private String strId;

    public String getStrReadTime() {
        return strReadTime;
    }

    public void setStrReadTime(String strReadTime) {
        this.strReadTime = strReadTime == null ? null : strReadTime.trim();
    }

    public String getStrDataType() {
        return strDataType;
    }

    public void setStrDataType(String strDataType) {
        this.strDataType = strDataType == null ? null : strDataType.trim();
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

    public Double getDoubleParsedValues() {
        return doubleParsedValues;
    }

    public void setDoubleParsedValues(Double doubleParsedValues) {
        this.doubleParsedValues = doubleParsedValues;
    }

    public String getStrDataAddress() {
        return strDataAddress;
    }

    public void setStrDataAddress(String strDataAddress) {
        this.strDataAddress = strDataAddress == null ? null : strDataAddress.trim();
    }

    public String getStrBits() {
        return strBits;
    }

    public void setStrBits(String strBits) {
        this.strBits = strBits == null ? null : strBits.trim();
    }

    public String getStrUnit() {
        return strUnit;
    }

    public void setStrUnit(String strUnit) {
        this.strUnit = strUnit == null ? null : strUnit.trim();
    }

    public String getStrNumberType() {
        return strNumberType;
    }

    public void setStrNumberType(String strNumberType) {
        this.strNumberType = strNumberType == null ? null : strNumberType.trim();
    }

    public String getStrId() {
        return strId;
    }

    public void setStrId(String strId) {
        this.strId = strId == null ? null : strId.trim();
    }
}