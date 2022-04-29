package com.example.android_2022.chapter02;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android_2022.R;

public class MainActivity09_2 extends AppCompatActivity {
    //初始化控件
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main09_2);
        //使用findViewById找到控件
        textView = findViewById(R.id.textView);
        //获取Intent对象
        Intent intent = getIntent();
        //向Intent对象中获取Bundle对象
        Bundle bundle = intent.getExtras();
        //从Bundle中获取用户名和密码字符串
        String name = bundle.getString("name");
        String password = bundle.getString("password");
        //如果用户名为liangchen，密码为202108330112
        if(name.equals("liangchen")&&password.equals("202108330112")){
            textView.setText("你好，"+name+"，欢迎回来！"); //TextView显示登录成功
        }else {
            textView.setText("登录失败，"+name);  //如果用户名或密码不符，登录失败。
        }
    }
}