package com.example.ganmt.threeframeworks.mvp.model;

/**
 * @author ganmt
 *
 */
public interface LoginModel {

    void login(String name, String password, OnLoginListener onLoginListener);
}
