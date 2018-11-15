package com.okay.test.activity.activity02_util;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.okay.test.R;

/**
 * Copyright
 * <p>
 * Created by xuyang on 17/7/18 11:16
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */

public class Activity02_01_LiveTemplates extends Activity{


    private Context ctx;

    //const:常量补全
    private static final int num = 461;

    //logt:tag补全
    private static final String TAG = "Activity02_01_LiveTemplates";
    private TextView tvMain;
    private CustomView customView;

    //psvm:main方法补全
    public static void main(String[] args) {
        
    }
    //key:字符串常量
    private static final String success = "success";
    
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity02_01_livetemplates);

        tvMain = (TextView) findViewById(R.id.tv_main);


        //fori:for循环
        for (int i = 0; i < 100; i++) {

            System.out.println(i+"abc");

        }

        //ifn:if判断空
        if (success == null) {

        }
        //inn:if判断非空
        if (savedInstanceState != null) {

        }

        //gone:隐藏view
        tvMain.setVisibility(View.GONE);
        tvMain.setVisibility(View.VISIBLE);

        //rouit:快速在子线程中切换到主线程
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });

        //Sfmt:字符串格式化
        final String format = String.format("$d", 1);
    }

    //ViewConstructors:快速实现自定义View的三个构造方法
    class CustomView extends View{

        public CustomView(Context context) {
            this(context, null);
        }

        public CustomView(Context context, AttributeSet attrs) {
            this(context, attrs, 0);
        }

        public CustomView(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);

        }
        
    }

    /**
     * 3 后缀关键性
     */

    @Override
    protected void onPause() {
        super.onPause();

        /**
         * 3-1.判断
         * .notnull
         * .null
         */
        if (ctx != null) {
            //----
        }
        if (ctx == null) {

        }

        /**
         * 局部变量：.var
         */
        CustomView customView = new CustomView(ctx);

        /**
         * 全局变量.field
         */
        this.customView = new CustomView(ctx);

    }
}
