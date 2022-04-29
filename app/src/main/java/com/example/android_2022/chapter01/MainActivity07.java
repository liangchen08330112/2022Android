package com.example.android_2022.chapter01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_2022.R;

public class MainActivity07 extends AppCompatActivity {
    int[] imgSrc = {R.drawable.t301_mokey, R.drawable.t301_horse, R.drawable.t301_rat, R.drawable.t301_dog, R.drawable.t301_cow, R.drawable.t301_chicken};
    int current = 0;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main07);
        Button button_up = findViewById(R.id.button_up);
        Button button_down = findViewById(R.id.button_down);
        imageView = findViewById(R.id.imageView);

        button_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //显示上一页
                if (current == 0)
                    current = imgSrc.length-1;
                else
                    current--;
                //显示数组中的第current张图片
                imageView.setImageResource(imgSrc[current]);
            }
        });
        button_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (current == imgSrc.length-1)
                    current = 0;
                else
                    current++;
                imageView.setImageResource(imgSrc[current]);
            }
        });
    }
}