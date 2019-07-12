package com.ups.demo.pojo;

import java.util.Date;

public class Data {
    private String strDataId;

    private String strDataType;

    private Double doubleReadValues;

    private Date dataReadTime;

    private String strId;

    public String getStrDataId() {
        return strDataId;
    }

    public void setStrDataId(String strDataId) {
        this.strDataId = strDataId == null ? null : strDataId.trim();
    }

    public String getStrDataType() {
        return strDataType;
    }

    public void setStrDataType(String strDataType) {
        this.strDataType = strDataType == null ? null : strDataType.trim();
    }

    public Double getDoubleReadValues() {
        return doubleReadValues;
    }

    public void setDoubleReadValues(Double doubleReadValues) {
        this.doubleReadValues = doubleReadValues;
    }

    public Date getDataReadTime() {
        return dataReadTime;
    }

    public void setDataReadTime(Date dataReadTime) {
        this.dataReadTime = dataReadTime;
    }

    public String getStrId() {
        return strId;
    }

    public void setStrId(String strId) {
        this.strId = strId == null ? null : strId.trim();
    }
}