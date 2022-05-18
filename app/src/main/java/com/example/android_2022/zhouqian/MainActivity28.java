package com.example.android_2022.zhouqian;

import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.android_2022.R;

public class MainActivity28 extends AppCompatActivity implements View.OnClickListener {
    private Button button_bind, button_call, button_unbind;
    private MyConnection connection;  //Actitivity与服务的连接
    private MyService2.MyBinder myBinder;  //服务代理
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main28);
        initView();
    }

    private void initView() {
        //关联资源
        button_bind = findViewById(R.id.button_bind);    //绑定服务
        button_call = findViewById(R.id.button_call);    //调用服务中的方法
        button_unbind = findViewById(R.id.button_unbind);//解绑服务
        //事件监听
        button_bind.setOnClickListener(this);
        button_call.setOnClickListener(this);
        button_unbind.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button_bind:   //绑定服务
                if(connection==null){
                    connection = new MyConnection();  //如果Activity与服务之间没有连接，就新建一个连接对象
                }
                Intent intent = new Intent(MainActivity28.this,MyService2.class);  //新建Intent信使对象
                bindService(intent,connection,BIND_AUTO_CREATE);  //绑定服务
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setIcon(R.drawable.ic_zhengque).setTitle("提示").setMessage("服务绑定成功");
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
            case R.id.button_call:  //调用服务中的方法
                if(myBinder==null){
                    return;
                }
                myBinder.callMethodInService();  //调用服务中的方法
                AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                builder1.setIcon(R.drawable.ic_zhengque).setTitle("提示").setMessage("方法调用成功");
                builder1.setCancelable(true);
                builder1.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog dialog1 = builder1.create();
                dialog1.show();
                break;
            case R.id.button_unbind:  //解绑服务
                if(connection!=null){
                    unbindService(connection);  //如果存在服务，解绑服务
                    connection = null;  //断开连接
                    myBinder = null;  //取消绑定
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                    builder2.setTitle("提示").setIcon(R.drawable.ic_zhengque).setMessage("服务解绑成功");
                    builder2.setCancelable(true);
                    builder2.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    AlertDialog dialog2 =builder2.create();
                    dialog2.show();
                }else{
                    Toast.makeText(MainActivity28.this,"没有服务",Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }
    //定义MyConnection内部类，继承ServiceConnection
    private class MyConnection implements ServiceConnection{
        //成功绑定服务时调用的方法，用于获取MainActivity中的IBinder对象。
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            myBinder = (MyService2.MyBinder) iBinder;
            Log.i("TAG","服务已绑定，内存地址为："+myBinder.toString());
            Toast.makeText(MainActivity28.this,"服务绑定成功",Toast.LENGTH_SHORT).show();
        }
        //服务失去连接时调用的方法，暂不填充。
        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    }
}