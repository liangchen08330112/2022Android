package com.example.android_2022.zhouqian;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("MyReceiver","自定义广播接收者已接收求救广播。");
        Log.i("MyReceiver",intent.getAction());
    }
}