package com.okay.test.activity

import android.app.ActivityManager
import android.app.ActivityManager.RunningAppProcessInfo.IMPORTANCE_BACKGROUND
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import com.okay.test.R
import com.okay.test.utils.LogUtils

class ProcessIsBackgroundActivity : AppCompatActivity() {

    private var TAG:String = "ProcessIsBackgroundActivity"

    private lateinit var mCtx : Context

    private lateinit var btn1 : Button
    private lateinit var tv1 : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_processisbackground)

        mCtx = this

        initView()
    }

    fun initView(){

        btn1 = findViewById(R.id.btn1) as Button
        tv1 = findViewById(R.id.tv1) as TextView

    }

    private fun isBackground() : Boolean {

        var activityManager : ActivityManager = getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val packageName : String = mCtx.packageName

        val runningAppProcesses : MutableList<ActivityManager.RunningAppProcessInfo> = activityManager.runningAppProcesses
                ?: return false

        for(runningAppProcesses in activityManager.runningAppProcesses){

            val b1 = runningAppProcesses.processName.equals(mCtx.packageName)
            val b2 = runningAppProcesses.importance === IMPORTANCE_BACKGROUND

            if (b1 && b2){
                return true
            }
        }
        return false

    }

    override fun onResume() {
        super.onResume()
        LogUtils.d(TAG," onResume app is background : "+ isBackground())
    }

    override fun onPause() {
        super.onPause()
        LogUtils.d(TAG," onPause app is background : "+ isBackground())
    }

    override fun onStop() {
        super.onStop()
        LogUtils.d(TAG," onStop app is background : "+ isBackground())
    }


}