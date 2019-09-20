package com.xy.t_animation;

import android.animation.Animator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;

/**
 * @Author: yangxume@gmail.com
 * @Time: 2019-09-11 10:19
 * @Desc:
 *
 * Lottie 动画
 *  *   Lottie 是一个用于 Android 和 iOS 的代码库，
 *  *   可以解析用 Adobe After Effects 制作动画后通过 Bodymovin 插件 导出的JSON数据文件并在移动端原生渲染!
 *  *   https://github.com/bigxixi/lottie-android
 *  *   https://github.com/airbnb/lottie-android
 *
 */
public class LottieAnimActivity extends AppCompatActivity {

    private LottieAnimationView animationview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie_anim);

        animationview = findViewById(R.id.animationview);
        animationview.loop(true);
        animationview.setImageResource(R.drawable.icon_zan_default);
//        animationview.playAnimation();  //播放
//		animationview.pauseAnimation(); //暂停
//		animationview.cancelAnimation(); //取消
//		animationview.getDuration();  //获取动画时长
        animationview.addAnimatorListener(animatorListener);

        //begin test

        //keywords_fly
//        animationview.setAnimation("keywords_fly.json");
//        animationview.setImageAssetsFolder("images_fly/");

        //zan
        animationview.setAnimation("zan.json");
        animationview.setImageAssetsFolder("images_zan/");

        animationview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationview.playAnimation();
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        animationview.removeAnimatorListener(animatorListener);
    }


    private  Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { //添加动画监听
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
    };


}
