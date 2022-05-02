package com.example.android_2022.chapter03;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_2022.R;

public class MainActivity22 extends AppCompatActivity implements View.OnClickListener {

    /**
     * 程序：利用SharedPreferences实现用户信息存储
     * @param savedInstanceState
     */
    //初始化控件
    private EditText editText_name;
    private Button button_save, button_read, button_refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);
        //关联控件
        editText_name = findViewById(R.id.editText_name);
        button_save = findViewById(R.id.button_save);
        button_read = findViewById(R.id.button_read);
        button_refresh = findViewById(R.id.button_refresh);
        //单击事件监听器
        button_save.setOnClickListener(this);
        button_read.setOnClickListener(this);
        button_refresh.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        //
        SharedPreferences preferences = getPreferences(Context.MODE_PRIVATE);
        switch (view.getId()){
            case R.id.button_save:  //保存
                //接收文本框输入数据
                String name = editText_name.getText().toString().trim();
                if(TextUtils.isEmpty(name)){
                    Toast.makeText(this,"用户名为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                //保存name进入SharedPreferences对象
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("name",name);
                editor.commit();
                break;
            case R.id.button_refresh:  //刷新
                editText_name.setText("");  //将输入框设为无字符状态
                break;
            case R.id.button_read:
                String username = preferences.getString("name","暂无数据");  //根据key值读取信息
                editText_name.setText(username);  //加载文本
                break;
            default:
                break;
        }
    }
}