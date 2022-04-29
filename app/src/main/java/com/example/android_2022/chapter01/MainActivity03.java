package com.example.android_2022.chapter01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.android_2022.R;

public class MainActivity03 extends AppCompatActivity implements View.OnClickListener {
    /**
     * 程序三：猜鸡蛋
     * @param savedInstanceState
     */
    //初始化控件
    private TextView textView;
    private ImageView pic0,pic1,pic2;
    private Button replay;
    //定义数组
    int[] img = new int[]{R.drawable.e301_shoe_default,R.drawable.e301_shoe_ok,R.drawable.e301_shoe_sorry};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main03);
        //运用findViewById找到控件
        textView = findViewById(R.id.textView);
        pic0 = findViewById(R.id.pic0);
        pic1 = findViewById(R.id.pic1);
        pic2 = findViewById(R.id.pic2);
        //绑定单击事件监听器
        replay = findViewById(R.id.replay);
        pic0.setOnClickListener(this);
        pic1.setOnClickListener(this);
        pic2.setOnClickListener(this);
        replay.setOnClickListener(this);
        replay();  //开局先打乱顺序
    }

    private void replay() {
        textView.setText("猜猜鸡蛋在哪只鞋子里？");
        //开局将鸡蛋藏起来，即三双鞋全部用一张图
        pic0.setImageDrawable(ContextCompat.getDrawable(MainActivity03.this, R.drawable.e301_shoe_default));
        pic1.setImageDrawable(ContextCompat.getDrawable(MainActivity03.this, R.drawable.e301_shoe_default));
        pic2.setImageDrawable(ContextCompat.getDrawable(MainActivity03.this, R.drawable.e301_shoe_default));

        //for循环
        for (int i = 0; i < 3; i++) {
            int temp = img[i]; // 将数组元素i保存到临时变量中
            int index = (int) (Math.random() * 2); // 生成一个随机数
            img[i] = img[index]; // 将随机数指定的数组元素的内容赋给数组元素i
            img[index] = temp; // 将临时变量的值赋值给随机数组指定的那个数组元素
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //点击第一双鞋
            case R.id.pic0:
                //给三双鞋编号
                pic0.setImageDrawable(ContextCompat.getDrawable(MainActivity03.this,img[0]));
                pic1.setImageDrawable(ContextCompat.getDrawable(MainActivity03.this,img[1]));
                pic2.setImageDrawable(ContextCompat.getDrawable(MainActivity03.this,img[2]));
                //如果第一双鞋有鸡蛋
                if(img[0]==R.drawable.e301_shoe_ok){
                    textView.setText("恭喜你猜对了");
                }else{
                    textView.setText("不好意思，猜错了。再试一回吧！");  //如果选错了
                }
                break;
            case R.id.pic1:
                //给三双鞋编号
                pic0.setImageDrawable(ContextCompat.getDrawable(MainActivity03.this,img[0]));
                pic1.setImageDrawable(ContextCompat.getDrawable(MainActivity03.this,img[1]));
                pic2.setImageDrawable(ContextCompat.getDrawable(MainActivity03.this,img[2]));
                //如果第二双鞋有鸡蛋
                if(img[1]==R.drawable.e301_shoe_ok){
                    textView.setText("恭喜你猜对了");
                }else{
                    textView.setText("不好意思，猜错了。再试一回吧！");  //如果选错了
                }
                break;
            case R.id.pic2:
                //给三双鞋编号
                pic0.setImageDrawable(ContextCompat.getDrawable(MainActivity03.this,img[0]));
                pic1.setImageDrawable(ContextCompat.getDrawable(MainActivity03.this,img[1]));
                pic2.setImageDrawable(ContextCompat.getDrawable(MainActivity03.this,img[2]));
                //如果第三双鞋有鸡蛋
                if(img[2]==R.drawable.e301_shoe_ok){
                    textView.setText("恭喜你猜对了");
                }else{
                    textView.setText("不好意思，猜错了。再试一回吧！");  //如果选错了
                }
                break;
            case R.id.replay:
                //重玩
                replay();
            default:
                break;
        }
    }
}