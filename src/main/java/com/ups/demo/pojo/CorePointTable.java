package com.ups.demo.pojo;

public class CorePointTable {
    private String strCoreId;

    private String strDataName;

    private String strDataRange;

    private String strDataUnit;

    private String strAlarmRules;

    public String getStrCoreId() {
        return strCoreId;
    }

    public void setStrCoreId(String strCoreId) {
        this.strCoreId = strCoreId == null ? null : strCoreId.trim();
    }

    public String getStrDataName() {
        return strDataName;
    }

    public void setStrDataName(String strDataName) {
        this.strDataName = strDataName == null ? null : strDataName.trim();
    }

    public String getStrDataRange() {
        return strDataRange;
    }

    public void setStrDataRange(String strDataRange) {
        this.strDataRange = strDataRange == null ? null : strDataRange.trim();
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