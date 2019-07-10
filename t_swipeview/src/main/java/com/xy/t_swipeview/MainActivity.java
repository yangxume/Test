package com.xy.t_swipeview;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;


/**
 *     原文：https://blog.csdn.net/qiuchunjia/article/details/51094667
 *
 * 第一步：滚动的时候试着改变头部的高度
 *
 * 第二步：逐渐让周围不需要的字体消失
 *
 * 第三步：根据偏移率计算偏移量，然后把图片和需要的文字移动到顶端中心处
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private int mLastY = 0;  //最后的点
    private static int mNeedDistance;   // 需要滑动的距离
    private static int mMinHight; //最小高度
    private static int mOrignHight; //原始的高度

    private int mCurrentDistance = 0;  //当前的距离
    private float mRate = 0;  //距离与目标距离的变化率 mRate=mCurrentDistance/mNeedDistance
    private int mPhotoOriginHeight; //图片的原始高度
    private int mPhotoOriginWidth; //图片的原始宽度
    private int mPhotoLeft;  //图片距左边的距离
    private int mPhotoTop;  //图片距离上边的距离
    private int mPhotoNeedMoveDistanceX;  // 图片需要移动的X距离
    private int mPhotoNeedMoveDistanceY;  // 图片需要移动的Y距离
    //需要移动的文字
    private int mTextLeft;  //文字距左边的距离
    private int mTextTop;  //文字距离上边的距离
    private int mTextNeedMoveDistanceX;  // 文字需要移动的X距离
    private int mTextNeedMoveDistanceY;  //文字需要移动的Y距离

    private RelativeLayout rl_header;
    private ImageView img_head_portrait;


    private TextView tv_user_name;
    private TextView tv_user_hosipital;
    private TextView tv_user_hosipital_level;
    private TextView tv_user_project;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initDistance();

    }

    private void initView() {

        rl_header = findViewById(R.id.rl_header);
        img_head_portrait = findViewById(R.id.iv_header);
        tv_user_name = findViewById(R.id.tv_user_name);
        tv_user_hosipital = findViewById(R.id.tv_user_hosipital);
        tv_user_hosipital_level = findViewById(R.id.tv_user_hosipital_level);
        tv_user_project = findViewById(R.id.tv_user_project);
    }

    public void initData(){

        Uri uri = Uri.parse("https://hd.okjiaoyu.cn/hd_1a0o5FFBjpu.jpg");
        img_head_portrait.setImageURI(uri);

    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastY = (int) ev.getY();
//                Log.d(TAG, "ACTION_MOVE==mCurrentDistance" + mCurrentDistance);
                return super.dispatchTouchEvent(ev); //传递事件 例如可以用来子view的点击事件等
            case MotionEvent.ACTION_MOVE:
                int y = (int) ev.getY();
                int dy = mLastY - y;
//                Log.d(TAG, "ACTION_MOVE==mCurrentDistance" + mCurrentDistance);
                if (mCurrentDistance >= mNeedDistance && dy > 0) {
                    return super.dispatchTouchEvent(ev);  //传递事件
                }
                if (mCurrentDistance <= 0 && dy < 0) {
                    return super.dispatchTouchEvent(ev); //把事件传递进去
                }
                //改变布局
                changeTheLayout(dy);
                mLastY = y;
                break;
            case MotionEvent.ACTION_UP:
                checkTheHeight();
//                Log.d(TAG, "ACTION_MOVE==mCurrentDistance" + mCurrentDistance);
                return super.dispatchTouchEvent(ev);
        }

        return false;
    }

    private void changeTheLayout(int dy) {
        final ViewGroup.LayoutParams layoutParams = rl_header.getLayoutParams();
        layoutParams.height = layoutParams.height - dy;
        rl_header.setLayoutParams(layoutParams);
        checkTheHeight();
        rl_header.requestLayout();
        //计算当前移动了多少距离
        mCurrentDistance = mOrignHight - rl_header.getLayoutParams().height;
        mRate = (float) (mCurrentDistance * 1.0 / mNeedDistance);
        changeTheAlphaAndPostion(mRate);  //获取偏移率然后改变某些控件的透明度，和位置
    }

    /**
     * 根据变化率来改变这些这些控件的变化率位置
     *
     * @param rate
     */
    private void changeTheAlphaAndPostion(float rate) {
        //先改变一些控件的透明度
        if (rate >= 1) {
            tv_user_hosipital.setVisibility(View.GONE);
            tv_user_hosipital_level.setVisibility(View.GONE);
            tv_user_project.setVisibility(View.GONE);
        } else {
            tv_user_hosipital.setVisibility(View.VISIBLE);
            tv_user_hosipital_level.setVisibility(View.VISIBLE);
            tv_user_project.setVisibility(View.VISIBLE);
            tv_user_hosipital.setAlpha(1 - rate);
            tv_user_hosipital_level.setAlpha(1 - rate);
            tv_user_project.setAlpha(1 - rate);
            tv_user_hosipital.setScaleY(1 - rate);
            tv_user_hosipital.setScaleX(1 - rate);
            tv_user_hosipital_level.setScaleY(1 - rate);
            tv_user_hosipital_level.setScaleX(1 - rate);
            tv_user_project.setScaleY(1 - rate);
            tv_user_project.setScaleX(1 - rate);
        }
        //接下来是改变控件的大小和位置了  （这就是关键了）
        final RelativeLayout.LayoutParams photoParams = (RelativeLayout.LayoutParams) img_head_portrait.getLayoutParams();
        photoParams.width = (int) (mPhotoOriginWidth - (rate * (mPhotoOriginWidth - mMinHight - UIUtils.dip2px(this, 10))));
        photoParams.height = (int) (mPhotoOriginWidth - (rate * (mPhotoOriginWidth - mMinHight - UIUtils.dip2px(this, 10))));
        photoParams.leftMargin = (int) (mPhotoLeft + mPhotoNeedMoveDistanceX * rate);
        photoParams.topMargin = (int) (mPhotoTop - mPhotoNeedMoveDistanceY * rate);
        Log.d(TAG, "photoParams.leftMargin" + photoParams.leftMargin);
        Log.d(TAG, " photoParams.topMargin" + photoParams.topMargin);
        img_head_portrait.setLayoutParams(photoParams);
        /*********************文字设置****************************/
        final RelativeLayout.LayoutParams textParams = (RelativeLayout.LayoutParams) tv_user_name.getLayoutParams();
        textParams.leftMargin = (int) (mTextLeft + mTextNeedMoveDistanceX * rate);
        textParams.topMargin = (int) (mTextTop - mTextNeedMoveDistanceY * rate);
        Log.d(TAG, "textParams.leftMargin" + textParams.leftMargin);
        Log.d(TAG, " textParams.topMargin" + textParams.topMargin);
        tv_user_name.setLayoutParams(textParams);
    }

    /**
     * 初始化需要滚动的距离
     */
    private void initDistance() {
        mOrignHight = rl_header.getLayoutParams().height;
        mMinHight = UIUtils.dip2px(this, 45);  //设置最小的高度为这么多
        mNeedDistance = mOrignHight - mMinHight;
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) img_head_portrait.getLayoutParams();
        mPhotoOriginHeight = params.height;
        mPhotoOriginWidth = params.width;
        mPhotoLeft = params.leftMargin;
        mPhotoTop = params.topMargin;

        int[] screens = UIUtils.getWindowWidth(getWindowManager(), this.getApplicationContext());

        int screenWidth = screens[0];
        int screenHeight = screens[1];

        mPhotoNeedMoveDistanceX = screenWidth / 2 - mPhotoLeft - mMinHight;
        mPhotoNeedMoveDistanceY = mPhotoTop - UIUtils.dip2px(this, 10);
        /*******************移动的文字初始化***************************/
        RelativeLayout.LayoutParams textParams =
                (RelativeLayout.LayoutParams) tv_user_name.getLayoutParams();
        mTextLeft = textParams.leftMargin;
        mTextTop = textParams.topMargin;
        mTextNeedMoveDistanceX = screenWidth / 2 - mTextLeft + 10;
        mTextNeedMoveDistanceY = mTextTop - mMinHight / 2 / 2;  //这里计算有点误差，正确的应该是剪去获取textview高度的一半
    }

    /**
     * 检查上边界和下边界
     */
    private void checkTheHeight() {
        final ViewGroup.LayoutParams layoutParams = rl_header.getLayoutParams();
        if (layoutParams.height < mMinHight) {
            layoutParams.height = mMinHight;
            rl_header.setLayoutParams(layoutParams);
            rl_header.requestLayout();
        }
        if (layoutParams.height > mOrignHight) {
            layoutParams.height = mOrignHight;
            rl_header.setLayoutParams(layoutParams);
            rl_header.requestLayout();
        }

    }
}
