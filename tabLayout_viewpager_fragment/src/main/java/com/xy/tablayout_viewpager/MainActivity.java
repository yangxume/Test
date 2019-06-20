package com.xy.tablayout_viewpager;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private LayoutInflater mInflater;
    private List<String> mTitleList = new ArrayList<>();//页卡标题集合
    private View view1, view2, view3, view4, view5;//页卡视图
    private List<View> mViewList = new ArrayList<>();//页卡视图集合
    private List<String> listTitles;
    private List<Fragment> fragments;
    private List<TextView> listTextViews;

    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mTabLayout = (TabLayout) findViewById(R.id.tabLayout);
        initData();
    }
    private void initData() {
        listTitles = new ArrayList<>();
        fragments = new ArrayList<>();
        listTextViews = new ArrayList<>();

        listTitles.add("推荐");
        listTitles.add("热点");
        listTitles.add("视频");
        listTitles.add("北京");
        listTitles.add("社会");
        listTitles.add("娱乐");
        listTitles.add("问答");
        listTitles.add("图片");
        listTitles.add("科技");
        listTitles.add("汽车");
        listTitles.add("体育");
        listTitles.add("财经");
        listTitles.add("军事");
        listTitles.add("国际");
        for (int i = 0; i < listTitles.size(); i++) {
            ContentFragment fragment = ContentFragment.newInstance(listTitles.get(i));
            fragments.add(fragment);

        }
        //mTabLayout.setTabMode(TabLayout.SCROLL_AXIS_HORIZONTAL);//设置tab模式，当前为系统默认模式
        for (int i=0;i<listTitles.size();i++){
            mTabLayout.addTab(mTabLayout.newTab().setText(listTitles.get(i)));//添加tab选项
        }

        FragmentPagerAdapter mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
            //ViewPager与TabLayout绑定后，这里获取到PageTitle就是Tab的Text
            @Override
            public CharSequence getPageTitle(int position) {
                return listTitles.get(position);
            }
        };
        mViewPager.setAdapter(mAdapter);

        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。
        mTabLayout.setTabsFromPagerAdapter(mAdapter);//给Tabs设置适配器

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.tabLayout,fragments.get(0))
                .commit();

    }
}