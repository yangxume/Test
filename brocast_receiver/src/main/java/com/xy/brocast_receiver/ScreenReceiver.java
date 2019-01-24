package com.xy.brocast_receiver;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/3/26 14:55
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */

public class ScreenReceiver extends BroadcastReceiver {

    private final String TAG = ScreenReceiver.class.getSimpleName();

    private static final String SYSTEM_DIALogUtils_REASON_KEY = "reason";
    private static final String SYSTEM_DIALogUtils_REASON_RECENT_APPS = "recentapps";
    private static final String SYSTEM_DIALogUtils_REASON_HOME_KEY = "homekey";
    private static final String SYSTEM_DIALogUtils_REASON_LOCK = "lock";
    private static final String SYSTEM_DIALogUtils_REASON_ASSIST = "assist";

    private static final String SCREEN_ON = "android.intent.action.SCREEN_ON";
    private static final String SCREEN_OFF = "android.intent.action.SCREEN_OFF";
    private static final String USER_PRESENT = "android.intent.action.USER_PRESENT";

    private ScreenReceiver.OnScreenListener mListener;

    public ScreenReceiver(ScreenReceiver.OnScreenListener onScreenListener) {
        this.mListener = onScreenListener;
    }

    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();

        if(SCREEN_ON.equals(action)) {

        } else if(SCREEN_OFF.equals(action) && this.mListener != null) {

                this.mListener.screenOff();

        } else if(USER_PRESENT.equals(action) && this.mListener != null) {

            this.mListener.screenOn();

        } else if (action.equals(Intent.ACTION_CLOSE_SYSTEM_DIALOGS) && mListener != null) {

//            this.mListener.onLongPressHomekey();

            //String reason = intent.getStringExtra(SYSTEM_DIALogUtils_REASON_KEY);
            //LogUtils.d(TAG, "reason: " + reason);

//            if (SYSTEM_DIALogUtils_REASON_HOME_KEY.equals(reason)) {
//
//                // 短按Home键
//                LogUtils.d(TAG, "homekey");
////                this.mListener.onLongPressHomekey();
//
//            }
//            else if (SYSTEM_DIALogUtils_REASON_RECENT_APPS.equals(reason)) {
//
//                // 长按Home键 或者 activity切换键
//                LogUtils.d(TAG, "long press home key or activity switch");
//
//            }
//            else if (SYSTEM_DIALogUtils_REASON_LOCK.equals(reason)) {
//                // 锁屏
//                LogUtils.i(TAG, "lock");
//            }
//            else if (SYSTEM_DIALogUtils_REASON_ASSIST.equals(reason)) {
//                // samsung 长按Home键
//                LogUtils.i(TAG, "assist");
//            }

        }

    }

    public interface OnScreenListener {
        void screenOn();

        void screenOff();

//        void onLongPressHomekey();

    }
}

