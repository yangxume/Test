package com.okay.test;

import android.app.Application;

/**
 * @Author: yangxume@gmail.com
 * @Time: 2019-09-09 17:07
 * @Desc:
 */
public class MyApplication extends Application {

    public static  Application application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }
}
