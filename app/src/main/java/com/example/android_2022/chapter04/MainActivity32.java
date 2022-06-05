package com.example.android_2022.chapter04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android_2022.R;

public class MainActivity32 extends AppCompatActivity {
    /**
     * 程序：使用AsyncTask实现开屏倒计时动画
     */

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main31);
        AsyncTaskClass task = new AsyncTaskClass();
        //倒计时五秒
        task.execute(5);
        initView();
    }

    private void initView() {
         button = findViewById(R.id.button);
         button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 //点击跳过按钮，立即关闭页面
                finish();
             }
         });
    }
    class AsyncTaskClass extends AsyncTask<Integer,Integer,Boolean> {
        //子线程执行耗时任务
        @Override
        protected Boolean doInBackground(Integer... integers) {
            int seconds = integers[0].intValue();
            while (seconds>0){
                publishProgress(seconds--);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            finish();
            return true;
        }
        //在后台耗时任务执行过程中，被doInBackground调用的publishProgress，会执行本方法定义的内容
        @Override
        protected void onProgressUpdate(Integer... values) {
            button.setText("跳过 0"+values[0].intValue());
        }
        //当耗时正常结束时，即doInBackground执行结束，调用本方法
        @Override
        protected void onPostExecute(Boolean aBoolean) {
            //如果倒计时结束，关闭页面
            if (aBoolean==true){
                finish();
            }
        }
    }
}