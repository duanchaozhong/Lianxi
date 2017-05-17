package com.example.duan.lianxi;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import d.shuibo.LoginActivity;
/**
 * 水波纹
 * */
public class Main5Activity extends Activity {
    private Handler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        //线程开启器
        mHandler = new Handler();
        //延时两秒 开启下面的gotoLogin线程
        mHandler.postDelayed(gotoLoginAct, 2000);
    }
    Runnable gotoLoginAct = new Runnable() {

        @Override
        public void run() {
            Intent i = new Intent(Main5Activity.this, LoginActivity.class);
            startActivity(i);
            finish();
        }
    };
}
