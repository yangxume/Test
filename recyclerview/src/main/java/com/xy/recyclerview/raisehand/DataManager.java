package com.xy.recyclerview.raisehand;

import android.os.Handler;

import java.util.HashMap;
import java.util.Map;

public class DataManager {

    private static DataManager mDataManager;

    private static Handler mHandler = new Handler();

    private Map<String, Runnable> runnableMap = new HashMap<>();

    private int speakState = 0;//0: 默认未发言  1 ： 发言请求中  2：请求超时

    public static DataManager getDataManager() {

        if (mDataManager == null) {
            mDataManager = new DataManager();
        }
        return mDataManager;
    }

    public Handler getmHandler() {
        return mHandler;
    }

    public Map<String, Runnable> getRunnableMap() {
        return runnableMap;
    }

    public int getSpeakState() {
        return speakState;
    }

    public void setSpeakState(int speakState) {
        this.speakState = speakState;
    }
}
