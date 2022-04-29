package com.example.android_2022.chapter02;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android_2022.R;

public class MainActivity17 extends AppCompatActivity {
    /**
     * 程序：观察Activity生命周期。
      * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main17);
        Log.i("MainActivity17","调用onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity17","调用onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivity17","调用onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainActivity17","调用onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainActivity17","调用onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity17","调用onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("MainActivity17","调用onRestart()");
    }
}