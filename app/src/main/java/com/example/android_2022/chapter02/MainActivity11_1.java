package com.example.android_2022.chapter02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android_2022.R;

public class MainActivity11_1 extends AppCompatActivity implements View.OnClickListener {
    /**
     * 程序：模拟充值服务
     */
    //初始化控件
    private Button button_phone, button_qb, button_vip;
    private TextView textView_title;
    //定义常量用作requestCode：
    public static final int PHONE_CODE = 0;
    public static final int VIP_CODE = 1;
    public static final int QB_CODE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11_1);
        //找到资源
        button_phone = findViewById(R.id.button_phone);
        button_qb = findViewById(R.id.button_qb);
        button_vip = findViewById(R.id.button_vip);
        textView_title = findViewById(R.id.textView_title);
        //设置单击事件监听器
        button_phone.setOnClickListener(this);
        button_qb.setOnClickListener(this);
        button_vip.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //新建Intent对象
        Intent intent = new Intent(MainActivity11_1.this,MainActivity11_2.class);
        switch (view.getId()){
            case R.id.button_phone:
                //设置requestCode并跳转界面
                startActivityForResult(intent,PHONE_CODE);  //充话费
                break;
            case R.id.button_vip:
                startActivityForResult(intent,VIP_CODE);  //续会员
                break;
            case R.id.button_qb:
                startActivityForResult(intent,QB_CODE);  //充Q币
                break;
        }
    }

    //回调：当从本页面启动的其他页面返回的时候，会自动调用回调方法。
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String str = "";  //初始化字符串为无字符
        if(requestCode==MainActivity11_2.ALIPAY_CODE){ //请求码为支付宝
            str += "通过支付宝";
        }else if(requestCode==MainActivity11_2.WECHAT_CODE){  //请求码为微信
            str += "通过微信支付";
        }
        //判断requestCode请求码：
        if(requestCode==PHONE_CODE){  //请求码为充话费
            str += "充值话费";
        }else if(requestCode==VIP_CODE){  //请求码续会员
            str += "续费会员";
        }else if(requestCode==QB_CODE){  //请求码为充Q币
            str += "充值Q币";
        }
        //获取第二个页面传回的数据
        if(data!=null){
            int amount = data.getIntExtra("amount",0);
            str += "金额"+amount+"元";
        }
        //把结果展示在Toast提示框中
        Toast.makeText(MainActivity11_1.this,str,Toast.LENGTH_SHORT).show();
        //如果是从第二个界面返回的，那么更改本页面的TextView内容（显示充值成功）
        if(str.length()!=0){
            textView_title.setText("充值成功，是否继续支付？");
        }
    }
}