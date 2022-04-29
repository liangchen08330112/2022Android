package com.example.android_2022.chapter01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android_2022.R;

public class MainActivity05 extends AppCompatActivity {
    //初始化图片资源
    int[] imgSrc = {R.drawable.t301_chicken,R.drawable.t301_cow,R.drawable.t301_dog,R.drawable.t301_horse,R.drawable.t301_rat,R.drawable.t301_mokey};
    //当前播放到第几张图片
    int current = 0;
    //初始化ImageView控件
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main05);
        //利用findViewById找到控件
        imageView = findViewById(R.id.imageView);
        Button button_up = findViewById(R.id.button_up);
        Button button_down = findViewById(R.id.button_down);
        //设置内部类单击事件监听器
        button_up.setOnClickListener(new MyListener());
        button_down.setOnClickListener(new MyListener());
    }
    //内部类实现的事件监听器
    class MyListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //如果点的是上一张
            if(view.getId()==R.id.button_up){
                if(current==0){ //当前在第一页，第一页的上一页是最后一张
                    current = imgSrc.length-1;
                }else {
                    //自减
                    current--;
                    //显示图片
                    imageView.setImageResource(imgSrc[current]); //显示出数组中的第current张图片。
                }
            }else if(view.getId()==R.id.button_down){ //如果被点击的是下一张
                if(current==imgSrc.length-1){ //最后一页的下一页是第一页
                    current = 0;
                }else{
                    //自增
                    current++;
                    //显示图片
                    imageView.setImageResource(imgSrc[current]);
                }
            }
        }
    }
}