package com.example.android_2022.chapter01;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_2022.R;


public class MainActivity01 extends AppCompatActivity implements View.OnClickListener {

    /**
     * 程序一：猜拳游戏
     */

    //准备图片资源
    int[] imgSrc= {R.drawable.t302_cloth,R.drawable.t302_scissors,R.drawable.t302_stone};
    //初始化控件
    private ImageView imageView_paper, imageView_scissors, imageView_stone, imageView_result;
    private TextView textView_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main01);
        //使用findViewById找到控件
        imageView_paper = findViewById(R.id.imageView_paper);
        imageView_scissors = findViewById(R.id.imageView_scissors);
        imageView_stone = findViewById(R.id.imageView_stone);
        imageView_result = findViewById(R.id.imageView_result);
        textView_result = findViewById(R.id.textView_result);

        //绑定事件监听器
        imageView_paper.setOnClickListener(this);
        imageView_scissors.setOnClickListener(this);
        imageView_stone.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //使用随机数来让电脑自动生成出拳
        int autoNumber = (int) (Math.random()*3);
        //显示电脑出拳
        imageView_result.setImageResource(imgSrc[autoNumber]);
        //结果判定
        switch (view.getId()){
            case R.id.imageView_paper:  //出布
                switch (autoNumber){
                    case 0:  //电脑出布
                        textView_result.setText("游戏结果：平局");
                        break;
                    case 1:  //电脑出剪子
                        textView_result.setText("游戏结果：电脑胜利");
                        break;
                    case 2:  //电脑出石头
                        textView_result.setText("游戏结果：你胜利");
                        break;
                    default:
                        break;
                }
                break;
            case R.id.imageView_scissors:  //出剪子
                switch (autoNumber){
                    case 0:  //电脑出布
                        textView_result.setText("游戏结果：你胜利");
                        break;
                    case 1:  //电脑出剪子
                        textView_result.setText("游戏结果：平局");
                        break;
                    case 2:  //电脑出石头
                        textView_result.setText("游戏结果：电脑胜利");
                        break;
                    default:
                        break;
                }
                break;
            case R.id.imageView_stone:  //出石头
                switch (autoNumber){
                    case 0:  //电脑出布
                        textView_result.setText("游戏结果：电脑胜利");
                        break;
                    case 1:  //电脑出剪子
                        textView_result.setText("游戏结果：你胜利");
                        break;
                    case 2:  //电脑出石头
                        textView_result.setText("游戏结果：平局");
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
    }
}