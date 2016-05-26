package com.example.ganmt.threeframeworks;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.ganmt.threeframeworks.mvc.TestMVCActivity;
import com.example.ganmt.threeframeworks.mvp.ui.TestMVPActivity;
import com.example.ganmt.threeframeworks.mvvm.TestMVVMActivity;
/**
 * @author ganmt
 *
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_testmvc = (Button) findViewById(R.id.btn_testmvc);
        btn_testmvc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TestMVCActivity.class));
            }
        });
        Button btn_testmvp = (Button) findViewById(R.id.btn_testmvp);
        btn_testmvp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TestMVPActivity.class));
            }
        });
        Button btn_testmvvm = (Button) findViewById(R.id.btn_testmvvm);
        btn_testmvvm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TestMVVMActivity.class));
            }
        });
    }
}
