package com.xy.recyclerview;

import android.os.Handler;

import java.util.HashMap;
import java.util.Map;

public class DataManager {

    private static DataManager mDataManager;

    private static Handler mHandler = new Handler();

    private Map<String, Runnable> runnableMap = new HashMap<>();

    public static DataManager getDataManager(){

        if (mDataManager == null){
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
}
