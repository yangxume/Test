package com.okay.test.keyboard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.okay.test.R;

/**
 * @Author: yangxume@gmail.com
 * @Time: 2019-11-21 11:01
 * @Desc:
 */
public class ActivityKeyboard1 extends AppCompatActivity implements View.OnLayoutChangeListener{

    private ScrollView scrollview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard_1);
        scrollview = (ScrollView) findViewById(R.id.scrollview);
        scrollview.addOnLayoutChangeListener(this);
    }

    @Override
    public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {

        scrollview.scrollTo(0,bottom);

    }
}
