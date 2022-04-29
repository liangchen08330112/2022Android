package com.example.android_2022.zhouqian;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.android_2022.R;

public class MainActivity24 extends AppCompatActivity {
    /**
     * 程序：拨号盘
     */
    //初始化静态文本
    private EditText editText;
    //初始化12个按钮0-9，*，#，和一个拨号按钮
    private Button button13,button2,button3,button4,button5,button6,button7,button8,button9,button10,button11,button12;
    private ImageButton imageButton_dial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main24);
        //权限申请
        ActivityCompat.requestPermissions(MainActivity24.this, new String[]{Manifest.permission.CALL_PHONE},0x11);
        initView();
    }

    private void initView() {
        editText = (EditText) findViewById(R.id.editText);
        button13 = (Button) findViewById(R.id.button13);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        button10 = (Button) findViewById(R.id.button10);
        button11 = (Button) findViewById(R.id.button11);
        button12 = (Button) findViewById(R.id.button12);
        imageButton_dial = (ImageButton) findViewById(R.id.imageButton18);

        button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.append(button13.getText().toString());
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.append(button2.getText().toString());
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.append(button3.getText().toString());
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.append(button4.getText().toString());
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.append(button5.getText().toString());
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.append(button6.getText().toString());
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.append(button7.getText().toString());
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.append(button8.getText().toString());
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.append(button9.getText().toString());
            }
        });
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.append(button10.getText().toString());
            }
        });
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.append(button11.getText().toString());
            }
        });
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editText.append(button12.getText().toString());
            }
        });
        imageButton_dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num =editText.getText().toString();
                Intent intent = new Intent();
                //确认意图的种类是想打电话
                intent.setAction( Intent.ACTION_CALL );
                //确定打电话的号码
                intent.setData( Uri.parse("tel:"+ num ) );//number 可以替换为固定的电话
                //开启意图
                startActivity( intent );
            }
        });
    }
}