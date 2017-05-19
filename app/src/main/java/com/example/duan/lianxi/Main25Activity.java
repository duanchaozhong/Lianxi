package com.example.duan.lianxi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

/**
 * 语言切换
 * 需要加中英文语言包values-en和values-zh
 * */
public class Main25Activity extends Activity {
    private Button b1;
    private Button b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main25);
        setViews();
    }

    private void setViews() {
        b1= (Button) findViewById(R.id.b1);
        b2= (Button) findViewById(R.id.b2);
        /**
         * 切换成英语
         * */
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Locale.setDefault(Locale.ENGLISH);
                Configuration config = getBaseContext().getResources().getConfiguration();
                config.locale = Locale.ENGLISH;
                getBaseContext().getResources().updateConfiguration(config
                        , getBaseContext().getResources().getDisplayMetrics());
                Intent intent = new Intent(getApplicationContext(),Main25Activity.class);
                intent.setClass(getApplicationContext(),Main25Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        /**
         * 切换成中文
         * */
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Locale.setDefault(Locale.CHINESE);
                Configuration config = getBaseContext().getResources().getConfiguration();
                config.locale = Locale.CHINESE;
                getBaseContext().getResources().updateConfiguration(config
                        , getBaseContext().getResources().getDisplayMetrics());
                Intent intent = new Intent();
                intent.setClass(getApplicationContext(),Main25Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }

    public void switchLanguage(Locale locale) {
        Resources resources = getResources();// 获得res资源对象
        Configuration config = resources.getConfiguration();// 获得设置对象
        DisplayMetrics dm = resources.getDisplayMetrics();// 获得屏幕参数：主要是分辨率，像素等。
        config.locale = locale; // 简体中文
        resources.updateConfiguration(config, dm);
    }
}
