package com.example.ganmt.threeframeworks.mvc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.ganmt.threeframeworks.R;
import com.example.ganmt.threeframeworks.net.API.LoginService;
import com.example.ganmt.threeframeworks.net.ServiceGenerator;
import com.example.ganmt.threeframeworks.net.request.ReqLogin;
import com.example.ganmt.threeframeworks.net.response.RspLogin;
import com.google.gson.JsonObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
/**
 * @author ganmt
 *
 */
public class TestMVCActivity extends AppCompatActivity {
    private LoginService git;

    private EditText et_username;
    private EditText et_password;
    private Button btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_mvc);
        this.git =  ServiceGenerator.createService(LoginService.class,"ganlinux");

        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(et_username.getText().toString(),et_password.getText().toString());
            }
        });
    }



    public void login(String username, String password) {
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
                            Toast.makeText(TestMVCActivity.this,responseBody.string(),Toast.LENGTH_LONG).show();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Toast.makeText(TestMVCActivity.this,"responseBody  = null",Toast.LENGTH_LONG).show();
                    }
                } else {
                    //200
                    if (model.getUserId()!=null){
                        Toast.makeText(TestMVCActivity.this,"登录成功",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(TestMVCActivity.this,"登录失败",Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Toast.makeText(TestMVCActivity.this,t.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }

}
