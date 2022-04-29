package com.example.android_2022.chapter02;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.android_2022.R;

public class MainActivity14 extends AppCompatActivity implements View.OnClickListener {
    /**
     * 程序：联系人管理
     */
    private Button button_new,button_edit,button_see,button_seeAll;
    private EditText editText_number1,editText_number2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main14);
        button_new = findViewById(R.id.button_new);
        button_edit = findViewById(R.id.button_edit);
        button_see = findViewById(R.id.button_see);
        button_seeAll = findViewById(R.id.button_seeAll);
        editText_number1 = findViewById(R.id.editText_number1);
        editText_number2 = findViewById(R.id.editText_number2);

        button_new.setOnClickListener(this);
        button_edit.setOnClickListener(this);
        button_see.setOnClickListener(this);
        button_seeAll.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //新建一个Intent对象
        Intent intent = new Intent();
        //新建一个Uri对象，暂时为空
        Uri uri = null;
        switch (view.getId()){
            //点击新建联系人
            case R.id.button_new:
                //调用联系人的新建或编辑功能
                intent.setAction(Intent.ACTION_INSERT_OR_EDIT);
                uri = Uri.parse("content://com.android.contacts/contacts/1");
                break;
            case R.id.button_edit:
                //定义edit的String字符串，接收数据
                String edit = editText_number1.getText().toString().trim();
                if(TextUtils.isEmpty(edit)){
                    Toast.makeText(this,"编号不得为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                //调用联系人编辑
                intent.setAction(Intent.ACTION_EDIT);
                uri = Uri.parse("content://com.android.contacts/contacts/"+edit);
                break;
            //查看联系人
            case R.id.button_see:
                //定义check的String字符串，接收数据
                String check = editText_number2.getText().toString().trim();
                if(TextUtils.isEmpty(check)){
                    Toast.makeText(this,"编号不得为空",Toast.LENGTH_SHORT).show();
                    return;
                }
                //调用联系人查看
                intent.setAction(Intent.ACTION_VIEW);
                uri = Uri.parse("content://com.android.contacts/contacts/"+check);
                break;
            //查看所有联系人
            case R.id.button_seeAll:
                //调用联系人查看
                intent.setAction(Intent.ACTION_VIEW);
                //联系人列表
                uri = Uri.parse("content://contacts/people");
                break;
        }
        //调用setData()方法并传入参数
        intent.setData(uri);
        //启动Activity
        startActivity(intent);
    }
}