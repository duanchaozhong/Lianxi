package com.example.duan.lianxi;

import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import r.xinwen.ParentFragment;

/**
 * 新闻客户端
 * */
public class Main18Activity extends AppCompatActivity {
    private  ParentFragment newsListFragment;
    private FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main18);
        setViews();
        setListener();

    }

    private void setViews() {
        transaction = getSupportFragmentManager().beginTransaction();
        //初始是新闻页面
        newsListFragment = new ParentFragment();
        transaction.add(R.id.fl_content, newsListFragment, "newsListFragment").commit();
    }

    private void setListener() {

    }

    /**
     * 不显示滚动条
     */
    private void removeNavigationViewScrollbar(NavigationView navView) {
        if (navView != null) {
            NavigationMenuView navigationMenuView = (NavigationMenuView) navView.getChildAt(0);
            if (navigationMenuView != null) {
                navigationMenuView.setVerticalScrollBarEnabled(false);
            }
        }
    }
}
