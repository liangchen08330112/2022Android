package com.example.android_2022.chapter02;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android_2022.R;


public class MainActivity11_2 extends AppCompatActivity implements View.OnClickListener {

    private EditText editText_number;
    private Button button_wechat, button_alipay;
    //定义常量作为resultCode:
    public static final int ALIPAY_CODE = 0;
    public static final int WECHAT_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11_2);
        editText_number = (EditText) findViewById(R.id.editText_number);
        button_wechat = (Button) findViewById(R.id.button_wechat);
        button_alipay = (Button) findViewById(R.id.button_alipay);

        button_wechat.setOnClickListener(this);
        button_alipay.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //如果输入金额为空，会在界面底部输出“请输入充值金额”的提示
        String number = editText_number.getText().toString().trim();
        if(TextUtils.isEmpty(number)){
            Toast.makeText(this,"请输入充值金额",Toast.LENGTH_SHORT).show();
            return;
        }
        //将用户输入的String字符串转化为int类型
        int amount = Integer.parseInt(number);
        //将int值保存在Intent对象中，等待传递
        Intent intent = getIntent();
        intent.putExtra("amount",amount);
        switch (view.getId()){
            case R.id.button_alipay:
                //设置resultCode结果码，并传递数据给第一个界面
                setResult(ALIPAY_CODE,intent);
                break;
            case R.id.button_wechat:
                setResult(WECHAT_CODE,intent);
                break;
        }
        finish();
    }
}