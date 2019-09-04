package com.okay.test.keyboard;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.okay.test.R;

/**
 * @Author: yangxume@gmail.com
 * @Time: 2019-09-04 19:06
 * @Desc:
 */
public class ActivityKeyboard extends AppCompatActivity {

    private LinearLayout parent;
    private EditText et_account;
    private NestedScrollView scroll;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_keyboard);
        setContentView(R.layout.activity_keyboard_prefect);

//        parent = (LinearLayout) findViewById(R.id.ll_parent);
//        et_account = (EditText) findViewById(R.id.et_account);
//        scroll = (NestedScrollView) findViewById(R.id.scroll_view);
    }

    //键盘不遮挡按钮
    private void setScroll() {
        KeyboardUtil.assistActivity(this, R.id.scroll_view);       //这个是别人给我的工具类，只用这个会有

        parent.setOnTouchListener(new View.OnTouchListener() {                 //parent为Editext外面那层布局
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                parent.setFocusable(true);
                parent.setFocusableInTouchMode(true);
                parent.requestFocus();
                InputMethodManager imm = (InputMethodManager) ActivityKeyboard.this
                        .getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(et_account.getWindowToken(), 0);  //隐藏键盘，account为Editext，随便一个就好
                return false;
            }
        });

        scroll.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {         //scroll为parent外面那层布局（）最好用NestedScrollView，ScrollView会有版本问题
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                v.scrollTo(0,450);     //这个是滑动距离，随便大一点就好
            }
        });
    }
}
