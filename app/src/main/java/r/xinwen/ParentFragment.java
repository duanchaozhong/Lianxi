package r.xinwen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.duan.lianxi.R;

import java.util.ArrayList;

import p.bianjiaotag.Blank1Fragment;

/**
 * Created by luo-pc on 2016/5/15.
 */
public class ParentFragment extends Fragment {
    private ViewPager vp_content;
    private TabLayout tab_title;
    private ArrayList<String> titleList;
    private ArrayList<Fragment> fragmentList = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, null);

        initView(view);
        initData();
        vp_content.setOffscreenPageLimit(3);
        vp_content.setAdapter(new mPagerAdapter(getChildFragmentManager(), fragmentList, titleList));
        tab_title.setupWithViewPager(vp_content);

        return view;
    }

    private void initData() {
        titleList = new ArrayList<>();
        titleList.add("头条");
        titleList.add("NBA");
        titleList.add("汽车");

        Blank1Fragment hotNewsList = new Blank1Fragment();

        Blank1Fragment sportNewsList = new Blank1Fragment();

        Blank1Fragment carNewsList = new Blank1Fragment();

        fragmentList.add(hotNewsList);
        fragmentList.add(sportNewsList);
        fragmentList.add(carNewsList);

    }

    private void initView(View view) {
        tab_title = (TabLayout) view.findViewById(R.id.tab_title);
        vp_content = (ViewPager) view.findViewById(R.id.vp_content);
    }





}
