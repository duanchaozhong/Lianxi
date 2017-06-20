package com.example.duan.lianxi;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import activity26.CommonTabLayout;
import activity26.CustomTabEntity;
import activity26.OnTabSelectListener;
import activity26.SegmentTabLayout;
import activity26.TabEntity;
import activity26.ViewFindUtils;

/**
 * tablayout
 * */
public class Main26Activity extends Activity {
    private CommonTabLayout mTabLayout_6;
    private SegmentTabLayout mTabLayout_3;
    private View mDecorView;
    private String[] mTitles = {"首页", "消息", "联系人", "更多"};
  /*  private int[] mIconUnselectIds = {
            R.mipmap.tab_home_unselect, R.mipmap.tab_speech_unselect,
            R.mipmap.tab_contact_unselect, R.mipmap.tab_more_unselect};
    private int[] mIconSelectIds = {
            R.mipmap.tab_home_select, R.mipmap.tab_speech_select,
            R.mipmap.tab_contact_select, R.mipmap.tab_more_select};*/
    private ArrayList<CustomTabEntity> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main26);
        tab1();
        tab2();
        tab3();
    }

    private void tab3() {

    }

    private void tab2() {
        mTabLayout_3 = ViewFindUtils.find(mDecorView, R.id.tl_3);
        mTabLayout_3.setTabData(mTitles);
        mTabLayout_3.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
            //    vp_3.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {
            }
        });
    }

    private void tab1() {
        mDecorView = getWindow().getDecorView();
        /** indicator矩形圆角 */
        mTabLayout_6 = ViewFindUtils.find(mDecorView, R.id.tl_6);
        for (int i = 0; i < mTitles.length; i++) {
            // list.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
            list.add(new TabEntity(mTitles[i]));
        }
        mTabLayout_6.setTabData(list);
        //  mTabLayout_6.setCurrentTab(position);
    }
}
