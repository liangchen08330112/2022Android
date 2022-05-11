package com.example.android_2022.zhouqian;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyOrderedReceiver2 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("MyOrderedReceiver2","自定义广播接收者2已接收广播");
    }
}