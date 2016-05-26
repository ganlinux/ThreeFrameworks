package com.example.ganmt.threeframeworks.net.response;

/**
 * @author ganmt
 *
 */
public class RspLogin {
    private int code;
    private String userId;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}