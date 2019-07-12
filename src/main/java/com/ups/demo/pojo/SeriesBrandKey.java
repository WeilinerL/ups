package com.ups.demo.pojo;

public class SeriesBrandKey {
    private String strSeriesId;

    private String strBrandId;

    public String getStrSeriesId() {
        return strSeriesId;
    }

    public void setStrSeriesId(String strSeriesId) {
        this.strSeriesId = strSeriesId == null ? null : strSeriesId.trim();
    }

    public String getStrBrandId() {
        return strBrandId;
    }

    public void setStrBrandId(String strBrandId) {
        this.strBrandId = strBrandId == null ? null : strBrandId.trim();
    }
}