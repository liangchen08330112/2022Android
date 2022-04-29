package com.example.android_2022.chapter01;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.android_2022.R;

public class MainActivity02 extends AppCompatActivity implements View.OnClickListener {

    /**
     * 程序二：猜拳游戏改进（对话框）
     */

    //准备资源
    int[] imgSrc= {R.drawable.t302_cloth,R.drawable.t302_scissors,R.drawable.t302_stone};
    String result = "游戏结果：";
    //初始化控件
    private ImageView imageView_paper, imageView_scissors, imageView_stone, imageView_result;
    private TextView textView_result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main02);
        //使用findViewById找到控件
        imageView_paper = findViewById(R.id.imageView_paper);
        imageView_scissors = findViewById(R.id.imageView_scissors);
        imageView_stone = findViewById(R.id.imageView_stone);
        imageView_result = findViewById(R.id.imageView_result);
        textView_result = findViewById(R.id.textView_result);

        //绑定事件监听器
        imageView_paper.setOnClickListener(this);
        imageView_scissors.setOnClickListener(this);
        imageView_stone.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //使用随机数来让电脑自动生成出拳
        int autoNumber = (int) (Math.random()*3);
        //显示电脑出拳
        imageView_result.setImageResource(imgSrc[autoNumber]);
        //结果判定
        switch (view.getId()){
            case R.id.imageView_paper:  //出布
                switch (autoNumber){
                    case 0:  //电脑出布
                        textView_result.setText("游戏结果：平局");
                        result = "游戏结果：平局";
                        break;
                    case 1:  //电脑出剪子
                        textView_result.setText("游戏结果：电脑胜利");
                        result = "游戏结果：电脑胜利";
                        break;
                    case 2:  //电脑出石头
                        textView_result.setText("游戏结果：你胜利");
                        result = "游戏结果：你胜利";
                        break;
                    default:
                        break;
                }
                break;
            case R.id.imageView_scissors:  //出剪子
                switch (autoNumber){
                    case 0:  //电脑出布
                        textView_result.setText("游戏结果：你胜利");
                        result = "游戏结果：你胜利";
                        break;
                    case 1:  //电脑出剪子
                        textView_result.setText("游戏结果：平局");
                        result = "游戏结果：平局";
                        break;
                    case 2:  //电脑出石头
                        textView_result.setText("游戏结果：电脑胜利");
                        result = "游戏结果：电脑胜利";
                        break;
                    default:
                        break;
                }
                break;
            case R.id.imageView_stone:  //出石头
                switch (autoNumber){
                    case 0:  //电脑出布
                        textView_result.setText("游戏结果：电脑胜利");
                        result = "游戏结果：电脑胜利";
                        break;
                    case 1:  //电脑出剪子
                        textView_result.setText("游戏结果：你胜利");
                        result = "游戏结果：你胜利";
                        break;
                    case 2:  //电脑出石头
                        textView_result.setText("游戏结果：平局");
                        result = "游戏结果：平局";
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
        //新建对话框构造对象
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity02.this);
        //设置标题
        builder.setTitle("游戏结果").setIcon(R.drawable.t302_caiquan);
        //设置内容
        builder.setMessage(result+"。是否重新开局？");
        //设置确定按钮
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //电脑出拳图标初始化
                imageView_result.setImageResource(R.drawable.t302_caiquan);
                //初始化结果
                textView_result.setText("游戏结果：");
                //对话框消失
                dialogInterface.dismiss();
            }
        });
        //设置取消按钮
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //显示游戏结果
                textView_result.setText(result);
                //对话框消失
                dialogInterface.dismiss();
            }
        });
        //生成对话框
        AlertDialog dialog = builder.create();
        //显示对话框
        dialog.show();
    }
}