package com.ups.demo.pojo;

import org.springframework.stereotype.Component;

@Component
public class BrandTypeKey {
    private String strBrandId;

    private String strTyprId;

    public String getStrBrandId() {
        return strBrandId;
    }

    public void setStrBrandId(String strBrandId) {
        this.strBrandId = strBrandId == null ? null : strBrandId.trim();
    }

    public String getStrTyprId() {
        return strTyprId;
    }

    public void setStrTyprId(String strTyprId) {
        this.strTyprId = strTyprId == null ? null : strTyprId.trim();
    }
}