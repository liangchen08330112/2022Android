package com.example.android_2022.chapter02;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android_2022.R;

public class MainActivity12 extends AppCompatActivity {
    /**
     * 程序：实现随手指拖动的小球
     */
    //资源准备
    private TextView textView_result;
    private ImageView ball;
    //设置起始和结束的X坐标和Y坐标
    float startX,startY,endX,endY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);
        textView_result = (TextView) findViewById(R.id.textView_result);
        ball = (ImageView) findViewById(R.id.ball);
        ball.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch(motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:  //触摸按下：获取小球初始触摸位置的X、Y坐标
                        //motionEvent.getRawX()：表示触摸点距离屏幕左边界的距离
                        //motionEvent.getRawY()：表示触摸点距离屏幕上边界的距离
                        startX = motionEvent.getRawX();
                        startY = motionEvent.getRawY();
                        break;
                    case MotionEvent.ACTION_MOVE:  //触摸移动：获取手指当前位置，并改变小球的位置
                        //获取当前手指触摸位置的X坐标和Y坐标
                        endX = motionEvent.getRawX();
                        endY = motionEvent.getRawY();
                        //设置小球的X、Y坐标为手指的当前位置
                        ball.setX(endX);
                        ball.setY(endY);
                        //设置break防止穿透。
                        break;
                    case MotionEvent.ACTION_UP:  //触摸抬起：计算小球的总体偏移方向，并输出在TextView
                        //获取当前手指触摸位置的X坐标和Y坐标
                        endX = motionEvent.getRawX();
                        endY = motionEvent.getRawY();
                        //计算小球偏移方向
                        String result = "移动方向：";
                        if(endX > startX) {
                            result += "右，";
                        }else if(endX < startX){
                            result += "左，";
                        }
                        if(endY > startY){
                            result += "下";
                        }else if(endY < startY){
                            result += "上";
                        }
                        textView_result.setText(result);
                        //设置break防止穿透。
                        break;
                }
                //return true：表示已处理该事件。
                //如果是false，表明事件未被处理。MOVE和UP等动作无法被监听。
                return true;
            }
        });
    }
}