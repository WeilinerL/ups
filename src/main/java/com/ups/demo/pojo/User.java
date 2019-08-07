package com.ups.demo.pojo;

import org.springframework.stereotype.Component;

@Component
public class User {
    private Integer intUserId;

    private String strTelNumber;

    private String strPassword;

    private String strNickname;

    private String strSex;

    private String strRealName;

    private String strAddress;

    private String strEmail;

    private String strUserType;

    public Integer getIntUserId() {
        return intUserId;
    }

    public void setIntUserId(Integer intUserId) {
        this.intUserId = intUserId;
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

    public String getStrRealName() {
        return strRealName;
    }

    public void setStrRealName(String strRealName) {
        this.strRealName = strRealName == null ? null : strRealName.trim();
    }

    public String getStrAddress() {
        return strAddress;
    }

    public void setStrAddress(String strAddress) {
        this.strAddress = strAddress == null ? null : strAddress.trim();
    }

    public String getStrEmail() {
        return strEmail;
    }

    public void setStrEmail(String strEmail) {
        this.strEmail = strEmail == null ? null : strEmail.trim();
    }

    public String getStrUserType() {
        return strUserType;
    }

    public void setStrUserType(String strUserType) {
        this.strUserType = strUserType == null ? null : strUserType.trim();
    }
}