package com.example.ganmt.threeframeworks.mvvm;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.ganmt.threeframeworks.MainActivity;
import com.example.ganmt.threeframeworks.R;
import com.example.ganmt.threeframeworks.databinding.ActivityLoginMvvmBinding;
import com.example.ganmt.threeframeworks.mvvm.model.LoginModel;
import com.example.ganmt.threeframeworks.mvvm.vm.LoginView;
import com.example.ganmt.threeframeworks.mvvm.vm.MainViewModel;

/**
 * @author ganmt
 *
 */
public class TestMVVMActivity extends AppCompatActivity implements LoginView{

    private ActivityLoginMvvmBinding binding;
    private MainViewModel viewModel;
    private LoginModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login_mvvm);
        binding.setModel(viewModel = new MainViewModel(this));
        model = new LoginModel(viewModel);

        viewModel.setUsername("1");
        viewModel.setPassword("1");

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.setUsername(binding.tvUsername.getText().toString());
                viewModel.setPassword(binding.tvPassword.getText().toString());
                viewModel.notifyChange();
                model.login();
            }
        });
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show();
    }
}
