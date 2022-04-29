package com.example.android_2022.chapter01;

import android.view.View;
import android.widget.ImageView;

import com.example.android_2022.R;

public class MainActivity06_MyListener implements View.OnClickListener{
    int current;
    int[] imgSrc;
    ImageView imageView;

    //构造函数：当创建本对象时，必须传过来三个函数，为成员变量赋初值
    public MainActivity06_MyListener(int current, int[] imgSrc, ImageView imageView) {
        this.current = current;
        this.imgSrc = imgSrc;
        this.imageView = imageView;
    }

    @Override
    public void onClick(View view) {
        //如果点的是上一张
        if(view.getId()== R.id.button_up){
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
