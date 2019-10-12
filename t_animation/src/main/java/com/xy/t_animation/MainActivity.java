package com.xy.t_animation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * 1 Property Animation
 *
 *
 * 2 Lottie 动画
 *   Lottie 是一个用于 Android 和 iOS 的代码库，
 *   可以解析用 Adobe After Effects 制作动画后通过 Bodymovin 插件 导出的JSON数据文件并在移动端原生渲染!
 *   https://github.com/bigxixi/lottie-android
 *   https://github.com/airbnb/lottie-android
 *
 *
 *
 */

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.btn_android_anim)
    Button btnAndroidAnim;
    @BindView(R.id.btn_lottie_anim)
    Button btnLottieAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_android_anim, R.id.btn_lottie_anim})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_android_anim:
                startActivity(new Intent(this, AndroidAnimActivity.class));
                break;
            case R.id.btn_lottie_anim:
                startActivity(new Intent(this, LottieAnimActivity.class));
                break;
        }
    }
}
