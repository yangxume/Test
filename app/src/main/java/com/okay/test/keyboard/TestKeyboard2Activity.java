package com.okay.test.keyboard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.okay.test.R;
/**
 * @Author: yangxume@gmail.com
 * @Time: 2019-12-16 16:33
 * @Desc:
 *
 * (1）设置windowSoftInputMode为adjustNoting
 * 从上图发现，当点击EditText12时，弹出软键盘将主窗口下半部分给遮盖，并且主窗口没有做出任何反应。
 *
 * （2）设置windowSoftInputMode为adjustPan
 *当设置其属性为adjustPan时 ， 当软键盘弹出时 ， 主窗口布局会上移至直到显示EditText12 。
 *
 *（ 3 ） 设置windowSoftInputMode为adjustUnspecified
 *当设置其属性为默认属性adjustUnspecified时，
 * 发现当点击EditText12时，主窗口上移来保持EditText12在软键盘之上，
 * 这时adjustUnspecified的表现形式与adjustPan相同，所以在无滑动的控件上，默认的指定形式为adjustPan。
 *
 *（ 4 ） 设置windowSoftInputMode为adjustResize
 * 设置其属性为adjustResize时，发现软键盘弹出的状态与adjustNoting表现一致，
 * 当设置adjustResize时，布局会为了软键盘弹出而重新绘制给软键盘留出空间，而由于控件无法滑动，所以表现的形式与adjustNoting一致。
 *
 */
public class TestKeyboard2Activity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyboard_2);

    }
}
