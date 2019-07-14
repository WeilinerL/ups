package com.ups.demo.pojo;

import org.springframework.stereotype.Component;

@Component
public class DeviceListHome {

    private String device_name;
    private String device_id;
    private String device_type;
    private String device_modle;
    private String device_status;

    public String getDevice_name() {
        return device_name;
    }

    public void setDevice_name(String device_name) {
        this.device_name = device_name;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getDevice_type() {
        return device_type;
    }

    public void setDevice_type(String device_type) {
        this.device_type = device_type;
    }

    public String getDevice_modle() {
        return device_modle;
    }

    public void setDevice_modle(String device_modle) {
        this.device_modle = device_modle;
    }

    public String getDevice_status() {
        return device_status;
    }

    public void setDevice_status(String device_statue) {
        this.device_status = device_statue;
    }
}
