package com.xy.t_lottie_anim;

import android.animation.Animator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LottieAnimationView lottieAnimationview;
    private Button btn_zan1;
    private Button btn_zan2;
    private Button btn_zan3;
    private Button btn_shoucang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        lottieAnimationview = findViewById(R.id.lottie_animationview);

        btn_zan1 = findViewById(R.id.btn_zan1);
        btn_zan2 = findViewById(R.id.btn_zan2);
        btn_zan3 = findViewById(R.id.btn_zan3);
        btn_shoucang = findViewById(R.id.btn_shoucang);

        btn_zan1.setOnClickListener(this);
        btn_zan2.setOnClickListener(this);
        btn_zan3.setOnClickListener(this);
        btn_shoucang.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btn_zan1:

                zan1();

                break;

            case R.id.btn_zan2:

                zan2();

                break;

            case R.id.btn_zan3:

                zan3();

                break;

            case R.id.btn_shoucang:

                shoucang();

                break;
        }

    }

    private void shoucang() {

        lottieAnimationview.cancelAnimation();
        lottieAnimationview.setAnimation("shoucang.json");
        lottieAnimationview.setImageAssetsFolder("images_shoucang/");
        lottieAnimationview.playAnimation();
    }

    private void zan1(){
        lottieAnimationview.cancelAnimation();
//        lottieAnimationview.setRepeatMode(LottieDrawable.REVERSE);
        lottieAnimationview.setAnimation("zan1.json");
        lottieAnimationview.setImageAssetsFolder("images_zan1/");
        lottieAnimationview.playAnimation();

    }

    private void zan2(){

        lottieAnimationview.cancelAnimation();
//        lottieAnimationview.setRepeatMode(LottieDrawable.REVERSE);
        lottieAnimationview.setAnimation("zan2.json");
        lottieAnimationview.setImageAssetsFolder("images_zan2/");
        lottieAnimationview.playAnimation();

    }

    private void zan3(){

        lottieAnimationview.cancelAnimation();
//        lottieAnimationview.setRepeatMode(LottieDrawable.REVERSE);
        lottieAnimationview.setAnimation("zan3.json");
        lottieAnimationview.setImageAssetsFolder("images_zan3/");
        lottieAnimationview.playAnimation();

    }

    private void test() {

        lottieAnimationview.cancelAnimation();
//        lottieAnimationview.setRepeatMode(LottieDrawable.RESTART);
//        lottieAnimationview.setRepeatCount(10);
//        lottieAnimationview.setAnimation("data.json");

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
