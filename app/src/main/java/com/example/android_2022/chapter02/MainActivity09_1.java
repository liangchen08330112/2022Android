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


public class MainActivity09_1 extends AppCompatActivity {

    private EditText editText_username, editText_password;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main09_1);
        editText_username = findViewById(R.id.editText_username);
        editText_password = findViewById(R.id.editText_password);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //定义提交方法
                submit();
                switch (view.getId()){
                    case R.id.button:
                        //创建Intent对象作为信使，回头用于传数据和跳转页面
                        Intent intent = new Intent(MainActivity09_1.this, MainActivity09_2.class);
                        intent.setClass(MainActivity09_1.this, MainActivity09_2.class);
                        //定义用户名和密码字符串接收用户输入，并转为字符串
                        String name = editText_username.getText().toString().trim();
                        String password = editText_password.getText().toString().trim();
                        //定义一个Bundle包裹对象
                        Bundle bundle = new Bundle();
                        //向Bundle包裹中放入用户名和密码
                        bundle.putString("name",name);
                        bundle.putString("password",password);
                        //将Bundle包裹传递给Intent
                        intent.putExtras(bundle);
                        //跳转
                        startActivity(intent);
                }
            }
        });
    }
    //提交方法
    private void submit(){
        //定义用户名，接收用户输入并转为字符串
        String name = editText_username.getText().toString().trim();
        //如果用户名为空，弹出提示
        if(TextUtils.isEmpty(name)){
            Toast.makeText(this,"用户名不得为空",Toast.LENGTH_SHORT).show();
            return;
        }
        //定义密码，接收用户输入并转为字符串
        String password = editText_password.getText().toString().trim();
        //如果密码为空，弹出提示
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"密码不得为空",Toast.LENGTH_SHORT).show();
            return;
        }
    }
}