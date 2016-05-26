package com.example.ganmt.threeframeworks.mvp.model;

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
