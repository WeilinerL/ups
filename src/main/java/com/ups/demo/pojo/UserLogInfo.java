package com.ups.demo.pojo;

import org.springframework.stereotype.Component;

@Component
public class UserLogInfo {
    private String strUsername;

    private String strToken;

    private String strUserAgent;

    private String strLoginTime;

    public String getStrUsername() {
        return strUsername;
    }

    public void setStrUsername(String strUsername) {
        this.strUsername = strUsername == null ? null : strUsername.trim();
    }

    public String getStrToken() {
        return strToken;
    }

    public void setStrToken(String strToken) {
        this.strToken = strToken == null ? null : strToken.trim();
    }

    public String getStrUserAgent() {
        return strUserAgent;
    }

    public void setStrUserAgent(String strUserAgent) {
        this.strUserAgent = strUserAgent == null ? null : strUserAgent.trim();
    }

    public String getStrLoginTime() {
        return strLoginTime;
    }

    public void setStrLoginTime(String strLoginTime) {
        this.strLoginTime = strLoginTime == null ? null : strLoginTime.trim();
    }
}