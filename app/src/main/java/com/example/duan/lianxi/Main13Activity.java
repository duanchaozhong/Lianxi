package com.example.duan.lianxi;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
/**
 * Metro UI效果
 * */
public class Main13Activity extends Activity {
    private final String ACTION_NAME = "发送广播";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main13);
        setViews();
        setListener();
    }

    private void setViews() {
        /**
         *  延迟步骤，延迟1秒后执行
         * */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        },1000);
        /**
         *  用哪个handler发消息就会用哪个handler收消息（handler是独立的一个工作线程）
         * */
        Handler handler=new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {

                return false;
            }
        });
        handler.sendEmptyMessage(0);
    }
    /**
     * 注册广播
     * */
    public void registerBoradcastReceiver(){
        IntentFilter myIntentFilter = new IntentFilter();
        myIntentFilter.addAction(ACTION_NAME);
        //注册广播
        Main13Activity.this.registerReceiver(mBroadcastReceiver, myIntentFilter);

        /**
         * 注销广播接收器
         * （activity退出的同时要注销广播接收器）
         * */
      //  Main13Activity.this.unregisterReceiver(mBroadcastReceiver);
    }
    /**
     * 发送广播
     * */
    private void sendBoradcast(){
        Intent intent = new Intent();
        intent.setAction(ACTION_NAME);
        intent.putExtra("name", "qqyumidi");
        sendBroadcast(intent);
    }

    /**
     * 广播接收器
     * */
    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if(action.equals(ACTION_NAME)){
               /* setViews();
                setListener();*/
                // Toast.makeText(Test.this, "处理action名字相对应的广播", 200);
            }
        }
    };
    private void setListener() {

    }
}
