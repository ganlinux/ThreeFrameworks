package com.example.ganmt.threeframeworks.mvvm.model;

/**
 * @author ganmt
 *
 */
public interface OnLoginListener {


    public void onUsernameError();

    public void onPasswordError();

    public void onSuccess();

    public void onFailure(String reason);
}
