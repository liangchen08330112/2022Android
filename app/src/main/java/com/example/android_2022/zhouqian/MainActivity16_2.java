package com.example.android_2022.zhouqian;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android_2022.R;

import java.util.Map;

public class MainActivity16_2 extends AppCompatActivity {
    private EditText editText_number, editText_password;
    private ImageView button_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main16_2);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        initView();
        Map<String, String> userInfo = FileSave.getUserInfo(this);
        if (userInfo != null) {
            editText_number.setText(userInfo.get("account"));   //将获取的账号显示到界面上
            editText_password.setText(userInfo.get("password")); //将获取的密码显示到界面上
        }
    }

    private void initView() {
        editText_number = findViewById(R.id.editText_number);
        editText_password = findViewById(R.id.editText_password);
        button_login = findViewById(R.id.button_login);

        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account = editText_number.getText().toString().trim();
                String password = editText_password.getText().toString();
                if(TextUtils.isEmpty(account)){
                    Toast.makeText(MainActivity16_2.this,"请输入帐号",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    Toast.makeText(MainActivity16_2.this,"请输入密码",Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(MainActivity16_2.this,"登录成功",Toast.LENGTH_SHORT).show();
                boolean isSuccess = FileSave.saveUserInfo(MainActivity16_2.this,account,password);
                if(isSuccess){
                    AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity16_2.this);
                    builder.setTitle("提示").setMessage("信息保存成功").setIcon(R.drawable.ic_zhengque)
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }else{
                    AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity16_2.this);
                    builder.setTitle("提示").setMessage("信息保存失败").setIcon(R.drawable.ic_jinggao)
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });
    }
}