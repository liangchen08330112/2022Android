package com.example.android_2022.zhouqian;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;
import java.util.Map;

public class SharedPreferencesSave {
    //保存
    public static boolean saveUserInfo(Context context,String account, String password){
        //获取SharedPreferences对象，参数data表示data.xml文件，操作模式为PRIVATE
        SharedPreferences preferences = context.getSharedPreferences("data",Context.MODE_PRIVATE);
        //获取Editor编辑器对象
        SharedPreferences.Editor editor = preferences.edit();
        //分两次存入String类型数据（因为Java不允许一次传两个数值）
        editor.putString("username",account);
        editor.putString("password",password);
        //提交
        editor.commit();
        return true;
    }
    //获取，以在第二次启动程序自动显示用户名和密码
    public static Map<String, String> getUserInfo(Context context){
        //获取SharedPreferences对象，参数data表示data.xml文件，操作模式为PRIVATE
        SharedPreferences preferences = context.getSharedPreferences("data",Context.MODE_PRIVATE);
        //获取用户名和密码
        String account = preferences.getString("username",null);
        String password = preferences.getString("password",null);
        //新建userMap对象
        Map<String,String> userMap = new HashMap<String,String>();
        userMap.put("account",account);
        userMap.put("password",password);
        return userMap;
    }
}