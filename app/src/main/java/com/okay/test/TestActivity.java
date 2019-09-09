package com.okay.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.okay.test.utils.DeviceUtil;
import com.okay.test.utils.LogUtils;

/**
 * @Author: yangxume@gmail.com
 * @Time: 2019-09-09 17:04
 * @Desc:
 */
public class TestActivity extends AppCompatActivity {

    private static final String TAG = TestActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_test);

        long t1 = System.currentTimeMillis();

        DeviceUtil.getIMEI();

        long t2 = System.currentTimeMillis();

        LogUtils.d(TAG, " t2 - t1  = "+(t2-t1));
    }
}
