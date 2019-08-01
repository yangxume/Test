package com.xy.t_lottie_anim;

import android.animation.Animator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {

    private LottieAnimationView lottieanimationview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);

        lottieanimationview = findViewById(R.id.lottieanimationview);

        testLottieAnim();
    }

    private void testLottieAnim() {

        lottieanimationview.playAnimation();  //播放
//		lottieanimationview.pauseAnimation(); //暂停
//		lottieanimationview.cancelAnimation(); //取消
//		lottieanimationview.getDuration();  //获取动画时长
        lottieanimationview.addAnimatorListener(new Animator.AnimatorListener() { //添加动画监听
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
