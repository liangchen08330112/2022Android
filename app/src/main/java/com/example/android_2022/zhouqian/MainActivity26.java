package com.example.android_2022.zhouqian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android_2022.R;

public class MainActivity26 extends AppCompatActivity {

    private Button button;
    MyOrderedReceiver1 receiver1;
    MyOrderedReceiver2 receiver2;
    MyOrderedReceiver3 receiver3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main26);
        registerReceiver();
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("Intercept_stitch");
                MyOrderedReceiver3 receiver3 = new MyOrderedReceiver3();
                sendOrderedBroadcast(intent,null,receiver3,null,0,null,null);
            }
        });
    }

    private void registerReceiver() {
        receiver1 = new MyOrderedReceiver1();
        IntentFilter filter1 = new IntentFilter();
        filter1.setPriority(1000);
        filter1.addAction("Intercept_stitch");
        registerReceiver(receiver1,filter1);
        receiver2 = new MyOrderedReceiver2();
        IntentFilter filter2 = new IntentFilter();
        filter2.setPriority(200);
        filter2.addAction("Intercept_stitch");
        registerReceiver(receiver2,filter2);
        IntentFilter filter3 = new IntentFilter();
        filter3.setPriority(600);
        filter3.addAction("Intercept_stitch");
        registerReceiver(receiver3,filter3);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver1);
        unregisterReceiver(receiver2);
        unregisterReceiver(receiver3);
    }
}