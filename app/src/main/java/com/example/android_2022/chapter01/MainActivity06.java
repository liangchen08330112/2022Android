package com.example.android_2022.chapter01;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android_2022.R;

public class MainActivity06 extends AppCompatActivity {

    //1.资源准备(包括了变量、图片和控件)
    int[] imgSrc = {R.drawable.t301_chicken, R.drawable.t301_cow, R.drawable.t301_dog,
            R.drawable.t301_horse, R.drawable.t301_mokey, R.drawable.t301_rat};
    int current = 0; //当前播放到第几张图片
    //初始化图片资源
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main06);
        //利用findViewById找到控件
        Button button_up = findViewById(R.id.button_up);
        Button button_down = findViewById(R.id.button_down);
        imageView = findViewById(R.id.imageView);
        //引入一个外部类，同时新建对象
        MainActivity06_MyListener listener = new MainActivity06_MyListener(current,imgSrc,imageView);
        //为上一张、下一张按钮绑定事件监听器
        button_down.setOnClickListener(listener);
        button_up.setOnClickListener(listener);
    }
}