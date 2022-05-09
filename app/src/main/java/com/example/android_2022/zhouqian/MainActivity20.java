package com.example.android_2022.zhouqian;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.android_2022.R;

public class MainActivity20 extends AppCompatActivity {
    /**
     * 程序：利用ListView和BaseAdapter实现购物商城
     */
    //定义三个数组：名称、价格、图片
    private String[] titles ={"西红柿","酸菜","地瓜","苹果","草莓","福山张格庄大樱桃","济阳黄瓜","莱阳梨"};
    private String[] prices ={"￥5.50元/斤","￥2.80元/斤","￥3.00元/斤","￥2.50元/斤","￥25.00元/斤","￥50.00元/斤","￥4.80元/斤","￥5.00元/斤"};
    private int[] icons = {R.drawable.tomato,R.drawable.suancai,R.drawable.digua,R.drawable.apple,R.drawable.caomei,
            R.drawable.cherry,R.drawable.cucumber,R.drawable.pear};
    //初始化ListView
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main20);
        //找到控件
        listView = findViewById(R.id.listView);
        //新建MyBaseAdapter对象
        MyBaseAdapter adapter = new MyBaseAdapter();
        //对ListView绑定适配器
        listView.setAdapter(adapter);
    }
    //定义了一个MyBaseAdapter内部类，继承自BaseAdapter
    class MyBaseAdapter extends BaseAdapter {
        //以下方法均为需要实现并重写的方法
        @Override
        public int getCount() {
            //返回产品个数
            return titles.length;
        }

        @Override
        public Object getItem(int position) {
            //返回第几个产品
            return titles[position];
        }

        @Override
        public long getItemId(int position) {
            //返回编号
            return position;
        }

        @Override
        //定义getView方法，传入position、convertView、viewGroup三个参数
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            ViewHolder holder = null;
            if(convertView == null){
                convertView =  View.inflate(MainActivity20.this,R.layout.list_item,null);
                holder = new ViewHolder();
                holder.textView_title = convertView.findViewById(R.id.textView_title);
                holder.textView_price2 = convertView.findViewById(R.id.textView_price2);
                holder.imageView = convertView.findViewById(R.id.imageView);
                convertView.setTag(holder);
            }else{
                holder = (ViewHolder) convertView.getTag();
            }
            //设置名称、价格和图片
            holder.textView_title.setText(titles[position]);
            holder.textView_price2.setText(prices[position]);
            holder.imageView.setBackgroundResource(icons[position]);
            return convertView;
        }
    }
    class ViewHolder{
        TextView textView_title,textView_price2;
        ImageView imageView;
    }
}