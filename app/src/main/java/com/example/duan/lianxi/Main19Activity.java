package com.example.duan.lianxi;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import pulltorefreshlayout.PullToRefreshLayout;

public class Main19Activity extends Activity {
    private PullToRefreshLayout pullToRefreshLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main19);
        setViews();
        setListener();
    }

    private void setViews() {
        pullToRefreshLayout=(PullToRefreshLayout)findViewById(R.id.pull);
    }

    private void setListener() {
        pullToRefreshLayout.setOnChangeListener(new PullToRefreshLayout.OnChangeListener() {
            @Override
            public void onStarRefresh() {

            }
            @Override
            public void onEndRefresh() {

            }
        });
        pullToRefreshLayout.setOnRefreshListener(new PullToRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh(PullToRefreshLayout pullToRefreshLayout) {

            }
        });
    }
}
