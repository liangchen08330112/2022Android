package com.example.android_2022.zhouqian;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

//使用向导创建Service
public class MyService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("MyService","服务已创建，并执行onCreate()方法。");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("MyService","服务已开启，并执行onStartCommand()方法。");
        return super.onStartCommand(intent, flags, startId);
    }

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
//        throw new UnsupportedOperationException("Not yet implemented");
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("MyService","服务已关闭，并执行onDestroy()方法。");
    }
}