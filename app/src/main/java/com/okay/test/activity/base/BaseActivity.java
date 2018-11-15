package com.okay.test.activity.base;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.okay.test.utils.LogUtils;


/**
 * @Copyright (C), 2011-2012, 北京国电通网络技术有限公司.
 * @FileName
 * @Author yang.xu
 * @Version
 * @Date 2016/12/15
 * @Description:
 */

public class BaseActivity extends AppCompatActivity {

    private String TAG = "BaseActivity";

    Application myApp;
    Activity mActivity;
    Service mService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyApplication myApp = (MyApplication) getApplication();
        LogUtils.d(TAG,"getApplication is--"+myApp.toString());

        Context appContext = getApplicationContext();
        LogUtils.d(TAG,"getApplicationContext is--"+appContext);

        Context baseContext = getBaseContext();
        LogUtils.d(TAG,"getBaseContext is--"+baseContext);


//        12-29 15:08:08.419 22100-22100/? E/BaseActivity:
//                msg: getApplication is--com.gdt.study.MyApplication@41e221d8
//        12-29 15:08:08.419 22100-22100/? E/BaseActivity:
//                msg: getApplicationContext is--com.gdt.study.MyApplication@41e221d8

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
