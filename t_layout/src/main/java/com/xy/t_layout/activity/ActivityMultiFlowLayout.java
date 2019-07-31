package com.xy.t_layout.activity;

import android.os.Bundle;
import android.view.View;

import com.xy.t_layout.R;
import com.xy.t_layout.multiflowlayout.BaseActivity_03;
import com.xy.t_layout.multiflowlayout.Activity_03LayoutMultiScroll;
import com.xy.t_layout.multiflowlayout.Activity_03_LayoutScroll;
import com.xy.t_layout.multiflowlayout.Activity_03_TV;
import com.xy.t_layout.multiflowlayout.Activity_03_TVScroll;

public class ActivityMultiFlowLayout extends BaseActivity_03 {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_flowlayout);

        findViewById(R.id.btn_tv).setOnClickListener(this);
        findViewById(R.id.btn_tv_scroll).setOnClickListener(this);
        findViewById(R.id.btn_layout_scroll).setOnClickListener(this);
        findViewById(R.id.btn_layout__multi_scroll).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_tv:
                startAppcompatActivity(Activity_03_TV.class);
                break;
            case R.id.btn_tv_scroll:
                startAppcompatActivity(Activity_03_TVScroll.class);

                break;
            case R.id.btn_layout_scroll:
                startAppcompatActivity(Activity_03_LayoutScroll.class);

                break;
            case R.id.btn_layout__multi_scroll:
                startAppcompatActivity(Activity_03LayoutMultiScroll.class);

                break;
        }
    }
}
