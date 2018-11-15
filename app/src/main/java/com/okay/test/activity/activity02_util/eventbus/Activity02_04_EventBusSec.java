package com.okay.test.activity.activity02_util.eventbus;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.okay.test.R;

import org.greenrobot.eventbus.EventBus;


/**
 * @Copyright (C), 2011-2012, 北京国电通网络技术有限公司.
 * @FileName
 * @Author yang.xu
 * @Version
 * @Date 2016/12/27
 * @Description:
 */
public class Activity02_04_EventBusSec extends AppCompatActivity{

    Button btn_first_event;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity02_04_eventbussec);

        btn_first_event = (Button) findViewById(R.id.btn_first_event);

        btn_first_event.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new FirstEvent("FirstEvent btn clicked"));
            }
        });
    }
}
