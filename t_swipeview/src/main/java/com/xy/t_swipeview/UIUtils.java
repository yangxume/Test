package com.xy.t_swipeview;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;

class UIUtils {

    private static final String TAG = UIUtils.class.getSimpleName();

    /**
     * dip转换px
     */
    public static int dip2px(Context context, int dip) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dip * scale + 0.5f);
    }

    /**
     * dp2px
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * pxz转换dip
     */
    public static int px2dip(Context context, int px) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f);
    }

    /**
     * px2dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


    public static int [] getWindowWidth(WindowManager windowManager, Context ctx) {

        // 获取屏幕宽高（方法1）
        int screenWidth = windowManager.getDefaultDisplay().getWidth(); // 屏幕宽（像素，如：480px）
        int screenHeight = windowManager.getDefaultDisplay().getHeight(); // 屏幕高（像素，如：800p）
        Log.e(TAG + " getDefaultDisplay", "screenWidth=" + screenWidth + "; screenHeight=" + screenHeight);

        // 获取屏幕密度（方法2）
        DisplayMetrics dm = new DisplayMetrics();
        dm = ctx.getResources().getDisplayMetrics();
        float density = dm.density; // 屏幕密度（像素比例：0.75/1.0/1.5/2.0）
        int densityDPI = dm.densityDpi; // 屏幕密度（每寸像素：120/160/240/320）
        float xdpi = dm.xdpi;
        float ydpi = dm.ydpi;
        Log.e(TAG + " DisplayMetrics", "xdpi=" + xdpi + "; ydpi=" + ydpi);
        Log.e(TAG + " DisplayMetrics", "density=" + density + "; densityDPI=" + densityDPI);
        screenWidth = dm.widthPixels; // 屏幕宽（像素，如：480px）
        screenHeight = dm.heightPixels; // 屏幕高（像素，如：800px）
        Log.e(TAG + " DisplayMetrics(111)", "screenWidth=" + screenWidth + "; screenHeight=" + screenHeight);

        // 获取屏幕密度（方法3）
        dm = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(dm);
        density = dm.density; // 屏幕密度（像素比例：0.75/1.0/1.5/2.0）
        densityDPI = dm.densityDpi; // 屏幕密度（每寸像素：120/160/240/320）
        xdpi = dm.xdpi;
        ydpi = dm.ydpi;
        Log.e(TAG + " DisplayMetrics", "xdpi=" + xdpi + "; ydpi=" + ydpi);
        Log.e(TAG + " DisplayMetrics", "density=" + density + "; densityDPI=" + densityDPI);
        int screenWidthDip = dm.widthPixels; // 屏幕宽（dip，如：320dip）
        int screenHeightDip = dm.heightPixels; // 屏幕宽（dip，如：533dip）
        Log.e(TAG + " DisplayMetrics(222)", "screenWidthDip=" + screenWidthDip + "; screenHeightDip=" + screenHeightDip);
        screenWidth = (int) (dm.widthPixels * density + 0.5f); // 屏幕宽（px，如：480px）
        screenHeight = (int) (dm.heightPixels * density + 0.5f); // 屏幕高（px，如：800px）
        Log.e(TAG + " DisplayMetrics(222)", "screenWidth=" + screenWidth + "; screenHeight=" + screenHeight);

        int [] screen_array = new int [] {screenWidth,screenHeight};

        return screen_array;

    }

    public static int getScreenWidth(Context ctx) {

        // 获取屏幕密度（方法2）
        DisplayMetrics dm = new DisplayMetrics();
        dm = ctx.getResources().getDisplayMetrics();
        float density = dm.density; // 屏幕密度（像素比例：0.75/1.0/1.5/2.0）
        int densityDPI = dm.densityDpi; // 屏幕密度（每寸像素：120/160/240/320）
        float xdpi = dm.xdpi;
        float ydpi = dm.ydpi;
        Log.e(TAG + " DisplayMetrics", "xdpi=" + xdpi + "; ydpi=" + ydpi);
        Log.e(TAG + " DisplayMetrics", "density=" + density + "; densityDPI=" + densityDPI);
        int  screenWidth = dm.widthPixels; // 屏幕宽（像素，如：480px）
        int screenHeight = dm.heightPixels; // 屏幕高（像素，如：800px）
        Log.e(TAG + " DisplayMetrics(111)", "screenWidth=" + screenWidth + "; screenHeight=" + screenHeight);

        return screenWidth;

    }
}
