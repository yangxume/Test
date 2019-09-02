package com.xy.brocast_receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.view.WindowManager.LayoutParams.TYPE_KEYGUARD_DIALOG



class MainActivity : AppCompatActivity() {

    private var TAG: String = "MainActivity"

    private lateinit var screenReceiver: ScreenReceiver

    private lateinit var homeWatcherReceiver: HomeWatcherReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        registerScreenReceiver()

        registerHomeWatcherReceiver()

    }

    private fun registerScreenReceiver() {

        var filter: IntentFilter = IntentFilter()
        filter.addAction(Intent.ACTION_SCREEN_ON)
        filter.addAction(Intent.ACTION_SCREEN_OFF)
        filter.addAction(Intent.ACTION_USER_PRESENT)
        filter.addAction(Intent.ACTION_CLOSE_SYSTEM_DIALOGS)

        screenReceiver = ScreenReceiver(object : ScreenReceiver.OnScreenListener {
            override fun screenOff() {

                Log.e(TAG, " screenOff ")
            }

            override fun screenOn() {
                Log.e(TAG, " screenOn ")

            }
        })
        registerReceiver(screenReceiver, filter)

    }

    private fun registerHomeWatcherReceiver() {

        homeWatcherReceiver = HomeWatcherReceiver()
        val intentFilter = IntentFilter(Intent.ACTION_CLOSE_SYSTEM_DIALOGS)
        registerReceiver(homeWatcherReceiver, intentFilter)

    }
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Log.e(TAG, " onAttachedToWindow ")

    }


    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()


        Log.e(TAG, " onDetachedFromWindow ")
    }

    override fun onBackPressed() {
        super.onBackPressed()
        return
    }

    override fun onDestroy() {
        super.onDestroy()

        if (screenReceiver != null) {
            unregisterReceiver(screenReceiver);
        }

        if (null != homeWatcherReceiver) {
            unregisterReceiver(homeWatcherReceiver)
        }
    }

    internal inner class HomeWatcherReceiver : BroadcastReceiver() {

        private val LOG_TAG = "HomeReceiver"
        private val SYSTEM_DIALOG_REASON_KEY = "reason"
        private val SYSTEM_DIALOG_REASON_RECENT_APPS = "recentapps"
        private val SYSTEM_DIALOG_REASON_HOME_KEY = "homekey"
        private val SYSTEM_DIALOG_REASON_LOCK = "lock"
        private val SYSTEM_DIALOG_REASON_ASSIST = "assist"

        override fun onReceive(context: Context, intent: Intent) {
            val action = intent.action
            android.util.Log.i(LOG_TAG, "onReceive: action: " + action!!)
            if (action == Intent.ACTION_CLOSE_SYSTEM_DIALOGS) {
                // android.intent.action.CLOSE_SYSTEM_DIALOGS
                val reason = intent.getStringExtra(SYSTEM_DIALOG_REASON_KEY)

                if (SYSTEM_DIALOG_REASON_HOME_KEY == reason) {
                    // 短按Home键
                    android.util.Log.i(LOG_TAG, "homekey")
                    return
//                    this@MainActivity.finish()
                } else if (SYSTEM_DIALOG_REASON_RECENT_APPS == reason) {
                    // 长按Home键 或者 activity切换键
                    android.util.Log.i(LOG_TAG, "long press home key or activity switch")
                    return
//                    this@MainActivity.finish()
                } else if (SYSTEM_DIALOG_REASON_LOCK == reason) {
                    // 锁屏
                    android.util.Log.i(LOG_TAG, "lock")
                } else if (SYSTEM_DIALOG_REASON_ASSIST == reason) {
                    // samsung 长按Home键
                    android.util.Log.i(LOG_TAG, "assist")
                }
            }
        }
    }


}
