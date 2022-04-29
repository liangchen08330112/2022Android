package com.example.android_2022.chapter02;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android_2022.R;

public class MainActivity10_1 extends AppCompatActivity {
    /**
     * 程序：用户信息确认
     */
    //初始化控件
    private EditText editText_username, editText_classname;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10_1);
        //找到控件
        editText_username = findViewById(R.id.editText_username);
        editText_classname = findViewById(R.id.editText_classname);
        button = findViewById(R.id.button);
        //设置单击事件监听
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //定义submit()提交方法
                submit();
            }
        });
    }

    private void submit() {
        //定义name，接受用户输入并转化为字符串
        String name = editText_username.getText().toString().trim();
        //如果姓名为空
        if(TextUtils.isEmpty(name)){
            Toast.makeText(this,"姓名为空",Toast.LENGTH_SHORT).show();
            return;
        }
        //定义classname，接受用户输入并转化为字符串
        String classname = editText_classname.getText().toString().trim();
        //如果班级为空
        if(TextUtils.isEmpty(classname)){
            Toast.makeText(this,"班级为空",Toast.LENGTH_SHORT).show();
            return;
        }
        //新建Intent信使对象，在跳转的同时传递数据
        Intent intent = new Intent(MainActivity10_1.this,MainActivity10_2.class);
        //放入两个数据
        intent.putExtra("username",name);
        intent.putExtra("classname",classname);
        //跳转
        startActivity(intent);
    }
}