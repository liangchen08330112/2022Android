package com.example.android_2022.zhouqian;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.android_2022.R;

public class MainActivity29 extends AppCompatActivity implements View.OnClickListener, View.OnKeyListener {

    /**
     * 前面声明：本案例建议在电脑上通过虚拟手机来完成，因为真机自带的软键盘无法实现按钮监听，并且现在市面上带物理按键的手机几乎绝迹。
     * 但不排除有些电脑的原因，导致只能实现单击监听而无法实现键盘监听，建议自己拉取本代码，尝试操作。
     */
    //图片按钮数组
    ImageButton[] buttons = new ImageButton[2];
    //定义TextView
    private TextView textView_choose, textView_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main29);
        textView_choose = (TextView) findViewById(R.id.textView_choose);
        textView_info = (TextView) findViewById(R.id.textView_info);
        textView_info.setText("请使用键盘的A、B键控制按钮");
        //for循环，对两个按钮绑定单击事件和键盘事件监听器
        for (ImageButton button : buttons) {
            button.setOnClickListener(this);
            button.setOnKeyListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.imageButton:
                textView_choose.setText("您点击了按钮A");
                break;
            case R.id.imageButton2:
                textView_choose.setText("您点击了按钮B");
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_A:  //按下A
                buttons[0].performClick();
                buttons[0].requestFocus();
                break;
            case KeyEvent.KEYCODE_B:  //按下B
                buttons[1].performClick();
                buttons[1].requestFocus();
                break;
            default:
                break;
        }
        return false;
    }
}