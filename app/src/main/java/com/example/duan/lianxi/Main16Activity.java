package com.example.duan.lianxi;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import main17a.ViewPagerApdate;
import main17a.carousel.CustomViewPager;
import p.bianjiaotag.Blank1Fragment;
import p.bianjiaotag.Blank2Fragment;

public class Main16Activity extends AppCompatActivity {
    private CustomViewPager vp;
    private ArrayList<Fragment> list = new ArrayList<>();
    private ViewPagerApdate adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main16);
        setViews();
        setListener();
    }

    private void setViews() {
        vp=(CustomViewPager)findViewById(R.id.vp);
        list.add(new Blank1Fragment());
        list.add(new Blank2Fragment());
        adapter = new ViewPagerApdate(getSupportFragmentManager(), list);
        vp.setOffscreenPageLimit(list.size());                        //设置幕后item的缓存数目
        vp.setAdapter(adapter);                             //给ViewPage设置适配器
    }

    private void setListener() {

    }

    public void onTabClicked(View view) {
        switch (view.getId()) {
            case R.id.rl0:
                setSelectedItem(0);
                break;
            case R.id.rl1:
                setSelectedItem(1);
                break;
        }
    }

    public void setSelectedItem(int pos) {
        vp.setCurrentItem(pos, false);
    }
}
