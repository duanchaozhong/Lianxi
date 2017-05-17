package com.example.duan.lianxi;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

import g.button.XCDanmuView;
/**
 * 弹幕效果
 * */
public class Main6Activity extends Activity {
    private XCDanmuView mDanmuView;
    private String[] mStrItems = {
            "搜狗","百度",
            "腾讯","360",
            "阿里巴巴","搜狐",
            "网易","新浪",
            "搜狗-上网从搜狗开始","百度一下,你就知道",
            "必应搜索-有求必应","好搜-用好搜，特顺手",
            "Android-谷歌","IOS-苹果",
            "Windows-微软","Linux"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        mDanmuView = (XCDanmuView)findViewById(R.id.danmu);
        mDanmuView.initDanmuItemViews(mStrItems);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mDanmuView.isWorking()) {
                    mDanmuView.hide();
                    ((Button) view).setText("开启弹幕");
                } else {
                    mDanmuView.start();
                    ((Button) view).setText("关闭弹幕");
                }
            }
        });
    }
}
