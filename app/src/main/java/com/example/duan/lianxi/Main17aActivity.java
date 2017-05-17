package com.example.duan.lianxi;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import main17a.AutoFragment;
import main17a.ViewPagerApdate;
import main17a.carousel.ChildViewPager;

/**
 * 欢迎页的fragment
 * */
public class Main17aActivity extends FragmentActivity {
    // 放圆点的View的list
    private List<View> dotViewsList=new ArrayList<>();
    private ViewPagerApdate vpadapter;
    private ChildViewPager vp;
    private ArrayList<Fragment> list=new ArrayList<>();
    private LinearLayout dotarea;
    boolean isUp = true;
    private Main17aActivity INSTANCE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main17_a);
        INSTANCE=this;
        setViews();
        setListener();
    }

    private void setListener() {
        vp.setOnPageChangeListener(new MyPageChangeListener());
        vp.setOnSingleTouchListener(new ChildViewPager.OnSingleTouchListener() {
            @Override
            public void onSingleTouch() {
                setState(true);
            }
            @Override
            public void onTouchDown() {
                setState(false);
            }
            @Override
            public void onTouchUp() {
            }
        });
    }

    private void setViews() {
        dotarea= (LinearLayout) findViewById(R.id.ll_viewarea_dot2);
        vp= (ChildViewPager) findViewById(R.id.viewpager);

        AutoFragment a = new AutoFragment();
        list.add(a);
        AutoFragment b = new AutoFragment();
        list.add(b);
        vpadapter=new ViewPagerApdate(getSupportFragmentManager(),list);
        vp.setOffscreenPageLimit(list.size());
        vp.setAdapter(vpadapter);
        // 设置圆点的大小，可根据需要设置圆点大小与间距
        int y = 18;
        for (int i = 0; i < list.size(); i++) {
            View dotView = new View(INSTANCE);
            if (list.size() > 0) {
                dotarea.setGravity(Gravity.CENTER_HORIZONTAL);
            }
            if (i > 0) {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        y, y);
                params.setMargins(9, 0, 0, 0);
                dotView.setLayoutParams(params);
                dotView.setBackgroundResource(R.drawable.no_selected_dot);
            } else {
                dotView.setLayoutParams(new ViewGroup.LayoutParams(y, y));
                dotView.setBackgroundResource(R.drawable.selected_dot);
            }
            dotarea.addView(dotView);
            dotViewsList.add(dotView);
        }
    }

    /**
     * ViewPager的监听器 当ViewPager中页面的状态发生改变时调用
     */
    private class MyPageChangeListener implements ViewPager.OnPageChangeListener {

        boolean isAutoPlay = false;
        @Override
        public void onPageScrollStateChanged(int arg0) {
        }
        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }
        @Override
        public void onPageSelected(int pos) {
            int size = dotViewsList.size();
            int curPos = pos % size;
            for (int i = 0; i < size; i++) {
                if (i == curPos) {
                    ((View) dotViewsList.get(i))
                            .setBackgroundResource(R.drawable.no_selected_dot);
                } else {
                    ((View) dotViewsList.get(i))
                            .setBackgroundResource(R.drawable.selected_dot);
                }
            }
        }
    }

    /**
     * 销毁ImageView资源，回收内存
     */
    public void setState(boolean b) {
        isUp = b;
        if (!isUp) {
          //  handler.removeMessages(1);
        } else {
          //  handler.sendEmptyMessageDelayed(1, 5000);
        }
    }
}
