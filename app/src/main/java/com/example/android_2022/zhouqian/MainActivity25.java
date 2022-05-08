package com.example.android_2022.zhouqian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android_2022.R;

public class MainActivity25 extends AppCompatActivity {

    private Button button;
    private MyReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main25);
        initView();
    }

    private void initView() {
        receiver = new MyReceiver();  //实例化广播接收器
        String action = "Help";
        IntentFilter filter = new IntentFilter(action);
        registerReceiver(receiver,filter);  //注册广播
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {  //按钮监听
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                //定义广播事件类型
                intent.setAction("Help");
                //发送广播
                sendBroadcast(intent);
            }
        });
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}