package com.xy.t_layout.value_anim;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.xy.t_layout.R;
import com.xy.t_layout.randomlayout3.AnimatorUtil;

/**
 * @ProjectName: Test
 * @Package: com.xy.t_layout.value_anim
 * @ClassName: ValueAnimationActivity
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2019-08-06 14:23
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019-08-06 14:23
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class ValueAnimationActivity extends AppCompatActivity
        implements View.OnClickListener {

    private static final String TAG = ValueAnimationActivity.class.getSimpleName();

    private TextView tv1,tv2,tv3,tv4,tv5,tv6;
    private MyAnimView myanimview;

    private Button btn_alpha;
    private Button btn_rotation;
    private Button btn_scale;
    private Button btn_translation;
    private Button btn_anim_set;

    private LottieAnimationView lottie_anim_view;

    private int delay = 1000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation2);

        initView();
//
//        testLottieAnim();
//
        goSWCenter(tv1,tv2,-962,-615,0);
        goSWCenter(tv2,tv3,949,582,2*delay);
        goSWCenter(tv3,tv4,956,-601,3*delay);
        goSWCenter(tv4,tv5,-956,613,4*delay);
        goSWCenter(tv5,tv6,-326,571,5*delay);
        goSWCenter(tv6,tv6,-369,-634,6*delay);

    }

    private void initView() {

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);
        tv6 = findViewById(R.id.tv6);

//        WidgetController.setLayoutX(tv1,1364);
//        WidgetController.setLayoutY(tv1,1324);

//        myanimview = findViewById(R.id.myanimview);

//        btn_alpha = findViewById(R.id.btn_alpha);
//        btn_rotation = findViewById(R.id.btn_rotation);
//        btn_scale = findViewById(R.id.btn_scale);
//        btn_translation = findViewById(R.id.btn_translation);
//        btn_anim_set = findViewById(R.id.btn_anim_set);
//
//        btn_alpha.setOnClickListener(this);
//        btn_rotation.setOnClickListener(this);
//        btn_scale.setOnClickListener(this);
//        btn_translation.setOnClickListener(this);
//        btn_anim_set.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();

        switch (id) {

            case R.id.btn_alpha:

                animAlpha(tv1);

                break;
            case R.id.btn_rotation:

                animRotation(tv1);

                break;
            case R.id.btn_scale:

                animScaleY(tv1);

                break;

            case R.id.btn_translation:

                goSWCenter(tv1,tv2,945,452,2*delay);
                goSWCenter(tv2,tv3,-945,452,4*delay);
                goSWCenter(tv3,tv4,945,0,6*delay);
                goSWCenter(tv4,tv5,-945,0,8*delay);
                goSWCenter(tv5,tv6,945,-452,10*delay);
                goSWCenter(tv6,tv6,-945,942,12*delay);

                break;

            case R.id.btn_anim_set:

                animSet(tv1);

                break;

        }
    }


    private void animAlpha(View view) {

        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "alpha", 1f, 0f, 1f);
        animator.setDuration(5000);
        animator.start();
    }

    private void animRotation(View view) {

        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "rotation", 0f, 360f);
        animator.setDuration(5000);
        animator.start();

    }

    private void animScaleY(View view) {

        ObjectAnimator animator = ObjectAnimator.ofFloat(view, "scaleY", 1f, 3f, 1f);
        animator.setDuration(5000);
        animator.start();

    }

    private void animTranslation(View view) {

//        ObjectAnimator moveIn = ObjectAnimator.ofFloat(textview,
//                "translationX", 0f, 500f);
//        moveIn.setDuration(5000);
//        moveIn.start();


        ObjectAnimator anim = ObjectAnimator.ofObject(tv1, "color", new ColorEvaluator(),
                "#0000FF", "#FF0000");
        anim.setDuration(5000);
        anim.start();

        anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {

            }
        });

    }

    private void animSet(View textview) {

        ObjectAnimator moveIn = ObjectAnimator.ofFloat(textview, "translationX", -500f, 0f);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(textview, "rotation", 0f, 360f);
        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(textview, "alpha", 1f, 0f, 1f);
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(rotate)
                .with(fadeInOut)
                .after(moveIn);
        animSet.setDuration(5000);
        animSet.start();

    }

    public static void goSWCenter(View view, final View nextView, int endx, int endY, long delay) {


        AnimatorUtil animatorUtils = new AnimatorUtil(view, 1000);
        animatorUtils.getAnimate().setStartDelay(delay);
        animatorUtils.addAlphaAnimationBy(-1.0f)
                .addTranslationAnimationBy(endx, endY)
                .addScaleAnimationBy(-0.8f)
                .startAnimator();

        animatorUtils.getAnimate().setListener(new com.nineoldandroids.animation.Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(com.nineoldandroids.animation.Animator animator) {

            }

            @Override
            public void onAnimationEnd(com.nineoldandroids.animation.Animator animator) {
                nextView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationCancel(com.nineoldandroids.animation.Animator animator) {

            }

            @Override
            public void onAnimationRepeat(com.nineoldandroids.animation.Animator animator) {

            }
        });
    }

    private void goCenter1(){

//        Animator animator = AnimatorInflater.loadAnimator(this, R.);
//        animator.setTarget(textview);
//        animator.start();

    }

    private void testLottieAnim() {

        lottie_anim_view = findViewById(R.id.lottie_anim_view);

        lottie_anim_view.playAnimation();  //播放
//		lottilottie_anim_vieweLike.pauseAnimation(); //暂停
//		lottie_anim_view.cancelAnimation(); //取消
//		lottie_anim_view.getDuration();  //获取动画时长
        lottie_anim_view.addAnimatorListener(new Animator.AnimatorListener() { //添加动画监听
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

    }

}
