package com.example.ganmt.threeframeworks.mvp.presenter;


import com.example.ganmt.threeframeworks.mvp.model.LoginModel;
import com.example.ganmt.threeframeworks.mvp.model.OnLoginListener;
import com.example.ganmt.threeframeworks.mvp.model.imple.LoginModelImple;
import com.example.ganmt.threeframeworks.mvp.view.LoginView;

/**
 * @author ganmt
 *
 */
public class LoginPresenter implements OnLoginListener {

    private LoginModel loginModel;
    private LoginView loginView;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
        loginModel = new LoginModelImple();
    }


    public void login() {
        String name = loginView.getName();
        String password = loginView.getPassword();
        loginModel.login(name, password, this);
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
        loginView.showToast("登录成功");
    }

    @Override
    public void onFailure(String reason) {
        loginView.showToast("请求失败,"+reason);
    }
}
