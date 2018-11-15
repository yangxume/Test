package com.okay.test.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.util.DisplayMetrics;

/**
 * Copyright
 * <p>
 * Created by xuyang on 17/11/14 16:17
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */

public class DashLineUtils {


    int screen_width = 0;
    int screen_height = 0;

    public DashLineUtils(Context context) {

       initData(context);
    }

    private void initData(Context context) {

        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        screen_width = dm.widthPixels;
        screen_height = dm.heightPixels;

    }

    public Bitmap drawDashLine(){

        Bitmap newBitmap = Bitmap.createBitmap(
                screen_width - 100, screen_height - 100,
                Bitmap.Config.ARGB_8888);


        Canvas canvas = new Canvas(newBitmap);
//        canvas.drawColor(Color.WHITE, PorterDuff.Mode.CLEAR);//绘制透明色

//        Paint linePaint = new Paint();
//        linePaint.setColor(Color.RED);
//        linePaint.setTextSize(20);
//        linePaint.setAntiAlias(true);
//        linePaint.setStyle(Paint.Style.STROKE);
//        canvas.drawLine(0, 50, screen_width, 50, linePaint);


        Paint linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        linePaint.setColor(Color.parseColor("#FFC5D8E6"));
        linePaint.setTextSize(20);
        linePaint.setAntiAlias(true);
        linePaint.setStyle(Paint.Style.FILL);
        PathEffect effects = new DashPathEffect(new float[] { 10,10}, 1);
        linePaint.setPathEffect(effects);

        canvas.drawLine(0, 40, screen_width, 40, linePaint);

        return newBitmap;
    }

}
