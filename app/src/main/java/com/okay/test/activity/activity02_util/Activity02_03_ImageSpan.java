package com.okay.test.activity.activity02_util;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.BackgroundColorSpan;
import android.text.style.DynamicDrawableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;

import com.okay.test.R;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Copyright
 * <p>
 * Created by xuyang on 17/10/11 15:01
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description  Android图文混排实现方式详解
 * <p>
 * Update records:
 */

public class Activity02_03_ImageSpan extends AppCompatActivity {

    @BindView(R.id.tv)
    TextView tv;
    @BindView(R.id.tv1)
    TextView tv1;
    @BindView(R.id.tv2)
    TextView tv2;
    @BindView(R.id.tv3)
    TextView tv3;
    private Context ctx;

    private Drawable leftDrawable;
    private Drawable rightDrawable;
    private Drawable topDrawable;
    private Drawable bottomDrawable;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity02_03_imagespan);
        ButterKnife.bind(this);
        ctx = Activity02_03_ImageSpan.this;

        init();

        /**
         * 1.通过TextView的drawable在上下左右四个方向放置图片
         */
        drawable();

        /**
         * 2.Spannable
         */
//        BackgroundColorSpan	背景色样式，显然可以用来设定文本的背景色
//        ForegroundColorSpan	字体颜色样式，用于改变字体颜色
//        StyleSpan 主要由正常、粗体、斜体和同时加粗倾斜四种样式
//        TypefaceSpan 设置不同的字体
//        ImageSpan	图片样式，主要用于在文本中插入图片
//        URLSpan 可以打开一个链接
//        UnderlineSpan 下划线样式
//        StrikethroughSpan 删除线样式

        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(
                ContextCompat.getColor(this, android.R.color.holo_blue_bright));

        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(
                ContextCompat.getColor(this, android.R.color.holo_red_light));

        final StyleSpan styleSpanNormal = new StyleSpan(Typeface.NORMAL);
        final StyleSpan styleSpanBold = new StyleSpan(Typeface.BOLD);
        final StyleSpan styleSpanItalic = new StyleSpan(Typeface.ITALIC);
        final StyleSpan styleSpanBoldItalic = new StyleSpan(Typeface.BOLD_ITALIC);

        ImageSpan imageSpan = new ImageSpan(this, R.mipmap.ic_launcher, DynamicDrawableSpan.ALIGN_BOTTOM);


        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("012345678901234567890123456789");

        spannableStringBuilder.setSpan(backgroundColorSpan, 1, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        spannableStringBuilder.setSpan(foregroundColorSpan, 6, 10, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        spannableStringBuilder.setSpan(styleSpanBold, 12, 14, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilder.setSpan(styleSpanItalic, 14, 16, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableStringBuilder.setSpan(styleSpanBoldItalic, 16, 18, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        spannableStringBuilder.setSpan(imageSpan, 20, 22, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        tv3.setText(spannableStringBuilder);


    }

    private void init() {

        leftDrawable = ContextCompat.getDrawable(ctx, R.mipmap.ic_launcher);
        rightDrawable = ContextCompat.getDrawable(ctx, R.mipmap.ic_launcher);
        topDrawable = ContextCompat.getDrawable(ctx, R.mipmap.ic_launcher);
        bottomDrawable = ContextCompat.getDrawable(ctx, R.mipmap.ic_launcher);
    }


    //    在TextView中使用Compound Drawable属性可以在文字的上下左右放置drawable，
    private void drawable() {


//        setCompoundDrawables 	设置上下左右位置的图片
//        setCompoundDrawablesRelative 	设置四周的图片，其中两边对应xml中的start,end
//        setCompoundDrawablesWithIntrinsicBounds 	设置上下左右位置的图片，图片有默认的边界
//        setCompoundDrawablesRelativeWithIntrinsicBounds 	设置四周的图片，图片有默认的边界
//        setCompoundDrawablePadding 	设置图片与文字之间的间距

        leftDrawable.setBounds(0, 0, leftDrawable.getIntrinsicWidth(), leftDrawable.getIntrinsicHeight());//必须setBounds()测量图片边界，否则不显示。
        rightDrawable.setBounds(0, 0, rightDrawable.getIntrinsicWidth(), rightDrawable.getIntrinsicHeight());
        topDrawable.setBounds(0, 0, topDrawable.getIntrinsicWidth(), topDrawable.getIntrinsicHeight());//必须setBounds()测量图片边界，否则不显示。
        bottomDrawable.setBounds(0, 0, bottomDrawable.getIntrinsicWidth(), bottomDrawable.getIntrinsicHeight());//必须setBounds()测量图片边界，否则不显示。

//        tv.setCompoundDrawables(leftDrawable, null, null, null);//设置上下左右位置的图片
//        tv.setCompoundDrawablePadding(10);

//        tv.setCompoundDrawablesRelative(leftDrawable,topDrawable,rightDrawable,bottomDrawable);

//        tv.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.left,
//                R.mipmap.top,R.mipmap.right,R.mipmap.bottom);


        tv.setCompoundDrawablesRelativeWithIntrinsicBounds(leftDrawable, topDrawable, rightDrawable, bottomDrawable);


        tv1.setCompoundDrawables(leftDrawable, null, null, null);
    }

}
