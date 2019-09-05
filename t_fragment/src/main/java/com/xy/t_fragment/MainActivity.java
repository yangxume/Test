package com.xy.t_fragment;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * ViewPager + Fragment 懒加载
 * https://blog.csdn.net/qq_27870227/article/details/97031308
 */
public class MainActivity extends AppCompatActivity {

    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
