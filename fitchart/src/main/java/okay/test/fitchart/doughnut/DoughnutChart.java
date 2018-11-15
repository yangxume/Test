/*
 * Copyright Txus Ballesteros 2015 (@txusballesteros)
 *
 * This file is part of some open source application.
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 * Contact: Txus Ballesteros <txus.ballesteros@gmail.com>
 */
package okay.test.fitchart.doughnut;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import okay.test.fitchart.R;

public class DoughnutChart extends View {
    static final int ANIMATION_MODE_LINEAR = 0;
    static final int ANIMATION_MODE_OVERDRAW = 1;
    static final int DEFAULT_VIEW_RADIUS = 0;
    static final int DEFAULT_MIN_VALUE = 0;
    static final int DEFAULT_MAX_VALUE = 100;
    static final int START_ANGLE = -90;
    static final int ANIMATION_DURATION = 1000;
    static final float INITIAL_ANIMATION_PROGRESS = 0.0f;
    static final float MAXIMUM_SWEEP_ANGLE = 360f;
    static final int DESIGN_MODE_SWEEP_ANGLE = 216;
    private RectF drawingArea;
    private Paint backStrokePaint;
    private Paint valueDesignPaint;
    private int backStrokeColor;
    private int valueStrokeColor;
    private float strokeSize;
    private float minValue = DEFAULT_MIN_VALUE;
    private float maxValue = DEFAULT_MAX_VALUE;
    private List<DoughnutChartValue> chartValues;
    private float animationProgress = INITIAL_ANIMATION_PROGRESS;
    private float maxSweepAngle = MAXIMUM_SWEEP_ANGLE;
    private AnimationMode animationMode = AnimationMode.LINEAR;

    public void setMinValue(float value) {
        minValue = value;
    }

    public void setMaxValue(float value) {
        maxValue = value;
    }

    public float getMinValue() {
        return minValue;
    }

    public float getMaxValue() {
        return maxValue;
    }

    private int startColor;
    private int endColor;

    public int getStartColor() {
        return startColor;
    }

    public void setStartColor(int startColor) {
        this.startColor = startColor;
    }

    public int getEndColor() {
        return endColor;
    }

    public void setEndColor(int endColor) {
        this.endColor = endColor;
    }

    public void setValue(float value, int startColor, int endColor) {
        chartValues.clear();
//        DoughnutChartValue chartValue = new DoughnutChartValue(value, valueStrokeColor);
        DoughnutChartValue chartValue = new DoughnutChartValue(value, startColor);
        chartValue.setPaint(buildPaintForValue());
        chartValue.setStartAngle(START_ANGLE);
        chartValue.setSweepAngle(calculateSweepAngle(value));
        chartValues.add(chartValue);
        maxSweepAngle = chartValue.getSweepAngle();
        this.startColor = startColor;
        this.endColor = endColor;
        playAnimation();
    }

    public void setValues(Collection<DoughnutChartValue> values) {
        chartValues.clear();
        maxSweepAngle = 0;
        float offsetSweepAngle = START_ANGLE;
        for (DoughnutChartValue chartValue : values) {
            float sweepAngle = calculateSweepAngle(chartValue.getValue());
            chartValue.setPaint(buildPaintForValue());
            chartValue.setStartAngle(offsetSweepAngle);
            chartValue.setSweepAngle(sweepAngle);
            chartValues.add(chartValue);
            offsetSweepAngle += sweepAngle;
            maxSweepAngle += sweepAngle;
        }
        playAnimation();
    }

    public void setAnimationMode(AnimationMode mode) {
        this.animationMode = mode;
    }

    void setAnimationSeek(float value) {
        animationProgress = value;
        invalidate();
    }

    private Paint buildPaintForValue() {
        Paint paint = getPaint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(strokeSize);
        paint.setStrokeCap(Paint.Cap.ROUND);
        return paint;
    }

    public DoughnutChart(Context context) {
        super(context);
        initializeView(null);
    }

    public DoughnutChart(Context context, AttributeSet attrs) {
        super(context, attrs);
        initializeView(attrs);
    }

    public DoughnutChart(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeView(attrs);
    }

    private void initializeView(AttributeSet attrs) {
        chartValues = new ArrayList<>();
        initializeBackground();
        readAttributes(attrs);
        preparePaints();
    }

    private void initializeBackground() {
        if (!isInEditMode()) {
            if (getBackground() == null) {
                setBackgroundColor(getContext().getResources().getColor(R.color.default_back_color));
            }
        }
    }

    float width;
    float height;
    private void calculateDrawableArea() {
        float drawPadding = (strokeSize / 2);
         width = getWidth();
         height = getHeight();
        float left = drawPadding;
        float top = drawPadding;
        float right = width - drawPadding;
        float bottom = height - drawPadding;
        drawingArea = new RectF(left, top, right, bottom);
    }

