package com.example.android_2022.chapter02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_2022.R;

public class MainActivity18 extends AppCompatActivity {
    /**
     * 程序：调查问卷。
     */
    //初始化控件
    private RadioGroup radioGroup;
    private CheckBox checkBox_watching, checkBox_playing, checkBox_eating,checkBox_loving;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main18);
        //找到控件
        radioGroup = findViewById(R.id.radioGroup);
        checkBox_watching = findViewById(R.id.checkBox_watching);
        checkBox_playing = findViewById(R.id.checkBox_playing);
        checkBox_eating = findViewById(R.id.checkBox_eating);
        checkBox_loving = findViewById(R.id.checkBox_loving);
        button = findViewById(R.id.button);
        //为单选按钮组绑定事件监听器
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if(checkedId == R.id.radioButton_male){ //男性
                    Toast.makeText(MainActivity18.this, "您选中了：男性", Toast.LENGTH_SHORT).show();
                }else{  //女性
                    Toast.makeText(MainActivity18.this, "您选中了：女性", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //为按钮绑定事件监听器
        button.setOnClickListener(new View.OnClickListener() {
            String results = "";
            @Override
            public void onClick(View view) {
                if(checkBox_playing.isChecked()==true){  //打王者被选中
                    results += "打王者 ";
                }
                if(checkBox_watching.isChecked()==true){ //追剧被选中
                    results += "追剧 ";
                }
                if(checkBox_loving.isChecked()==true){ //泡妞被选中
                    results += "泡妞 ";
                }
                if(checkBox_eating.isChecked()==true){ //干饭被选中
                    results += "干饭 ";
                }
                //提示框
                Toast.makeText(MainActivity18.this, "您喜欢"+results, Toast.LENGTH_SHORT).show();
            }
        });
    }
}