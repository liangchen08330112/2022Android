package com.example.android_2022.zhouqian;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.android_2022.R;

public class MainActivity23 extends AppCompatActivity implements View.OnClickListener {
    //运用内部类MyHelper定义helper
    MyHelper helper;
    //初始化控件
    private EditText editText_name,editText_phone;
    private Button button_insert,button_delete,button_update,button_retrieve;
    private TextView textView_show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main23);
        //新建一个helper对象
        helper = new MyHelper(this);
        //隐藏标题栏
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        //关联资源
        editText_name = findViewById(R.id.editText_name);
        editText_phone = findViewById(R.id.editText_phone);
        button_insert = findViewById(R.id.button_insert);
        button_delete = findViewById(R.id.button_delete);
        button_update = findViewById(R.id.button_update);
        textView_show = findViewById(R.id.textView_show);
        button_retrieve = findViewById(R.id.button_retrieve);
        //绑定事件监听器
        button_insert.setOnClickListener(this);
        button_delete.setOnClickListener(this);
        button_update.setOnClickListener(this);
        button_retrieve.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //定义两个字符串
        String name,phone;
        //定义数据库
        SQLiteDatabase database;
        //定义ContentValues
        ContentValues values;
        switch (view.getId()){
            case R.id.button_insert:  //添加数据
                //将输入内容转化为字符串
                name = editText_name.getText().toString().trim();
                phone = editText_phone.getText().toString().trim();
                //获取可写入的数据库实例
                database = helper.getWritableDatabase();
                //新建values对象
                values = new ContentValues();
                //将姓名和电话号码放入values中
                values.put("name",name);
                values.put("phone",phone);
                //插入数据库
                database.insert("info",null,values);
                //对话框
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("提示").setIcon(R.drawable.ic_zhengque).setMessage("信息添加成功");
                builder.setCancelable(true);
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
                //关闭数据库
                database.close();
                break;
            case R.id.button_delete:  //删除数据
                //获得可写权限
                database = helper.getWritableDatabase();
                //删除数据
                database.delete("info",null,null);
                //字符串设为无字符
                textView_show.setText("");
                //对话框
                AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                builder2.setTitle("提示").setIcon(R.drawable.ic_zhengque).setMessage("信息删除成功");
                builder2.setCancelable(true);
                builder2.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog dialog2 = builder2.create();
                dialog2.show();
                //关闭数据库
                database.close();
                break;
            case R.id.button_update:  //修改数据
                //获得可写权限
                database = helper.getWritableDatabase();
                //新建values对象
                values = new ContentValues();
                //将电话号码转为字符串，并放入values
                values.put("phone",phone = editText_phone.getText().toString().trim());
                //按名字修改数据
                database.update("info",values,"name=?",new String[]{editText_name.getText().toString().trim()});
                //对话框
                AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
                builder3.setTitle("提示").setIcon(R.drawable.ic_zhengque).setMessage("信息修改成功");
                builder3.setCancelable(true);
                builder3.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog dialog3 = builder3.create();
                dialog3.show();
                //关闭数据库
                database.close();
                break;
            case R.id.button_retrieve:  //查询数据
                //获得可读权限
                database = helper.getReadableDatabase();
                //Cursor集游标，查询数据
                Cursor cursor = database.query("info",null,null,null,null,null,null);
                //如果未获取数据
                if(cursor.getCount()==0){
                    textView_show.setText("");
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                    builder1.setIcon(R.drawable.ic_jinggao).setTitle("提示").setMessage("暂无数据！");
                    builder1.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    builder1.setCancelable(true);
                    AlertDialog dialog1 = builder1.create();
                    dialog1.show();
                }else{ //获取到数据后从第一个数据开始显示文本
                    cursor.moveToFirst();
                    textView_show.setText("姓名："+cursor.getString(1)+"，电话："+cursor.getString(2));
                }  //往下读一行
                while (cursor.moveToNext()) {
                    textView_show.append("\n"+"姓名："+cursor.getString(1)+"，电话："+cursor.getString(2));
                }
                Toast.makeText(this,"信息展示完毕",Toast.LENGTH_SHORT).show();
                //关闭集游标
                cursor.close();
                //关闭数据库
                database.close();
                break;
            default:
                break;
        }
    }
    //定义内部类MyHelper并继承自SQLiteOpenHelper
    class MyHelper extends SQLiteOpenHelper{

        public MyHelper(@Nullable Context context) {
            super(context, "data.db",null,1);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            //创建数据表
            sqLiteDatabase.execSQL("create table info(_id integer primary key autoincrement, name varchar(20),phone varchar(11))");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }
}