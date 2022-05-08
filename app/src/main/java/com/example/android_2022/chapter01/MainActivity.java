package com.example.android_2022.chapter01;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android_2022.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //初始化控件
    Button button1, button2, button3,button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //利用findViewById找到资源
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        //Activity自身实现
        button1.setOnClickListener(this);
        //匿名内部类实现
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //生成Toast提示
                Toast.makeText(MainActivity.this,"匿名内部类实现",Toast.LENGTH_SHORT).show();
            }
        });
        //外部类实现
        button3.setOnClickListener(new MyListener());
        button4.setOnClickListener(new MyInnerListener());
    }

    @Override
    public void onClick(View view) {
        //生成Toast提示
        Toast.makeText(MainActivity.this,"Activity自身实现",Toast.LENGTH_SHORT).show();
    }
    class MyInnerListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this,"内部类实现",Toast.LENGTH_SHORT).show();
        }
    }
}

//定义MyListener外部类，实现单击事件监听器接口
class MyListener implements View.OnClickListener{

    @Override
    public void onClick(View view) {
        //生成Log日志
        Log.i("TAG","外部类实现");
    }
}