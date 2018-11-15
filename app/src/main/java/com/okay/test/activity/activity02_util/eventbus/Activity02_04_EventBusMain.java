package com.okay.test.activity.activity02_util.eventbus;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.okay.test.R;
import com.okay.test.tools.MyToast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;



/**
 * @Copyright (C), 2011-2012, 北京国电通网络技术有限公司.
 * @FileName
 * @Author yang.xu
 * @Version
 * @Date 2016/12/16
 * @Description:
 */

public class Activity02_04_EventBusMain extends AppCompatActivity {

    Button btn_try;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity02_04_eventbusmain);

        EventBus.getDefault().register(this);

        btn_try = (Button) findViewById(R.id.btn_try);

        btn_try.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                startActivity(new Intent(Activity02_04_EventBusMain.this,
                        Activity02_04_EventBusSec.class));
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN) //在ui线程执行
    public void onUserEvent(FirstEvent event) {

        String msg = event.getMsg();

        TextView tv = (TextView) findViewById(R.id.tv);
        tv.setText(msg);
        MyToast.showToast(Activity02_04_EventBusMain.this,msg);
    }


//    @Subscribe(threadMode = ThreadMode.BACKGROUND) //在后台线程执行
//    public void onUserEvent(FirstEvent event) {
//    }
//
//    @Subscribe(threadMode = ThreadMode.ASYNC) //强制在后台执行
//    public void onUserEvent(FirstEvent event) {
//    }
//
//    @Subscribe(threadMode = ThreadMode.POSTING) //默认方式, 在发送线程执行
//    public void onUserEvent(FirstEvent event) {
//    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        EventBus.getDefault().unregister(this);
    }
}
