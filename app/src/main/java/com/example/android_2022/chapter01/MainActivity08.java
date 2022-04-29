package com.example.android_2022.chapter01;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android_2022.R;

public class MainActivity08 extends AppCompatActivity {
    //初始化控件
    private EditText editText_password01, editText_password02;
    private TextView textView_check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main08);
        //利用findViewById找到控件
        editText_password01 = findViewById(R.id.editText_password01);
        editText_password02 = findViewById(R.id.editText_password02);
        textView_check = findViewById(R.id.textView_check);
        //对第二个输入框，即密码确认框，绑定键盘事件监听器
        editText_password02.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                //定义并初始化两个字符串，并设置为无字符。
                String password1 = "";
                String password2 = "";
                //松开时  （放下为ACTION_DOWN）
                if(keyEvent.getAction()==keyEvent.ACTION_UP){
                    //将输入内容转为字符串，并传入password1和password2（trim为掐头去尾）
                    password1 = editText_password01.getText().toString().trim();
                    password2 = editText_password02.getText().toString().trim();
                    if(password1.equals(password2)){ //如果两次密码一致
                        textView_check.setText("两次密码输入一致！");
                    }else{ //如果两次密码不一致
                        textView_check.setText("两次密码输入不一致！");
                    }
                }
                //return false为事件已处理，无需传播。建议为false。
                return false;
            }
        });
    }
}