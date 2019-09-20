package com.xy.t_lottie_anim;

import android.animation.Animator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LottieAnimationView lottieAnimationview;
    private Button btn_test1;
    private Button btn_test2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {
        lottieAnimationview = findViewById(R.id.lottie_animationview);
        btn_test1 = findViewById(R.id.btn_test1);
        btn_test2 = findViewById(R.id.btn_test2);

        btn_test1.setOnClickListener(this);
        btn_test2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btn_test1:
                zan1();
                break;

            case R.id.btn_test2:
                zan2();
                break;

        }

    }

    private void zan1(){
        lottieAnimationview.cancelAnimation();
        lottieAnimationview.setAnimation("zan1.json");
        lottieAnimationview.setImageAssetsFolder("images_zan1/");
        lottieAnimationview.playAnimation();

    }

    private void zan2(){

        lottieAnimationview.cancelAnimation();
        lottieAnimationview.setAnimation("zan2.json");
        lottieAnimationview.setImageAssetsFolder("images_zan2/");
        lottieAnimationview.playAnimation();

    }

    private void testLottieAnim() {

        lottieAnimationview.playAnimation();  //播放
//		lottieAnimationview.pauseAnimation(); //暂停
//		lottieAnimationview.cancelAnimation(); //取消
//		lottieAnimationview.getDuration();  //获取动画时长
        lottieAnimationview.addAnimatorListener(new Animator.AnimatorListener() { //添加动画监听
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