    private void readAttributes(AttributeSet attrs) {
        Resources resources = getContext().getResources();
//        valueStrokeColor = resources.getColor(R.color.green_end);
        backStrokeColor = resources.getColor(R.color.default_back_stroke_color);
//        strokeSize = resources.getDimension(R.dimen.default_stroke_size);
        strokeSize = 30;
        if (attrs != null) {
            TypedArray attributes = getContext()
                    .getTheme().obtainStyledAttributes(attrs, R.styleable.DoughnutChart, 0, 0);
            strokeSize = attributes
                    .getDimensionPixelSize(R.styleable.DoughnutChart_strokeSize, (int) strokeSize);
//            valueStrokeColor = attributes
//                    .getColor(R.styleable.DoughnutChart_valueStrokeColor, valueStrokeColor);

            backStrokeColor = attributes
                    .getColor(R.styleable.DoughnutChart_backStrokeColor, backStrokeColor);
            int attrAnimationMode = attributes.getInteger(R.styleable.DoughnutChart_animationMode, ANIMATION_MODE_LINEAR);
            if (attrAnimationMode == ANIMATION_MODE_LINEAR) {
                animationMode = AnimationMode.LINEAR;
            } else {
                animationMode = AnimationMode.OVERDRAW;
            }
            attributes.recycle();
        }
    }

    private void preparePaints() {
        backStrokePaint = getPaint();
        backStrokePaint.setColor(backStrokeColor);
        backStrokePaint.setStyle(Paint.Style.STROKE);
        backStrokePaint.setStrokeWidth(strokeSize);
        valueDesignPaint = getPaint();



//        valueDesignPaint.setColor(valueStrokeColor);
//        valueDesignPaint.setColor(startColor);
        valueDesignPaint.setShader(new SweepGradient(width / 2, height / 2, new int [] {startColor,endColor}, null));
        valueDesignPaint.setStyle(Paint.Style.STROKE);
        valueDesignPaint.setStrokeCap(Paint.Cap.ROUND);
        valueDesignPaint.setStrokeWidth(strokeSize);
    }

    private Paint getPaint() {
        if (!isInEditMode()) {
            return new Paint(Paint.ANTI_ALIAS_FLAG);
        } else {
            return new Paint();
        }
    }

    private float getViewRadius() {
        if (drawingArea != null) {
            return (drawingArea.width() / 2);
        } else {
            return DEFAULT_VIEW_RADIUS;
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        calculateDrawableArea();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        int size = Math.max(width, height);
        setMeasuredDimension(size, size);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        renderBack(canvas);
        renderValues(canvas);
    }

    private void renderBack(Canvas canvas) {
        Path path = new Path();
        float viewRadius = getViewRadius();
        path.addCircle(drawingArea.centerX(), drawingArea.centerY(), viewRadius, Path.Direction.CCW);
        canvas.drawPath(path, backStrokePaint);
    }

    private void renderValues(Canvas canvas) {
        if (!isInEditMode()) {
            int valuesCounter = (chartValues.size() - 1);
            for (int index = valuesCounter; index >= 0; index--) {
                renderValue(canvas, chartValues.get(index));
            }
        } else {
            renderValue(canvas, null);
        }
    }

    private void renderValue(Canvas canvas, DoughnutChartValue value) {

        SweepGradient sweepGradient = new SweepGradient(width, height, new int[]{endColor, startColor}, null);

        if (!isInEditMode()) {
            float animationSeek = calculateAnimationSeek();
            Renderer renderer = RendererFactory.getRenderer(animationMode, value, drawingArea);
            Path path = renderer.buildPath(animationProgress, animationSeek);
            if (path != null) {
                final Paint paint = value.getPaint();
                paint.setShader(sweepGradient);
                canvas.drawPath(path, paint);
            }
        } else {
            Path path = new Path();
            path.addArc(drawingArea, START_ANGLE, DESIGN_MODE_SWEEP_ANGLE);
            valueDesignPaint.setShader(sweepGradient);
            canvas.drawPath(path, valueDesignPaint);
        }
    }

    private float calculateAnimationSeek() {
        return ((maxSweepAngle * animationProgress) + START_ANGLE);
    }

    private float calculateSweepAngle(float value) {
        float chartValuesWindow = Math.max(minValue, maxValue) - Math.min(minValue, maxValue);
        float chartValuesScale = (360f / chartValuesWindow);
        return (value * chartValuesScale);
    }

    private void playAnimation() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(this, "animationSeek", 0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(ANIMATION_DURATION);
        animatorSet.setInterpolator(new DecelerateInterpolator());
        animatorSet.setTarget(this);
        animatorSet.play(animator);
        animatorSet.start();
    }

    /**
     * 颜色渐变算法
     * 获取某个百分比下的渐变颜色值
     *
     * @param percent
     * @param colors
     * @return
     */
    public static int getGradientColor(float percent, int[] colors) {
        float[][] f = new float[colors.length][3];
        for (int i = 0; i < colors.length; i++) {
            f[i][0] = (colors[i] & 0xff0000) >> 16;
            f[i][1] = (colors[i] & 0x00ff00) >> 8;
            f[i][2] = (colors[i] & 0x0000ff);
        }
        float[] result = new float[3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < f.length; j++) {
                if (f.length == 1 || percent == j / (f.length - 1f)) {
                    result = f[j];
                } else {
                    if (percent > j / (f.length - 1f) && percent < (j + 1f) / (f.length - 1)) {
                        result[i] = f[j][i] - (f[j][i] - f[j + 1][i]) * (percent - j / (f.length - 1f)) * (f.length - 1f);
                    }
                }
            }
        }
        return Color.rgb((int) result[0], (int) result[1], (int) result[2]);
    }
}
