package com.example.android_2022.chapter04;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import com.example.android_2022.R;

public class MainActivity31 extends AppCompatActivity {
    /**
     * 程序：用Handler实现应用倒计时开屏广告
     */
    private Button button;
    Handler handler;
    //5秒倒计时
    int seconds = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main31);
        button = findViewById(R.id.button);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        Runnable runnable = new Runnable() {
            @Override
            //循环：如果倒计时大于0，则反复执行。
            public void run() {
                while (seconds>0){
                    //创建Message对象
                    Message message = new Message();//修改Message保存的信息
                    //修改Message保存的信息
                    message.what = 0;
                    message.arg1 = seconds--;
                    //将Message对象发送给主线程
                    handler.sendMessage(message);
                    //线程睡一秒
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                finish();
            }
        };
        //启动子线程
        new Thread(runnable).start();
        //主线程需要定义Handler对象，并重写其中处理Message的方法
        handler = new Handler(){
            public void handleMessage(Message message){
                //如果消息的what操作码为0，则修改倒计时
                if(message.what==0){
                    button.setText("跳过 0"+message.arg1);
                }
            }
        };
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}