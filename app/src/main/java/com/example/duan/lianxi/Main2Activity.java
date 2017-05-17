package com.example.duan.lianxi;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import b.AppConfig;
import b.FoodAdapter;
import b.NXHooldeView;
/**
 *  购物车动画
 * */
public class Main2Activity extends Activity implements FoodAdapter.FoodActionCallback{
    ListView lv;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lv = (ListView) findViewById(R.id.lv_main);
        tv = (TextView) findViewById(R.id.tv_good_fitting_num);
        lv.setAdapter(new FoodAdapter(this, AppConfig.factoryFoods(), this));
    }

    @Override
    public void addAction(View view) {
        //自定义的需要移动TexeView
        NXHooldeView nxHooldeView = new NXHooldeView(this);
        int position[] = new int[2];
        // 获取在整个屏幕内的绝对坐标，注意这个值是要从屏幕顶端算起，也就是包括了通知栏的高度。
        //view.getLocationOnScreen()
        // 获取在当前窗口内的绝对坐标
        view.getLocationInWindow(position);
        //设置TextView开始时的位置
        nxHooldeView.setStartPosition(new Point(position[0], position[1]));
        //从当前Activity获得根视图
        ViewGroup rootView = (ViewGroup) this.getWindow().getDecorView();
        rootView.addView(nxHooldeView);
        int endPosition[] = new int[2];
        // 获取在当前窗口内结束时的绝对坐标
        tv.getLocationInWindow(endPosition);
        //设置TextView结束时的位置
        nxHooldeView.setEndPosition(new Point(endPosition[0], endPosition[1]));
        nxHooldeView.startBeizerAnimation();
    }
}
