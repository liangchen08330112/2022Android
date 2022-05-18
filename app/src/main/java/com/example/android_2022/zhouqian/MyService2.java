package com.example.android_2022.zhouqian;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MyService2 extends Service {
    public MyService2(){
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i("MyService2","服务已绑定，执行onBind()方法");
        return new MyBinder();
    }
    class MyBinder extends Binder {
        public void callMethodInService(){
            methodInService();
        }
    }

    private void methodInService() {
        Log.i("MyService2","执行服务中的methodInService()方法");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("MyService2","服务已创建，执行onCreate()方法。");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i("MyService2","服务已解绑，执行onUnBind()方法");
        return super.onUnbind(intent);
    }
}