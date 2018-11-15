package com.okay.test.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * @Copyright (C), 2017
 * @FileName
 * @Author yang.xu
 * @email xuyangme@126.com
 * @Version
 * @Date 2017/3/31
 * @Description:
 */

public class CircleView extends View {

    private Paint mPaintCircle;
    private Paint mPaintText;
    private String mTextStr;
    private int mTextWidth;
    private int mTextHeight;

    public CircleView(Context context) {
        this(context, null);
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mPaintCircle = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintCircle.setColor(Color.GRAY);

        //添加文字的画加入以下代码
        mPaintText = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaintText.setColor(ContextCompat.getColor(context, android.R.color.black));
        mPaintText.setTextSize(40F);
        mTextStr = "正确率 60%";
        Rect mBoundText = new Rect();
        mPaintText.getTextBounds(mTextStr, 0, mTextStr.length(), mBoundText);
        mTextWidth = mBoundText.width();
        mTextHeight = mBoundText.height();
    }

    private int mWidth;
    private int mHeight;
    private float mRadius;

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        mWidth = w;  // x 的值就是宽度的一半
        mHeight = h;  // y 的值就是高度的一半
        mRadius = Math.min(mWidth / 2, mHeight / 2);  // 得到了radius的值
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(mWidth / 2, mHeight / 2, mRadius, mPaintCircle);

        //添加文字添加
        canvas.drawText(mTextStr, (mWidth - mTextWidth) / 2, (mHeight + mTextHeight) / 2, mPaintText);
    }

}
