package com.example.duan.lianxi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private static MainActivity mainActivity;
    private ListView lv;
    private MainAdapter adapter;
    private List<String>list=new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(MainActivity.this);
        setContentView(R.layout.activity_main);
        mainActivity =this;
        setViews();
        setListener();
    }

    private void setViews() {
        list.add("各种动画");list.add("购物车动画");list.add("3D立体旋转");
        list.add("Activity跳转动画");list.add("水波纹和加载动画");
        list.add("按钮的动画效果和弹幕效果");list.add("任务卡效果");
        list.add("TextView部分颜色，点击跳转");list.add("三级联动");
        list.add("自定义View标签");list.add("进度条");list.add("不一样的按钮弹出动画");
        list.add("Metro UI效果");list.add("下拉回弹");list.add("边角标签");list.add("fragment");list.add("轮播");
        list.add("新闻客户端");list.add("PullToRefreshLayout");list.add("图表");list.add("百分比布局");list.add("视频播放器");
        list.add("LitePal操作数据库");list.add("沉浸式标题");list.add("语言切换");list.add("TabLayout");
        adapter=new MainAdapter(mainActivity,list);
        lv=(ListView)findViewById(R.id.lv);
        lv.setAdapter(adapter);
    }

    private void setListener() {
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:intent(Main1Activity.class);break;
                    case 1:intent(Main2Activity.class);break;
                    case 2:intent(Main3Activity.class);break;
                    case 3:intent(Main4Activity.class);break;
                    case 4:intent(Main5Activity.class);break;
                    case 5:intent(Main6Activity.class);break;
                    case 6:intent(Main7Activity.class);break;
                    case 7:intent(Main8Activity.class);break;
                    case 8:intent(Main9Activity.class);break;
                    case 9:intent(Main10Activity.class);break;
                    case 10:intent(Main11Activity.class);break;
                    case 11:intent(Main12Activity.class);break;
                    case 12:intent(Main13Activity.class);break;
                    case 13:intent(Main14Activity.class);break;
                    case 14:intent(Main15Activity.class);break;
                    case 15:intent(Main16Activity.class);break;
                    case 16:intent(Main17Activity.class);break;
                    case 17:intent(Main18Activity.class);break;
                    case 18:intent(Main19Activity.class);break;
                    case 19:intent(Main20Activity.class);break;
                    case 20:intent(Main21Activity.class);break;
                    case 21:intent(Main22Activity.class);break;
                    case 22:intent(Main23Activity.class);break;
                    case 23:intent(Main24Activity.class);break;
                    case 24:intent(Main25Activity.class);break;
                    case 25:intent(Main26Activity.class);break;
                }
            }
        });
    }
    private void intent(Class a){
        Intent intent=new Intent(mainActivity,a);
        startActivity(intent);
    }
}
