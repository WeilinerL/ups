package com.ups.demo.pojo;

import org.springframework.stereotype.Component;

@Component
public class DeviceDetail {
    private Integer intDetailId;

    private Integer intDtypeId;

    private String strDeviceBrand;

    private String strDeviceSeries;

    private String strDeviceModel;

    public Integer getIntDetailId() {
        return intDetailId;
    }

    public void setIntDetailId(Integer intDetailId) {
        this.intDetailId = intDetailId;
    }

    public Integer getIntDtypeId() {
        return intDtypeId;
    }

    public void setIntDtypeId(Integer intDtypeId) {
        this.intDtypeId = intDtypeId;
    }

    public String getStrDeviceBrand() {
        return strDeviceBrand;
    }

    public void setStrDeviceBrand(String strDeviceBrand) {
        this.strDeviceBrand = strDeviceBrand == null ? null : strDeviceBrand.trim();
    }

    public String getStrDeviceSeries() {
        return strDeviceSeries;
    }

    public void setStrDeviceSeries(String strDeviceSeries) {
        this.strDeviceSeries = strDeviceSeries == null ? null : strDeviceSeries.trim();
    }

    public String getStrDeviceModel() {
        return strDeviceModel;
    }

    public void setStrDeviceModel(String strDeviceModel) {
        this.strDeviceModel = strDeviceModel == null ? null : strDeviceModel.trim();
    }
}