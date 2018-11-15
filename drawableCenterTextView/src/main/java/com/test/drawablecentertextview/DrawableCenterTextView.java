package com.test.drawablecentertextview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/8/2 12:22
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */

/**
 * 自定义控件让TextView的drawableLeft或者drawableRight与文本一起居中显示
 */
public class DrawableCenterTextView extends AppCompatTextView {
    public DrawableCenterTextView(Context context) {
        this(context, null);
    }

    public DrawableCenterTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        Drawable[] drawables = getCompoundDrawables();
        if (drawables != null) {
            Drawable drawableTop = drawables[1];
            for (int i = 0; i < drawables.length; i++) {
                Drawable drawable = drawables[i];
                if (drawable != null) {
                    if (i == 0 || i==3) {
                        //drawableLeft or drawableRight with singline text four word ()
//                        float textWidth = getPaint().measureText(getText().toString());
                        float textWidth = getPaint().measureText("正正正正");
                        int drawablePadding = getCompoundDrawablePadding();
                        int drawableWidth = 0;
                        drawableWidth = drawable.getIntrinsicWidth();
                        float bodyWidth = textWidth + drawableWidth + drawablePadding;
                        canvas.translate((getWidth() - bodyWidth) / 2, 0);
                    } else if (i == 1 || i==4) {
                        //drawableTop or drawableBottom
                        float textHeight = getPaint().measureText("正正正正");
                        int drawablePadding = getCompoundDrawablePadding();
                        int drawableHeight = drawableTop.getIntrinsicHeight();
                        float bodyWidth = textHeight + drawableHeight + drawablePadding;
                        canvas.translate(0, (getHeight() - bodyWidth) / 2);
                    }
                }
            }
        }
        super.onDraw(canvas);

    }
}

