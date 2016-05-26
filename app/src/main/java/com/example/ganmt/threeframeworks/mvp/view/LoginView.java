package com.example.ganmt.threeframeworks.mvp.view;

/**
 * @author ganmt
 *
 */
public interface LoginView {

    //Toast
    void showToast(String msg);

    //获取界面的姓名
    String getName();

    //获取界面的密码
    String getPassword();
}
