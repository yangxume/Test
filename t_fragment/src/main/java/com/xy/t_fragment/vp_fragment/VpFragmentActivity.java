package com.xy.t_fragment.vp_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.xy.t_fragment.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangxume@gmail.com
 * @Time: 2019-09-10 16:42
 * @Desc:
 */
public class VpFragmentActivity extends AppCompatActivity {

    private ViewPager vp;

    private List<Fragment> fragmentList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_vp_fragment);

        vp = findViewById(R.id.vp);
        vp.setOffscreenPageLimit(1);

        fragmentList = new ArrayList<>();

        fragmentList.add(new Fragment1());
        fragmentList.add(new Fragment2());
        fragmentList.add(new Fragment3());

//        vp.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        vp.setAdapter(new MyPageStateAdapter(getSupportFragmentManager()));

    }

    class MyPagerAdapter extends FragmentPagerAdapter{


        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragmentList.get(i);
        }

        @Override
        public int getCount() {
            return fragmentList == null ? 0 : fragmentList.size();
        }
    }

    class MyPageStateAdapter extends FragmentStatePagerAdapter{

        public MyPageStateAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragmentList.get(i);
        }

        @Override
        public int getCount() {
            return fragmentList == null ? 0 : fragmentList.size();
        }
    }

}


