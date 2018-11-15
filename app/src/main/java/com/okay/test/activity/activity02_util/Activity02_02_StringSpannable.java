package com.okay.test.activity.activity02_util;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.okay.test.R;
import com.okay.test.tools.MyToast;

import static com.okay.test.tools.MyToast.showToast;


/**
 * @Copyright (C), 2011-2012, 北京国电通网络技术有限公司.
 * @FileName
 * @Author yang.xu
 * @Version
 * @Date 2016/12/19
 * @Description:
 */

public class Activity02_02_StringSpannable extends AppCompatActivity {

    Context context;
    LinearLayout ll;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity02_02_spannablestring);

        context = Activity02_02_StringSpannable.this;
        ll = (LinearLayout) (LinearLayout) findViewById(R.id.ll);

        setFontByUseSpannableString();
        setFontByUseSpannableStringBuilder();

    }

    /**
     * start： 指定Span的开始位置
     * end： 指定Span的结束位置，并不包括这个位置。
     * flags：取值有如下四个：
     * Spannable.SPAN_EXCLUSIVE_INCLUSIVE：在 Span前面输入的字符不应用 Span的效果，在后面输入的字符应用Span效果。
     * Spannable.SPAN_INCLUSIVE_EXCLUSIVE：在 Span前面输入的字符应用 Span 的效果，在后面输入的字符不应用Span效果。
     * Spannable.SPAN_INCUJSIVE_INCLUSIVE：在 Span前后输入的字符都应用 Span 的效果。
     * Spannable.SPAN_EXCLUSIVE_EXCLUSIVE：前后都不包括。
     * BackgroundColorSpan : 文本背景色
     * ForegroundColorSpan : 文本颜色
     * AbsoluteSizeSpan : 文本字体（绝对大小）
     * StyleSpan : 字体样式：粗体、斜体等
     */
    private void setFontByUseSpannableStringBuilder() {

        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append("暗影IV已经开始暴走了");


//        ForegroundColorSpan forgroundColorSpan = new ForegroundColorSpan(Color.parseColor("#ffffff"));
//        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(Color.parseColor("#009ad6"));
//        spannableStringBuilder.setSpan(forgroundColorSpan, 0, 8, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
//        spannableStringBuilder.setSpan(backgroundColorSpan, 0, 8, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
//        addTv(this,spannableStringBuilder);


//        AbsoluteSizeSpan sizeSpan = new AbsoluteSizeSpan(20);
//        spannableStringBuilder.setSpan(sizeSpan, 0, 8, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
//        addTv(this,spannableStringBuilder);


//        StyleSpan styleSpan = new StyleSpan(Typeface.BOLD);//斜体
//        spannableStringBuilder.setSpan(styleSpan, 0, 3, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
//        StyleSpan styleSpan1 = new StyleSpan(Typeface.ITALIC);//斜体
//        spannableStringBuilder.setSpan(styleSpan1, 3, 6, Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
//        StyleSpan styleSpan2 = new StyleSpan(Typeface.BOLD_ITALIC);//粗斜体
//        spannableStringBuilder.setSpan(styleSpan2, 6, 9, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
//        addTv(this,spannableStringBuilder);


//        StrikethroughSpan strikethroughSpan = new StrikethroughSpan();
//        spannableStringBuilder.setSpan(strikethroughSpan,0,8,Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
//        addTv(this,spannableStringBuilder);

//        UnderlineSpan underlineSpan = new UnderlineSpan();
//        spannableStringBuilder.setSpan(underlineSpan,0,8,Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
//        addTv(this,spannableStringBuilder);

//        ImageSpan imageSpan = new ImageSpan(this,R.mipmap.ic_launcher);
//        spannableStringBuilder.setSpan(imageSpan,6,8,Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
//        addTv(this,spannableStringBuilder);

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                showToast(context,"请不要点我");
            }
        };
//        spannableStringBuilder.setSpan(clickableSpan,5,8,Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
//        TextView tv5 = new TextView(this);
//        tv5.setText(spannableStringBuilder);
//        tv5.setMovementMethod(LinkMovementMethod.getInstance());
//        ll.addView(tv5);

        ImageSpan imageSpan = new ImageSpan(this, R.mipmap.ic_launcher);
        spannableStringBuilder.setSpan(imageSpan,2,4,Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                MyToast.showToast(context,"点我啊");
            }
        };
        spannableStringBuilder.setSpan(clickableSpan,5,8,Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#ffffff"));
        spannableStringBuilder.setSpan(colorSpan,5,8,Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(Color.parseColor("#009ad6"));
        spannableStringBuilder.setSpan(backgroundColorSpan,5,8,Spanned.SPAN_EXCLUSIVE_INCLUSIVE);

        TextView tv6 = new TextView(this);
        tv6.setText(spannableStringBuilder);
        tv6.setMovementMethod(LinkMovementMethod.getInstance());
        ll.addView(tv6);

    }

    private void addTv(Context c, SpannableStringBuilder str) {
        TextView tv = new TextView(c);
        tv.setPadding(10, 10, 10, 10);
        tv.setText(str);

        ll.addView(tv);
    }

    /**
     * 使用SpannableString设置字体样式-字体颜色
     */
    private void setFontByUseSpannableString() {

        SpannableString spannableString = new SpannableString("暗影IV已经开始暴走了");
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#009ad6"));
        spannableString.setSpan(colorSpan, 0, 8, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);

        TextView tv = new TextView(this);
        tv.setText(spannableString);
        ll.addView(tv);
    }


}
