package com.okay.test.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Copyright
 * <p>
 * Created by xuyang on 17/11/6 15:05
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */

public class SpliceDrawableView extends View {

    private static final String TAG = SpliceDrawableView.class.getSimpleName();

    private int titleHeight = 150;
    private int screen_width = 0;
    private int screen_height = 0;

    public SpliceDrawableView(Context context) {
        super(context, null);
    }

    public SpliceDrawableView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
    }

    public SpliceDrawableView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initData() {

        DisplayMetrics dm = getResources().getDisplayMetrics();
        screen_width = dm.widthPixels;
        screen_height = dm.heightPixels;

    }

    public Bitmap spliceBitmap(String title, Bitmap... bitmaps) {

        if (bitmaps == null || bitmaps.length == 0)
            return null;

        initData();

        int bitmapWidth = bitmaps[0].getWidth();
        int bitmapHeight = titleHeight;

        for (int i = 0; i < bitmaps.length; i++) {
            bitmapHeight += bitmaps[i].getHeight();
        }

        //创建一个空的Bitmap(内存区域),宽度等于第一张图片的宽度，高度等于多张图片高度总和
        Bitmap bitmap = Bitmap.createBitmap(screen_width, bitmapHeight, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(bitmap);
        drawTitle(canvas, title, screen_width);
        // 计算左边位置
        int left = screen_width / 2 - bitmapWidth / 2;
        // 计算上边位置
        int top = screen_height / 2 - bitmapHeight / 2;
        //        mDestRect = new Rect(left, top, left + mBitWidth, top + mBitHeight);
        int tempHeight = titleHeight;
        for (int i = 0; i < bitmaps.length; i++) {
            if (i == 0) {
                canvas.drawBitmap(bitmaps[i], left, titleHeight, null);
                drawTitle(canvas,String.valueOf(i),screen_width);
            } else {
                tempHeight += bitmaps[i].getHeight();
                canvas.drawBitmap(bitmaps[i], left, tempHeight, null);
                drawTitle(canvas,String.valueOf(i),screen_width);

            }
        }

        return bitmap;

    }

    private void drawTitle(Canvas canvas, String text, int screen_width) {

        Rect rect = new Rect(0, 0, screen_width, 150);//画一个矩形
        Paint rectPaint = new Paint();
        rectPaint.setColor(Color.LTGRAY);
        rectPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(rect, rectPaint);

        Paint textPaint = new Paint();
        textPaint.setColor(Color.RED);
        textPaint.setTextSize(50);
        textPaint.setStyle(Paint.Style.FILL);
        //该方法即为设置基线上那个点究竟是left,center,还是right  这里我设置为center
        textPaint.setTextAlign(Paint.Align.CENTER);

        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float top = fontMetrics.top;//为基线到字体上边框的距离,即上图中的top
        float bottom = fontMetrics.bottom;//为基线到字体下边框的距离,即上图中的bottom

        int baseLineY = (int) (rect.centerY() - top / 2 - bottom / 2);//基线中间点的y轴计算公式

        canvas.drawText(text, rect.centerX(), baseLineY, textPaint);

    }


}
