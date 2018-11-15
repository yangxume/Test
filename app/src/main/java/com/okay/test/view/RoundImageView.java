package com.okay.test.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;

import com.okay.test.R;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/1/18 17:58
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */

public class RoundImageView extends ImageView {

    // 0: 圆形 1：圆角
    private int type = 0;
    private static final int TYPE_CIRCLE = 0;
    private static final int TYPE_ROUND = 1;

    //默认圆角半径
    private static final int DEFAULT_ROUND_RADIUS = 10;

    //圆形半径
    private int mRadius;

    //圆角半径
    private int mRoundRadius;

    private Paint mPaint;

    private int viewWidth;

    private Matrix mMatrix;

    private RectF mRoundRectf;

    public RoundImageView(Context context) {
        super(context);
    }

    public RoundImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        mMatrix = new Matrix();
        mPaint = new Paint();
        mPaint.setAntiAlias(true);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.RoundImage);

        mRoundRadius = typedArray.getDimensionPixelSize(
                R.styleable.RoundImage_borderRadius, (int) TypedValue
                        .applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                                DEFAULT_ROUND_RADIUS, getResources()
                                        .getDisplayMetrics()));// 默认为10dp

        type = typedArray.getInt(R.styleable.RoundImage_type, TYPE_CIRCLE);
        typedArray.recycle();


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        if (type == TYPE_CIRCLE){

            viewWidth = Math.min(getMeasuredWidth(),getMeasuredHeight());
            mRadius = viewWidth/2;
            setMeasuredDimension(viewWidth,viewWidth);
        }

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (type == TYPE_ROUND)
            mRoundRectf = new RectF(0,0,getWidth(),getHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (getDrawable() == null)
            return;
        setUpShader();

        if (type == TYPE_ROUND)
            canvas.drawRoundRect(mRoundRectf,mRoundRadius,mRoundRadius,mPaint);
        else
            canvas.drawCircle(mRadius,mRadius,mRadius,mPaint);
    }
    BitmapShader mBitmapShader;
    /**
     * 初始化BitmapShader
     */
    private void setUpShader()
    {
        Drawable drawable = getDrawable();
        if (drawable == null)
        {
            return;
        }

        Bitmap bmp = drawableToBitamp(drawable);
        // 将bmp作为着色器，就是在指定区域内绘制bmp
        mBitmapShader = new BitmapShader(bmp, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        float scale = 1.0f;
        if (type == TYPE_CIRCLE)
        {
            // 拿到bitmap宽或高的小值
            int bSize = Math.min(bmp.getWidth(), bmp.getHeight());
            scale = viewWidth * 1.0f / bSize;

        } else if (type == TYPE_ROUND)
        {
            // 如果图片的宽或者高与view的宽高不匹配，计算出需要缩放的比例；缩放后的图片的宽高，一定要大于我们view的宽高；所以我们这里取大值；
            scale = Math.max(getWidth() * 1.0f / bmp.getWidth(), getHeight()
                    * 1.0f / bmp.getHeight());
        }
        // shader的变换矩阵，我们这里主要用于放大或者缩小
        mMatrix.setScale(scale, scale);
        // 设置变换矩阵
        mBitmapShader.setLocalMatrix(mMatrix);
        // 设置shader
        mPaint.setShader(mBitmapShader);
    }

    /**
     * drawable转bitmap
     *
     * @param drawable
     * @return
     */
    private Bitmap drawableToBitamp(Drawable drawable)
    {
        if (drawable instanceof BitmapDrawable)
        {
            BitmapDrawable bd = (BitmapDrawable) drawable;
            return bd.getBitmap();
        }
        int w = drawable.getIntrinsicWidth();
        int h = drawable.getIntrinsicHeight();
        Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, w, h);
        drawable.draw(canvas);
        return bitmap;
    }
}
