package com.example.android_2022.chapter02;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android_2022.R;

public class MainActivity10_2 extends AppCompatActivity {
    //初始化控件
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10_2);
        //找到控件
        textView = findViewById(R.id.textView);
        //获取第一个页面的信使
        Intent intent = getIntent();
        //接收第一个页面传来的数据
        String name  = intent.getStringExtra("username");
        String classname = intent.getStringExtra("classname");
        //修改静态文本
        textView.setText("姓名："+name+"，班级："+classname);
    }
}