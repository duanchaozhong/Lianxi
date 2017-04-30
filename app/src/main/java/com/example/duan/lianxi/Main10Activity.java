package com.example.duan.lianxi;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import k.tag.FlowLayout;
/**
 * 自定义tag标签
 * */
public class Main10Activity extends Activity {

    /**
     * 显示的文字
     */
    private String[] mDatas = new String[]{"QQ",
            "视频啊啊啊啊啊啊xasx",
            "放开那三国",
            "电子书",
            "酒店",
            "单机",
            "小说",
            "斗地主",
            "优酷",
            "网游",
            "WIFI万能钥匙",
            "播放器aaaaa",
            "捕鱼达人2",
            "机票",
            "游戏",
            "熊出没之熊大快跑",
            "美图秀秀",
            "浏览器",
            "单机游戏",
            "我的世界",
            "电影电视",
            "QQ空间",
            "旅游",
            "免费游戏",
            "2048",
            "刀塔传奇",
            "壁纸",
            "节奏大师",
            "锁屏",
            "装机必备",
            "天天动听",
            "备份",
            "网盘",
            "海淘网",
            "大众点评",
            "爱奇艺视频",
            "腾讯手机管家",
            "百度地图",
            "猎豹清理大师",
            "谷歌地图",
            "hao123上网导航",
            "京东",
            "有你",
            "万年历-农历黄历",
            "支付宝钱包"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);

        FlowLayout flowLayout = (FlowLayout) findViewById(R.id.flow_layout);

        Random random = new Random();

        // 循环添加TextView到容器
        for (int i = 0; i < mDatas.length; i++) {
            final TextView view = new TextView(this);
            view.setText(mDatas[i]);
            view.setTextColor(Color.WHITE);
            view.setPadding(5, 5, 5, 5);
            view.setGravity(Gravity.CENTER);
            view.setTextSize(14);

            // 设置点击事件
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(Main10Activity.this, view.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });

            // 设置彩色背景
            GradientDrawable normalDrawable = new GradientDrawable();
            normalDrawable.setShape(GradientDrawable.RECTANGLE);
            int a = 255;
            int r = 50 + random.nextInt(150);
            int g = 50 + random.nextInt(150);
            int b = 50 + random.nextInt(150);
            normalDrawable.setColor(Color.argb(a, r, g, b));

            // 设置按下的灰色背景
            GradientDrawable pressedDrawable = new GradientDrawable();
            pressedDrawable.setShape(GradientDrawable.RECTANGLE);
            pressedDrawable.setColor(Color.GRAY);

            // 背景选择器
            StateListDrawable stateDrawable = new StateListDrawable();
            stateDrawable.addState(new int[]{android.R.attr.state_pressed}, pressedDrawable);
            stateDrawable.addState(new int[]{}, normalDrawable);

            // 设置背景选择器到TextView上
            view.setBackground(stateDrawable);

            flowLayout.addView(view);
        }
    }
}
