package com.example.android_2022.chapter01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android_2022.R;


public class MainActivity04 extends AppCompatActivity {
    /**
     * 程序四：单击按钮计数器
     */
    //初始化控件
    private Button button;
    //初始化count次数为0
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main04);
        //利用findViewById找到控件
        button = findViewById(R.id.button);
        //设置单击事件监听器
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //次数自增
                count++;
                //修改按钮内文本
                button.setText("我被点击了"+count+"次");
            }
        });
    }
}