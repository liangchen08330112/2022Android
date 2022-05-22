package com.example.android_2022.zhouqian;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android_2022.R;

public class MainActivity30 extends AppCompatActivity implements View.OnClickListener {

    /**
     * 匿名内部类，自身实现，基于回调方法实现单击监听。
     */
    private Button button1,button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main30);
        initView();
    }

    private void initView() {
        button1 = (Button) findViewById(R.id.button1);
        button3 = (Button) findViewById(R.id.button3);
        button1.setOnClickListener(this);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity30.this,"按钮3已点击",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(this,"按钮1已被点击",Toast.LENGTH_SHORT).show();
    }
    public void onclick(View view){
        Toast.makeText(this,"按钮2被点击",Toast.LENGTH_SHORT).show();
    }
}