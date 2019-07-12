package com.ups.demo.pojo;

public class ModelSeriesKey {
    private String strModelId;

    private String strSeriesId;

    public String getStrModelId() {
        return strModelId;
    }

    public void setStrModelId(String strModelId) {
        this.strModelId = strModelId == null ? null : strModelId.trim();
    }

    public String getStrSeriesId() {
        return strSeriesId;
    }

    public void setStrSeriesId(String strSeriesId) {
        this.strSeriesId = strSeriesId == null ? null : strSeriesId.trim();
    }
}