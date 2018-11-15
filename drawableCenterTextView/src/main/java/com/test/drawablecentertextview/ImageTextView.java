package com.test.drawablecentertextview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/8/2 12:33
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */
public class ImageTextView extends android.support.v7.widget.AppCompatTextView {

    public static final int LEFT = 1;
    public static final int RIGHT = 2;
    public static final int TOP = 3;
    public static final int BOTTOM = 4;

    public ImageTextView(Context context) {
        super(context);
    }

    public ImageTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ImageTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void setImageInView(Context context,int round, int res) {

        Drawable drawable = ContextCompat.getDrawable(context, res);

        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getMinimumHeight());

        switch (round) {
            case LEFT:
                setCompoundDrawables(drawable, null, null, null);
                break;
            case RIGHT:
                setCompoundDrawables(null, null, drawable, null);
                break;
            case TOP:
                setCompoundDrawables(null, drawable, null, null);
                break;
            case BOTTOM:
                setCompoundDrawables(null, null, null, drawable);
                break;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //获取左边的图片
        Drawable drawableLeft = getCompoundDrawables()[0];
        if (drawableLeft != null) {
            //取得字符串的宽度值
            float textWidth = getPaint().measureText(getText().toString());
            //获取控件的内边距
            int drawablePadding = getCompoundDrawablePadding();
            int drawableWidth;
            //返回图片呢的固有宽度,单位是DP
            drawableWidth = drawableLeft.getIntrinsicWidth();
            float bodyWidth = textWidth + drawableWidth + drawablePadding;
            canvas.translate((getWidth() - bodyWidth) / 2, 0);
        }
        Drawable drawableRight = getCompoundDrawables()[2];
        if (drawableRight != null) {
            float textWidth = getPaint().measureText(getText().toString());
            int drawablePadding = getCompoundDrawablePadding();
            int drawableWidth = 0;
            drawableWidth = drawableRight.getIntrinsicWidth();
            float bodyWidth = textWidth + drawableWidth + drawablePadding;
            setPadding(0, 0, (int) (getWidth() - bodyWidth), 0);
            canvas.translate((getWidth() - bodyWidth) / 2, 0);
        }
        super.onDraw(canvas);
    }
}
