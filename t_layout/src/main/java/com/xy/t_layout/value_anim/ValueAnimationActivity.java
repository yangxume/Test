package com.xy.t_layout.value_anim;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.xy.t_layout.R;

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

    private TextView textview;

    private Button btn_alpha;
    private Button btn_rotation;
    private Button btn_scale;
    private Button btn_translation;
    private Button btn_anim_set;
    private MyAnimView myAnimView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        initView();
    }

    private void initView() {

        textview = findViewById(R.id.textview);

        btn_alpha = findViewById(R.id.btn_alpha);
        btn_rotation = findViewById(R.id.btn_rotation);
        btn_scale = findViewById(R.id.btn_scale);
        btn_translation = findViewById(R.id.btn_translation);
        btn_anim_set = findViewById(R.id.btn_anim_set);
        myAnimView = findViewById(R.id.myanimview);

        btn_alpha.setOnClickListener(this);
        btn_rotation.setOnClickListener(this);
        btn_scale.setOnClickListener(this);
        btn_translation.setOnClickListener(this);
        btn_anim_set.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();

        switch (id) {

            case R.id.btn_alpha:

                animAlpha(textview);

                break;
            case R.id.btn_rotation:

                animRotation(textview);

                break;
            case R.id.btn_scale:

                animScaleY(textview);

                break;

            case R.id.btn_translation:

                animTranslation(textview);

                break;

            case R.id.btn_anim_set:

                animSet(textview);

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


        ObjectAnimator anim = ObjectAnimator.ofObject(myAnimView, "color", new ColorEvaluator(),
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

//

}
