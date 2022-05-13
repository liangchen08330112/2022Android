package com.example.android_2022.zhouqian;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android_2022.R;

public class MainActivity27 extends AppCompatActivity implements View.OnClickListener {

    private Button button_start,button_stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main27);
        initView();
    }

    private void initView() {
        button_start = findViewById(R.id.button_start);
        button_stop = findViewById(R.id.button_stop);

        button_start.setOnClickListener(this);
        button_stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_start:
                //利用intent开启服务
                Intent intent = new Intent(MainActivity27.this,MyService.class);
                startService(intent);
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("提示").setIcon(R.drawable.ic_notice).setMessage("服务已开启");
                builder.setCancelable(true);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
                break;
            case R.id.button_stop:
                //利用intent关闭服务
                Intent intent1 = new Intent(MainActivity27.this,MyService.class);
                stopService(intent1);
                AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                builder1.setTitle("提示").setIcon(R.drawable.ic_notice).setMessage("服务已关闭");
                builder1.setCancelable(true);
                builder1.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog dialog2 = builder1.create();
                dialog2.show();
                break;
        }
    }
}