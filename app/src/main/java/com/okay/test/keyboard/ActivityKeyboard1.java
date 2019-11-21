package com.okay.test.keyboard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.okay.test.R;

/**
 * @Author: yangxume@gmail.com
 * @Time: 2019-11-21 11:01
 * @Desc:
 */
public class ActivityKeyboard1 extends AppCompatActivity {

    private LinearLayout parent;
    private EditText et_account;
    private NestedScrollView scroll;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard_1);

    }
}
