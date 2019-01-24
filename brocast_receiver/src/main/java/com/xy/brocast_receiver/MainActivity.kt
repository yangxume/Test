package com.xy.brocast_receiver

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    private var tag: String = "MainActivity"

    private lateinit var mCtx : Context

    private lateinit var screenReceiver : ScreenReceiver
    private lateinit var filter : IntentFilter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mCtx = this
        createScreenReceiver()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        Log.e(tag, " onAttachedToWindow ")
        registerScreenReceiver()
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        Log.e(tag, " onDetachedFromWindow ")
        unRegisterScreenReceiver()
    }

    private fun registerScreenReceiver(){
        registerReceiver(screenReceiver,filter)
    }

    private fun unRegisterScreenReceiver(){
        mCtx.unregisterReceiver(screenReceiver)
    }

    private fun createScreenReceiver() {

        filter  =  IntentFilter()
        filter.addAction(Intent.ACTION_SCREEN_ON)
        filter.addAction(Intent.ACTION_SCREEN_OFF)
        filter.addAction(Intent.ACTION_USER_PRESENT)
        filter.addAction(Intent.ACTION_CLOSE_SYSTEM_DIALOGS)

        screenReceiver = ScreenReceiver(object : ScreenReceiver.OnScreenListener{
            override fun screenOff() {

                Log.e(tag, " screenOff ")
            }

            override fun screenOn() {
                Log.e(tag, " screenOn ")

            }
        })
    }
}
