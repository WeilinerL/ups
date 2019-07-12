package com.ups.demo.pojo;

public class PointTable {
    private String strTableId;

    private String strNumberType;

    private String strDataType;

    private String strDataName;

    private String strReadValues;

    private String strAnalyticalFormula;

    private String strParsedValues;

    private String strDataAddress;

    private String strBits;

    private String strUnit;

    private String strCoreId;

    public String getStrTableId() {
        return strTableId;
    }

    public void setStrTableId(String strTableId) {
        this.strTableId = strTableId == null ? null : strTableId.trim();
    }

    public String getStrNumberType() {
        return strNumberType;
    }

    public void setStrNumberType(String strNumberType) {
        this.strNumberType = strNumberType == null ? null : strNumberType.trim();
    }

    public String getStrDataType() {
        return strDataType;
    }

    public void setStrDataType(String strDataType) {
        this.strDataType = strDataType == null ? null : strDataType.trim();
    }

    public String getStrDataName() {
        return strDataName;
    }

    public void setStrDataName(String strDataName) {
        this.strDataName = strDataName == null ? null : strDataName.trim();
    }

    public String getStrReadValues() {
        return strReadValues;
    }

    public void setStrReadValues(String strReadValues) {
        this.strReadValues = strReadValues == null ? null : strReadValues.trim();
    }

    public String getStrAnalyticalFormula() {
        return strAnalyticalFormula;
    }

    public void setStrAnalyticalFormula(String strAnalyticalFormula) {
        this.strAnalyticalFormula = strAnalyticalFormula == null ? null : strAnalyticalFormula.trim();
    }

    public String getStrParsedValues() {
        return strParsedValues;
    }

    public void setStrParsedValues(String strParsedValues) {
        this.strParsedValues = strParsedValues == null ? null : strParsedValues.trim();
    }

    public String getStrDataAddress() {
        return strDataAddress;
    }

    public void setStrDataAddress(String strDataAddress) {
        this.strDataAddress = strDataAddress == null ? null : strDataAddress.trim();
    }

    public String getStrBits() {
        return strBits;
    }

    public void setStrBits(String strBits) {
        this.strBits = strBits == null ? null : strBits.trim();
    }

    public String getStrUnit() {
        return strUnit;
    }

    public void setStrUnit(String strUnit) {
        this.strUnit = strUnit == null ? null : strUnit.trim();
    }

    public String getStrCoreId() {
        return strCoreId;
    }

    public void setStrCoreId(String strCoreId) {
        this.strCoreId = strCoreId == null ? null : strCoreId.trim();
    }
}