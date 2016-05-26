package com.example.ganmt.threeframeworks.mvp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ganmt.threeframeworks.R;
import com.example.ganmt.threeframeworks.mvp.presenter.LoginPresenter;
import com.example.ganmt.threeframeworks.mvp.view.LoginView;

/**
 * @author ganmt
 *
 */
public class TestMVPActivity extends AppCompatActivity implements View.OnClickListener, LoginView {

    private EditText et_username;
    private EditText et_password;
    private Button btn_login;

    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_mvp);
        initViews();
        loginPresenter = new LoginPresenter(this);
    }


    private void initViews() {
        et_username = (EditText) findViewById(R.id.et_username);
        et_password = (EditText) findViewById(R.id.et_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch ( view.getId() ) {
            case R.id.btn_login:
                loginPresenter.login();
                break;
            default:
                break;
        }
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public String getName() {
        return et_username.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return et_password.getText().toString().trim();
    }
}
