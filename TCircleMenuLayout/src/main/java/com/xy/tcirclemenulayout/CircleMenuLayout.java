package com.xy.tcirclemenulayout;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class CircleMenuLayout extends ViewGroup {

    private int mRadius;
    /**
     * 该容器内child item的默认尺寸
     */
    private static final float RADIO_DEFAULT_CHILD_DIMENSION = 1 / 4f;
    /**
     * 菜单的中心child的默认尺寸
     */
    private float RADIO_DEFAULT_CENTERITEM_DIMENSION = 1 / 3f;
    /**
     * 该容器的内边距,无视padding属性，如需边距请用该变量
     */
    private static final float RADIO_PADDING_LAYOUT = 1 / 12f;

    /**
     * 当每秒移动角度达到该值时，认为是快速移动
     */
    private static final int FLINGABLE_VALUE = 300;

    /**
     * 如果移动角度达到该值，则屏蔽点击
     */
    private static final int NOCLICK_VALUE = 3;

    /**
     * 当每秒移动角度达到该值时，认为是快速移动
     */
    private int mFlingableValue = FLINGABLE_VALUE;
    /**
     * 该容器的内边距,无视padding属性，如需边距请用该变量
     */
    private float mPadding;

    /**
     * 布局时的开始角度
     */
    private double mStartAngle = 0;
    /**
     * 菜单项的文本
     */
    private String[] mItemTexts;
    /**
     * 菜单项的图标
     */
    private int[] mItemImgs;

    /**
     * 菜单的个数
     */
    private int mMenuItemCount;

    /**
     * 检测按下到抬起时旋转的角度
     */
    private float mTmpAngle;
    /**
     * 检测按下到抬起时使用的时间
     */
    private long mDownTime;

    /**
     * 判断是否正在自动滚动
     */
    private boolean isFling;

    private int menuItemCount;

    private int[] mItemIcons;

    public CircleMenuLayout(Context context) {
        super(context);
    }

    public CircleMenuLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        // 无视padding
        setPadding(0, 0, 0, 0);
    }

    public CircleMenuLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, 0);
    }

    public CircleMenuLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setMenuItemIconsAndTexts(int[] icons, String[] texts) {

        mItemIcons = icons;
        mItemTexts = texts;

        if (mItemIcons == null && mItemTexts == null) {
            throw new IllegalArgumentException("菜单项文本和图标至少设置1项");
        }

        menuItemCount = mItemIcons == null ? mItemTexts.length : mItemIcons.length;

        if (mItemTexts != null && mItemIcons != null) {

            menuItemCount = Math.min(mItemIcons.length, mItemTexts.length);

        }

        addMenuItem();
    }

    private void addMenuItem() {

        LayoutInflater inflater = LayoutInflater.from(getContext());

        for (int i = 0; i < menuItemCount; i++) {

            View view = inflater.inflate(R.layout.item_circle_menu, this, false);
            ImageView item_menu_iv = view.findViewById(R.id.item_menu_iv);
            TextView item_menu_tv = view.findViewById(R.id.item_menu_tv);

            if (item_menu_iv != null) {

                item_menu_iv.setVisibility(VISIBLE);
                item_menu_iv.setImageResource(mItemIcons[i]);
                item_menu_iv.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            }

            if (item_menu_tv != null) {
                item_menu_tv.setVisibility(VISIBLE);
                item_menu_tv.setText(mItemTexts[i]);
            }

            addView(view);
        }

    }

    /**
     * 设置布局的宽高，并策略menu item宽高
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int resWidth = 0;
        int resHeight = 0;

        /**
         * 根据传入的参数，分别获取测量模式和测量值
         */
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);

        int height = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        /**
         * 如果宽或者高的测量模式非精确值
         */
        if (widthMode != MeasureSpec.EXACTLY
                || heightMode != MeasureSpec.EXACTLY) {
            // 主要设置为背景图的高度
            resWidth = getSuggestedMinimumWidth();
            // 如果未设置背景图片，则设置为屏幕宽高的默认值
            resWidth = resWidth == 0 ? getDefaultWidth() : resWidth;

            resHeight = getSuggestedMinimumHeight();
            // 如果未设置背景图片，则设置为屏幕宽高的默认值
            resHeight = resHeight == 0 ? getDefaultWidth() : resHeight;
        } else {
            // 如果都设置为精确值，则直接取小值；
            resWidth = resHeight = Math.min(width, height);
        }

        setMeasuredDimension(resWidth, resHeight);

        // 获得半径
        mRadius = Math.max(getMeasuredWidth(), getMeasuredHeight());

        // menu item数量
        final int count = getChildCount();
        // menu item尺寸
        int childSize = (int) (mRadius * RADIO_DEFAULT_CHILD_DIMENSION);
        // menu item测量模式
        int childMode = MeasureSpec.EXACTLY;

        // 迭代测量
        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);

            if (child.getVisibility() == GONE) {
                continue;
            }

            // 计算menu item的尺寸；以及和设置好的模式，去对item进行测量
            int makeMeasureSpec = -1;

            if (child.getId() == R.id.id_circle_menu_item_center) {
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(
                        (int) (mRadius * RADIO_DEFAULT_CENTERITEM_DIMENSION),
                        childMode);
            } else {
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(childSize,
                        childMode);
            }
            child.measure(makeMeasureSpec, makeMeasureSpec);
        }

        mPadding = RADIO_PADDING_LAYOUT * mRadius;

    }

    /**
     * 设置menu item的位置
     */
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b)
    {
        int layoutRadius = mRadius;

        // Laying out the child views
        final int childCount = getChildCount();

        int left, top;
        // menu item 的尺寸
        int cWidth = (int) (layoutRadius * RADIO_DEFAULT_CHILD_DIMENSION);

        // 根据menu item的个数，计算角度
        float angleDelay = 360 / (getChildCount() - 1);

        // 遍历去设置menuitem的位置
        for (int i = 0; i < childCount; i++)
        {
            final View child = getChildAt(i);

            if (child.getId() == R.id.id_circle_menu_item_center)
                continue;

            if (child.getVisibility() == GONE)
            {
                continue;
            }

            mStartAngle %= 360;

            // 计算，中心点到menu item中心的距离
            float tmp = layoutRadius / 2f - cWidth / 2 - mPadding;

            // tmp cosa 即menu item中心点的横坐标
            left = layoutRadius
                    / 2
                    + (int) Math.round(tmp
                    * Math.cos(Math.toRadians(mStartAngle)) - 1 / 2f
                    * cWidth);
            // tmp sina 即menu item的纵坐标
            top = layoutRadius
                    / 2
                    + (int) Math.round(tmp
                    * Math.sin(Math.toRadians(mStartAngle)) - 1 / 2f
                    * cWidth);

            child.layout(left, top, left + cWidth, top + cWidth);
            // 叠加尺寸
            mStartAngle += angleDelay;
        }

        // 找到中心的view，如果存在设置onclick事件
        View cView = findViewById(R.id.id_circle_menu_item_center);
        if (cView != null)
        {
            cView.setOnClickListener(new OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    if (mOnMenuItemClickListener != null)
                    {
                        mOnMenuItemClickListener.onItemCenterClick(v);
                    }
                }
            });
            // 设置center item位置
            int cl = layoutRadius / 2 - cView.getMeasuredWidth() / 2;
            int cr = cl + cView.getMeasuredWidth();
            cView.layout(cl, cl, cr, cr);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    /**
     * 获得默认该layout的尺寸
     *
     * @return
     */
    private int getDefaultWidth()
    {
        WindowManager wm = (WindowManager) getContext().getSystemService(
                Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return Math.min(outMetrics.widthPixels, outMetrics.heightPixels);
    }

    public interface OnMenuItemClickListener {

        void onItemClick(View view, int position);

        void onItemCenterClick(View view);

    }

    public OnMenuItemClickListener mOnMenuItemClickListener;

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.mOnMenuItemClickListener = onMenuItemClickListener;
    }
}
