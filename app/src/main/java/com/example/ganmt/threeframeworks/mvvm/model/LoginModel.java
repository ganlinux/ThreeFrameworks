package com.example.ganmt.threeframeworks.mvvm.model;


import com.example.ganmt.threeframeworks.net.API.LoginService;
import com.example.ganmt.threeframeworks.net.ServiceGenerator;
import com.example.ganmt.threeframeworks.mvvm.vm.MainViewModel;
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
public class LoginModel {
    private LoginService git;
    private MainViewModel viewModel;

    public LoginModel(MainViewModel viewModel) {
        this.viewModel = viewModel;
        this.git =  ServiceGenerator.createService(LoginService.class,"ganlinux");

    }

    public void login() {
        //binding.username.getText().toString()
        ReqLogin reqLogin = new ReqLogin();
        reqLogin.setUsername(viewModel.getUsername());
        reqLogin.setPassword(viewModel.getPassword());

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
                            viewModel.onFailure(responseBody.string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        viewModel.onFailure("responseBody  = null");
                    }
                } else {
                    //200
                    if (model.getUserId()!=null){
                        viewModel.onSuccess();
                    }else{
                        viewModel.onFailure("登录失败");
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                /*viewModel.setText("t = " + t.getMessage());
                viewModel.setPb(false);*/
                viewModel.onFailure(t.toString());
            }
        });
    }

}
