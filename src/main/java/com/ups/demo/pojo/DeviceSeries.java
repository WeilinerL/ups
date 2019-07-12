package com.ups.demo.pojo;

public class DeviceSeries {
    private String strSeriesId;

    private String strSeriesName;

    public String getStrSeriesId() {
        return strSeriesId;
    }

    public void setStrSeriesId(String strSeriesId) {
        this.strSeriesId = strSeriesId == null ? null : strSeriesId.trim();
    }

    public String getStrSeriesName() {
        return strSeriesName;
    }

    public void setStrSeriesName(String strSeriesName) {
        this.strSeriesName = strSeriesName == null ? null : strSeriesName.trim();
    }
}