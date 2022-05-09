package com.example.android_2022.zhouqian;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.example.android_2022.R;

public class MainActivity21 extends AppCompatActivity {
    /**
     * 程序：Activity生命周期
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main21);
        Log.i("TAG","onCreate()方法被调用");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("TAG","onStart()方法被调用");
    }
    @Override
    protected void onResume() {
        Log.i("TAG","onResume()方法被调用");
        super.onResume();
    }
    protected void onPause() {
        Log.i("TAG","onPause()方法被调用");
        super.onPause();
    }
    protected void onStop() {
        Log.i("TAG","onStop()方法被调用");
        super.onStop();
    }
    protected void onDestroy(){
        Log.i("TAG","onDestroy()方法被调用");
        super.onDestroy();
    }
    protected void onRestart(){
        Log.i("TAG","onRestart()方法被调用");
        super.onRestart();
    }
}