package com.example.ganmt.threeframeworks.net.request;

import com.google.gson.annotations.Expose;

/**
 * @author ganmt
 *
 */
public class ReqLogin {
    @Expose
    private String username;
    @Expose
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}