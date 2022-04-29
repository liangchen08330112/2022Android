package com.example.android_2022.chapter02;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android_2022.R;

public class MainActivity19 extends AppCompatActivity {
    /**
     * 程序：多选对话框
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main19);
        //新建对话框构造器
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //设置标题
        builder.setTitle("你喜欢吃什么？");
        //设定数据
        String[] items = new String[]{"麻辣烫","泡面","火锅","炒菜"};
        //将所有数据设置为未选中状态
        boolean[] checkedItems = new boolean[]{false,false,false,false};
        //绑定多选按钮监听器
        builder.setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
                checkedItems[which] = isChecked;
            }
        });
        //点击确定按钮时
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                //新建StringBuffer对象
                StringBuffer buffer = new StringBuffer();
                //for循环，如果选中了，“”会被数据取代掉
                for(int i=0;i<=checkedItems.length-1;i++){
                    if(checkedItems[i]){
                        buffer.append(items[i]).append(" ");
                    }
                }
                //如果选项不是空的
                if(buffer!=null){
                    Toast.makeText(MainActivity19.this, "你喜欢吃"+buffer, Toast.LENGTH_SHORT).show();
                }
                //对话框消失
                dialogInterface.dismiss();
            }
        });
        //点击取消按钮时
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //对话框消失
                dialogInterface.dismiss();
            }
        });
        //创建对话框
        AlertDialog dialog = builder.create();
        //显示对话框
        dialog.show();
    }
}