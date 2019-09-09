package com.okay.test.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import java.util.List;


public class AppUtil {

    private static final String TAG = AppUtil.class.getSimpleName();

    private static String mDeviceId = null;

    /**
     * 程序是否在前台运行
     *
     * @return
     */
    public static boolean isAppOnForeground(Context ctx) {
        if (null == ctx) {
            return false;
        }

        ActivityManager activityManager = (ActivityManager) ctx.getApplicationContext()
                .getSystemService(Context.ACTIVITY_SERVICE);
        String packageName = ctx.getApplicationContext().getPackageName();

        List<RunningAppProcessInfo> appProcesses = activityManager
                .getRunningAppProcesses();
        if (appProcesses == null) {
            LogUtils.d(TAG, "isAppOnForeground_process_null");
            return false;
        }

        for (RunningAppProcessInfo appProcess : appProcesses) {
            // The name of the process that this object is associated with.
            if (appProcess.processName.equals(packageName)) {
                LogUtils.d(TAG, "appProcess.importance:" + appProcess.importance);
                if (appProcess.importance == RunningAppProcessInfo.IMPORTANCE_FOREGROUND
                        || appProcess.importance == RunningAppProcessInfo.IMPORTANCE_PERCEPTIBLE) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 网络是否已连接
     *
     * @return
     */
    public static boolean isNetworkConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        boolean isConnected = false;
        NetworkInfo info = cm.getActiveNetworkInfo();

        if (null != info) {
            isConnected = info.isAvailable();
        }

        return isConnected;
    }


    /**
     * activity 是否在 top
     * 需要 android.permission.GET_TASKS 权限
     *
     * @param activity
     * @return
     */
    public static boolean isTopActivity(Activity activity) {
        boolean isTop = true;
        try {
            ActivityManager am = (ActivityManager) activity.getSystemService(Context.ACTIVITY_SERVICE);
            ComponentName cn = am.getRunningTasks(1).get(0).topActivity;
            isTop = cn.getClassName().contains(activity.getLocalClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isTop;
    }

    /**
     * 设置activity stateBar沉浸
     *
     * @param activity
     */
    public static void setStateBarTranslucentWithColor(Activity activity, int color) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && activity != null && !activity.isFinishing()) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    //5.0 translucent
                    Window window = activity.getWindow();
                    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                    window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.setStatusBarColor(color);

                } else {
                    //4.0 translucent
                    Window win = activity.getWindow();
                    WindowManager.LayoutParams winParams = win.getAttributes();
                    final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
                    winParams.flags |= bits;
                    win.setAttributes(winParams);

//                    SystemBarTintManager tintManager = new SystemBarTintManager(activity);
//                    tintManager.setStatusBarTintEnabled(true);
//                    tintManager.setStatusBarTintResource(R.color.lib_state_bar_bg);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取当前栈顶应用的包名
     *
     * @return
     */
    public static String getTopActivityPkgName(Context context) {
        String topPkg = "";
        try {
            ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            List<ActivityManager.RunningTaskInfo> runningTaskInfos = manager.getRunningTasks(1);
            if (runningTaskInfos != null && runningTaskInfos.size() > 0) {
                ComponentName cn = runningTaskInfos.get(0).topActivity;
                if (cn != null) {
                    topPkg = cn.getPackageName();
                }
            }
        } catch (Exception e) {
        }


        return topPkg;
    }



    public static String getDeviceID(Context context) {
        if (mDeviceId == null) {
            SharedPreferences sharedpreferences = context.getSharedPreferences("bids", 0);
            String s = sharedpreferences.getString("i", null);

            if (s == null) {
                s = getIMEI(context);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString("i", s);
                editor.commit();
            }
            String s1 = sharedpreferences.getString("a", null);
            if (s1 == null) {
                s1 = getAndroidId(context);
                SharedPreferences.Editor editor1 = sharedpreferences.edit();
                editor1.putString("a", s1);
                editor1.commit();
            }

            mDeviceId = Md5Tools.toMd5((new StringBuilder()).append("com.okay").append(s).append(s1).toString().getBytes(), true);
        }

        return mDeviceId;
    }

    private static String getIMEI(Context context) {
        String s = "";
        TelephonyManager telephonymanager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (telephonymanager != null) {
            s = telephonymanager.getDeviceId();
            if (TextUtils.isEmpty(s))
                s = "";
        }
        return s;
    }

    private static String getAndroidId(Context context) {
        String s = "";
        s = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (TextUtils.isEmpty(s))
            s = "";
        return s;
    }

    private static long mPreOrNextClickTime = 0;
    /**
     * @return
     */
    public static boolean fastClick() {
        long systemTime = System.currentTimeMillis();
        if (systemTime - mPreOrNextClickTime > 1000) {
            mPreOrNextClickTime = systemTime;
            return false;
        }
        return true;
    }
}
