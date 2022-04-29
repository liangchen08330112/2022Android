package com.example.android_2022.chapter02;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.example.android_2022.R;

public class MainActivity13 extends AppCompatActivity implements View.OnClickListener {
    /**
     * 程序：使用Intent开启和操作组件
     * 注意：本案例由于需要调用电话，因此需要向onCreate()方法和AndroidManifest.xml中声明权限。
     * 清单文件权限申请：<uses-permission android:name="android.permission.CALL_PHONE" />
     * onCreate()方法申请权限：ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE},0x11);
     */
    //初始化控件
    private Button button1,button2,button3,button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main13);
        //设置动态权限
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE},0x11);
        //初始化控件
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);

        //绑定点击事件监听器
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //新建Intent对象
        Intent intent = new Intent();
        switch (view.getId()){
            //点击拨打电话按钮
            case R.id.button1:
                intent.setAction(Intent.ACTION_CALL);
                Uri uri = Uri.parse("tel:0531-96190");
                intent.setData(uri);
                break;
            //点击发送短信按钮
            case R.id.button2:
                intent.setAction(Intent.ACTION_SENDTO);
                Uri uri2 = Uri.parse("smsto:15166867278");
                intent.setData(uri2);
                intent.putExtra("sms","程序测试");
                break;
            //点击浏览网页按钮
            case R.id.button3:
                intent.setAction(Intent.ACTION_VIEW);
                Uri uri3 = Uri.parse("http://www.baidu.com");
                intent.setData(uri3);
                break;
            //点击浏览相册按钮
            case R.id.button4:
                intent.setAction(Intent.ACTION_PICK);
                intent.setType("image/*");
                break;
        }
        startActivity(intent);
    }
}