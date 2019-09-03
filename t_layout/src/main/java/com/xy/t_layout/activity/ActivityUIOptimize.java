package com.xy.t_layout.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.xy.t_layout.R;

/**
 * https://blog.csdn.net/hzw2017/article/details/82730784
 *
 * https://developer.android.google.cn/studio/debug/layout-inspector
 *
 * @Author: yangxume@gmail.com
 * @Time: 2019-09-03 14:58
 * @Desc: 布局优化练习
 */
public class ActivityUIOptimize extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui_optimize);
    }
}
