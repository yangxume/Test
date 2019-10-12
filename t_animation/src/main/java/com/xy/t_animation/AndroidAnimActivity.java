package com.xy.t_animation;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * View Animation
 * <p>
 * Frame animation:
 * https://developer.android.google.cn/guide/topics/resources/animation-resource.html?hl=en#Frame
 * Tween animation
 * https://developer.android.google.cn/guide/topics/resources/animation-resource.html?hl=en#Tween
 * <p>
 * Property Animation
 * https://developer.android.google.cn/guide/topics/resources/animation-resource.html?hl=en#Property
 * https://blog.csdn.net/guolin_blog/article/details/43536355
 *
 * @CreateDate: 2019-08-29 14:53
 * @Version: 1.0
 */
public class AndroidAnimActivity extends AppCompatActivity {

    private static final String TAG = AndroidAnimActivity.class.getSimpleName();

    @BindView(R.id.tv)
    TextView tv;

    //Tween Animation
    @BindView(R.id.btn_tween_alpha)
    Button btnTweenAlpha;
    @BindView(R.id.btn_tween_rotate)
    Button btnTweenRotate;
    @BindView(R.id.btn_tween_scale)
    Button btnTweenScale;
    @BindView(R.id.btn_tween_translate)
    Button btnTweenTranslate;

    @BindView(R.id.btn_value_anim)
    Button btnValueAnim;

    @BindView(R.id.btn_object_anim)
    Button btnObjectAnim;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_android_anim);
        ButterKnife.bind(this);

    }

    @OnClick({
            R.id.btn_tween_alpha,
            R.id.btn_tween_rotate,
            R.id.btn_tween_scale,
            R.id.btn_tween_translate,

            R.id.btn_value_anim,
            R.id.btn_object_anim})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.btn_tween_alpha:
                tweenAlpha();
                break;

            case R.id.btn_tween_rotate:
                tweenRotate();
                break;

            case R.id.btn_tween_scale:
                tweenScale();
                break;

            case R.id.btn_tween_translate:
                tweenTranslate();
                break;

            case R.id.btn_value_anim:
                testValueAnimation();//logcat 查看日志
                break;
            case R.id.btn_object_anim:
                testObjectAnimation();
                break;
        }
    }

    private void tweenTranslate() {

    }

    private void tweenScale() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.tween_scale);
        tv.startAnimation(animation);
    }

    private void tweenRotate() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.tween_rotate);
        tv.startAnimation(animation);
    }

    private void tweenAlpha() {

    }


    private void testObjectAnimation() {

        long duration = 5000;

//        alpha、rotation、translationX和scaleY这几个值，分别可以完成淡入淡出、旋转、水平移动、垂直缩放这几种动画

        //alpha
        ObjectAnimator alpha = ObjectAnimator.ofFloat(tv, "alpha", 1f, 0f, 1f);
        alpha.setDuration(duration);
//        alpha.start();
        tv.getAlpha();

        //rotation
        ObjectAnimator rotation = ObjectAnimator.ofFloat(tv, "rotation", 0f, 360f);
        rotation.setDuration(duration);
//        rotation.start();

        float translationX = tv.getTranslationX();
        ObjectAnimator translation = ObjectAnimator.ofFloat(tv, "translationX", translationX, -500, translationX);
        translation.setDuration(duration);
//        translation.start();

        ObjectAnimator scaleX = ObjectAnimator.ofFloat(tv, "scaleX", 1f, 3f, 1f);
        scaleX.setDuration(duration);
//        scaleX.start();

        ObjectAnimator scaleY = ObjectAnimator.ofFloat(tv, "scaleY", 1f, 3f, 1f);
        scaleY.setDuration(duration);
//        scaleY.start();

        /**
         * AnimatorSet.Builder中包括以下四个方法：
         *
         *         after(Animator anim)   将现有动画插入到传入的动画之后执行
         *         after(long delay)   将现有动画延迟指定毫秒后执行
         *         before(Animator anim)   将现有动画插入到传入的动画之前执行
         *         with(Animator anim)   将现有动画和传入的动画同时执行
         */

        //让TextView
        // 先从屏幕外移动进屏幕，
        // 然后开始旋转360度，
        // 旋转的同时进行淡入淡出操作

        ObjectAnimator moveIn = ObjectAnimator.ofFloat(tv, "translationX", -500, 0);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(tv, "rotation", 0f, 360f);
        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(tv, "alpha", 1f, 0f, 1f);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(rotate).with(fadeInOut).after(moveIn);
        animatorSet.setDuration(duration);
        animatorSet.start();

    }

    public void testValueAnimation() {

        ValueAnimator anim = ValueAnimator.ofFloat(0f, 1f);
        //延迟播放
        anim.setStartDelay(100);
        //循环播放
        anim.setRepeatMode(ValueAnimator.RESTART);
        //倒序播放
        anim.setRepeatMode(ValueAnimator.REVERSE);
        //循环次数
        anim.setRepeatCount(5);
        anim.setDuration(300);
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float currentValue = (float) animation.getAnimatedValue();
                Log.d(TAG, "cuurent value is " + currentValue);
            }
        });
        anim.start();

    }
}
