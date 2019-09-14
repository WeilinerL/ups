package com.ups.demo.pojo;

import org.springframework.stereotype.Component;

@Component
public class DeviceGroup {
    private Integer intId;

    private String strLabel;

    private String strType;

    private String strShow;

    private String strChildren;

    public Integer getIntId() {
        return intId;
    }

    public void setIntId(Integer intId) {
        this.intId = intId;
    }

    public String getStrLabel() {
        return strLabel;
    }

    public void setStrLabel(String strLabel) {
        this.strLabel = strLabel == null ? null : strLabel.trim();
    }

    public String getStrType() {
        return strType;
    }

    public void setStrType(String strType) {
        this.strType = strType == null ? null : strType.trim();
    }

    public String getStrShow() {
        return strShow;
    }

    public void setStrShow(String strShow) {
        this.strShow = strShow == null ? null : strShow.trim();
    }

    public String getStrChildren() {
        return strChildren;
    }

    public void setStrChildren(String strChildren) {
        this.strChildren = strChildren == null ? null : strChildren.trim();
    }
}