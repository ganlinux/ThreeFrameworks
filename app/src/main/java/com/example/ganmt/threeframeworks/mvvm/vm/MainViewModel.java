package com.example.ganmt.threeframeworks.mvvm.vm;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.example.ganmt.threeframeworks.BR;
import com.example.ganmt.threeframeworks.mvvm.model.OnLoginListener;


/**
 * @author ganmt
 * 数据绑定
 * 调用acticity基本的提示
 *
 */
public class MainViewModel extends BaseObservable implements OnLoginListener{
    private LoginView loginView;
    private String username;
    public MainViewModel(LoginView loginView) {
        this.loginView = loginView;
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    private String password;

    @Bindable
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
        notifyPropertyChanged(BR.username);
    }



    @Override
    public void onUsernameError() {
        loginView.showToast("用户名错误");
    }

    @Override
    public void onPasswordError() {
        loginView.showToast("密码错误");
    }

    @Override
    public void onSuccess() {
        loginView.showToast("登陆成功");
    }

    @Override
    public void onFailure(String reason) {
        loginView.showToast("请求失败,"+reason);
    }
}
