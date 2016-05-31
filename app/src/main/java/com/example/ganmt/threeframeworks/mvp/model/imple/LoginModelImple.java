package com.example.ganmt.threeframeworks.mvp.model.imple;

import android.widget.Toast;

import com.example.ganmt.threeframeworks.mvp.model.LoginModel;
import com.example.ganmt.threeframeworks.mvp.model.OnLoginListener;
import com.example.ganmt.threeframeworks.mvp.ui.TestMVPActivity;
import com.example.ganmt.threeframeworks.net.API.LoginService;
import com.example.ganmt.threeframeworks.net.ServiceGenerator;
import com.example.ganmt.threeframeworks.net.request.ReqLogin;
import com.example.ganmt.threeframeworks.net.response.RspLogin;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author ganmt
 *
 */
public class LoginModelImple implements LoginModel {
    private LoginService git;
    public LoginModelImple() {
        this.git =  ServiceGenerator.createService(LoginService.class,"ganlinux");

    }
    @Override
    public void login(String username, String password, final OnLoginListener onLoginListener) {
        ReqLogin reqLogin = new ReqLogin();
        reqLogin.setUsername(username);
        reqLogin.setPassword(password);

        Call call = git.login(reqLogin);
        call.enqueue(new Callback<RspLogin>() {
            @Override
            public void onResponse(Response<RspLogin> response) {
                RspLogin model = response.body();

                if (model == null) {
                    //404 or the response cannot be converted to User.
                    ResponseBody responseBody = response.errorBody();
                    if (responseBody != null) {
                        try {
                            onLoginListener.onFailure(responseBody.string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        onLoginListener.onFailure("responseBody  = null");
                    }
                } else {
                    //200
                    if (model.getUserId()!=null){
                        onLoginListener.onSuccess();
                    }else{
                        onLoginListener.onFailure("登录失败");
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                onLoginListener.onFailure(t.toString());
            }
        });
    }
}
