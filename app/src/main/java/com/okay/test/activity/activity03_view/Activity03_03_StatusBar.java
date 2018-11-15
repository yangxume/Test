package com.okay.test.activity.activity03_view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.okay.test.R;
import com.okay.test.utils.DisplayUtils;
import com.okay.test.utils.LogUtils;

/**
 * Copyright
 * <p>
 * Created by xuyang on 17/4/13 15:09
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */

public class Activity03_03_StatusBar extends Activity {

    private Object statusHeight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity03_03_statusbar);
//
//        getStatusHeight();


    }


    public Object getStatusHeight() {


        /**
         * 获取状态栏高度——方法1
         * */
        int statusBarHeight1 = -1;
        //获取status_bar_height资源的ID
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            //根据资源ID获取响应的尺寸值
            statusBarHeight1 = getResources().getDimensionPixelSize(resourceId);
        }
        LogUtils.e("状态栏高度-px:" + statusBarHeight1);
        int statusHeightDp = DisplayUtils.px2dip(this, statusBarHeight1);
        LogUtils.e("状态栏高度-dp:" + statusHeightDp);

//        04-13 15:14:19.919 27668-27668/? E/okay: 状态栏高度-px:36
//        04-13 15:14:19.919 27668-27668/? E/okay: 状态栏高度-dp:24


        return statusHeight;
    }

    private void test() {

        float width_height = DisplayUtils.dip2px(this, 266.67f);
        Log.e("width_height=", width_height + "");

        float paint_stroke_width = DisplayUtils.dip2px(this, 26.67f);
        Log.e("paint_stroke_width=", paint_stroke_width + "");

        float mar_top = DisplayUtils.dip2px(this, 26.67f);
        Log.e("mar_top=", mar_top + "");

        float accuacy_text_size = DisplayUtils.sp2px(this, 53.33f);
        Log.e("accuacy_text_size=", accuacy_text_size + "");

        float accuacy_text_size_bottom = DisplayUtils.sp2px(this, 21.33f);
        Log.e("size_bottom=", accuacy_text_size_bottom + "");

//    4-01 17:34:42.133 29573-29573/com.okay.test E/width_height=: 533.0
//            04-01 17:34:42.133 29573-29573/com.okay.test E/paint_stroke_width=: 53.0
//            04-01 17:34:42.133 29573-29573/com.okay.test E/mar_top=: 53.0
//            04-01 17:34:42.133 29573-29573/com.okay.test E/accuacy_text_size=: 107.0
//            04-01 17:34:42.133 29573-29573/com.okay.test E/size_bottom=: 43.0
    }
}
