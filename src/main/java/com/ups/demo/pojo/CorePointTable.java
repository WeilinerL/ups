package com.ups.demo.pojo;

import org.springframework.stereotype.Component;

@Component
public class CorePointTable {
    private Integer intCoreId;

    private Integer intDtypeId;

    private String strDataName;

    private Integer intDataRangeMin;

    private Integer intDataRangeMax;

    private String strDataUnit;

    private String strAlarmRules;

    public Integer getIntCoreId() {
        return intCoreId;
    }

    public void setIntCoreId(Integer intCoreId) {
        this.intCoreId = intCoreId;
    }

    public Integer getIntDtypeId() {
        return intDtypeId;
    }

    public void setIntDtypeId(Integer intDtypeId) {
        this.intDtypeId = intDtypeId;
    }

    public String getStrDataName() {
        return strDataName;
    }

    public void setStrDataName(String strDataName) {
        this.strDataName = strDataName == null ? null : strDataName.trim();
    }

    public Integer getIntDataRangeMin() {
        return intDataRangeMin;
    }

    public void setIntDataRangeMin(Integer intDataRangeMin) {
        this.intDataRangeMin = intDataRangeMin;
    }

    public Integer getIntDataRangeMax() {
        return intDataRangeMax;
    }

    public void setIntDataRangeMax(Integer intDataRangeMax) {
        this.intDataRangeMax = intDataRangeMax;
    }

    public String getStrDataUnit() {
        return strDataUnit;
    }

    public void setStrDataUnit(String strDataUnit) {
        this.strDataUnit = strDataUnit == null ? null : strDataUnit.trim();
    }

    public String getStrAlarmRules() {
        return strAlarmRules;
    }

    public void setStrAlarmRules(String strAlarmRules) {
        this.strAlarmRules = strAlarmRules == null ? null : strAlarmRules.trim();
    }
}