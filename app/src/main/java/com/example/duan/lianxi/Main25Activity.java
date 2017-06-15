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

import de.greenrobot.event.EventBus;

/**
 * 语言切换
 * 需要加中英文语言包values-en和values-zh
 * */
public class Main25Activity extends Activity {
    private Button b1;
    private Button b2;
    private String EVENT_REFRESH_LANGUAGE="B";
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
                /*Intent intent = new Intent(getApplicationContext(),Main25Activity.class);
                intent.setClass(getApplicationContext(),Main25Activity.class);
                //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);*/
                // 杀掉进程
              /*  android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(0);*/
                recreate();//刷新页面
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
    /**
     * 变换语言并且保存在本地
     * */
    public void changeAppLanguage() {
     /*   String sta = Store.getLanuageIsChinese() ? "zh" : "en";//这是SharedPreferences工具类，用于保存设置，代码很简单，自己实现吧
        // 本地语言设置
        Locale myLocale = new Locale(sta);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);*/
    }

    /**
     * EventBus跟广播差不多
     * */
    private void demo(){
        EventBus.getDefault().register(this);   //注册广播
        EventBus.getDefault().post(EVENT_REFRESH_LANGUAGE);//发送消息
    }
/*    //得到消息
    @Subscribe
    public void onEvent(String str) {
        switch (str) {
        case "B":
                changeAppLanguage();
                recreate();//刷新界面
                break;
        }
    }*/
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
