package com.example.duan.lianxi;

import android.support.percent.PercentRelativeLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * 百分比布局，需要添加compile 'com.android.support:percent:24.2.1'
 * */
public class Main21Activity extends AppCompatActivity {
    private LinearLayout ll;
    private PercentRelativeLayout button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main21);
        ll= (LinearLayout) findViewById(R.id.ll);
        button1=(PercentRelativeLayout)findViewById(R.id.button1);
      /*  //得到手机屏幕分辨率
        DisplayMetrics dm = getResources().getDisplayMetrics();
        int width = dm.widthPixels;
        int height = dm.heightPixels;*/
        int width = ll.getWidth();
        int width2=button1.getWidth();
        Log.i("dcz",width+"");
        Log.i("dcz2",width2+"");

        /**
         * 以下方法可以得到控件宽高
         * */
        ViewTreeObserver vto = ll.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                ll.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                Log.i("dcz3",ll.getWidth()+"");
                LinearLayout.LayoutParams params= (LinearLayout.LayoutParams) ll.getLayoutParams();
                //获取当前控件的布局对象
                params.height=ll.getWidth();//设置当前控件布局的高度
                ll.setLayoutParams(params);//将设置好的布局参数应用到控件中
            }
        });
        /**
         *  获取屏幕当前分辨率
         * */
        Display currDisplay = this.getWindowManager().getDefaultDisplay();
        currDisplay.getHeight();currDisplay.getWidth();
    }
}
