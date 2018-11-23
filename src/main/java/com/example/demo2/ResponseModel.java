package com.example.demo2;

public class ResponseModel {

    private int responseFlag;
    private String responseMsg;
    private String sessionToken;

    public ResponseModel() {
    }

    public ResponseModel(int responseFlag, String responseMsg, String sessionToken) {
        this.responseFlag = responseFlag;
        this.responseMsg = responseMsg;
        this.sessionToken = sessionToken;
    }

    public int getResponseFlag() {
        return responseFlag;
    }

    public void setResponseFlag(int responseFlag) {
        this.responseFlag = responseFlag;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }
}
