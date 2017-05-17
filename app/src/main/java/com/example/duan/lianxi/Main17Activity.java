package com.example.duan.lianxi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import q.lunbo.AdapterDemo;
import q.lunbo.Banner;
import q.lunbo.BannerPagerAdapter;

/**
 * 轮播
 * */
public class Main17Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main17);
        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main17Activity.this, Main17aActivity.class);
                startActivity(intent);
            }
        });
        List<Integer> data = new ArrayList<>();
        data.add(R.mipmap.a1);
        data.add(R.mipmap.a2);
        data.add(R.mipmap.a3);
        data.add(R.mipmap.a4);

        AdapterDemo ad = new AdapterDemo(this, data);
        Banner banner = (Banner) findViewById(R.id.banner);

        /**
         * 关于这里的设置参数问题,是需要这样使用的
         * 在设置了小圆点之后才能设置适配器
         * 因为只有在适配器里才会根据一共多少条数据来适配
         * 最后需要调用开始轮播
         * 个人建议在onPause()/onDestroy()方法中来停止 -- stopAutoPlay()
         */
        banner.setDotGravity(Banner.CENTER).
                setDot(R.drawable.no_selected_dot, R.drawable.selected_dot).
                setAdapter(ad).
                setOnItemClickListener(new BannerPagerAdapter.onItemClickListener() {
                    @Override
                    public void onClick(int position) {
                        Toast.makeText(Main17Activity.this, "" + position, Toast.LENGTH_SHORT).show();
                    }
                }).
                startAutoPlay();
    }
}
