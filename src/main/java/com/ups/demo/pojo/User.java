package com.ups.demo.pojo;

public class User {
    private String strUserId;

    private String strTelNumber;

    private String strPassword;

    private String strNickname;

    private String strSex;

    private String strName;

    private String strAddress;

    private String strRank;

    public String getStrUserId() {
        return strUserId;
    }

    public void setStrUserId(String strUserId) {
        this.strUserId = strUserId == null ? null : strUserId.trim();
    }

    public String getStrTelNumber() {
        return strTelNumber;
    }

    public void setStrTelNumber(String strTelNumber) {
        this.strTelNumber = strTelNumber == null ? null : strTelNumber.trim();
    }

    public String getStrPassword() {
        return strPassword;
    }

    public void setStrPassword(String strPassword) {
        this.strPassword = strPassword == null ? null : strPassword.trim();
    }

    public String getStrNickname() {
        return strNickname;
    }

    public void setStrNickname(String strNickname) {
        this.strNickname = strNickname == null ? null : strNickname.trim();
    }

    public String getStrSex() {
        return strSex;
    }

    public void setStrSex(String strSex) {
        this.strSex = strSex == null ? null : strSex.trim();
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName == null ? null : strName.trim();
    }

    public String getStrAddress() {
        return strAddress;
    }

    public void setStrAddress(String strAddress) {
        this.strAddress = strAddress == null ? null : strAddress.trim();
    }

    public String getStrRank() {
        return strRank;
    }

    public void setStrRank(String strRank) {
        this.strRank = strRank == null ? null : strRank.trim();
    }
}