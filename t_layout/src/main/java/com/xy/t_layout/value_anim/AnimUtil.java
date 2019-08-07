package com.xy.t_layout.value_anim;

import android.view.View;

import com.xy.t_layout.randomlayout3.AnimatorUtil;

/**
 * @ProjectName: Test
 * @Package: com.xy.t_layout.value_anim
 * @ClassName: AnimUtil
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2019-08-07 17:55
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019-08-07 17:55
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class AnimUtil {

    public static void goSWCenter(View view, int endx, int endY, long delay) {

        AnimatorUtil animatorUtils = new AnimatorUtil(view, 3500);
        animatorUtils.getAnimate().setStartDelay(delay);
        animatorUtils.addAlphaAnimationBy(-1.0f)
                .addTranslationAnimationBy(945, 452)
                .addScaleAnimationBy(-0.8f)
                .startAnimator();
    }

//    private void goSWCenter2(View view) {
//
//        AnimatorUtil animatorUtils = new AnimatorUtil(view, 3500);
//        animatorUtils.getAnimate().setStartDelay(3000);
//        animatorUtils.addAlphaAnimationBy(-1.0f)
//                .addTranslationAnimationBy(-945, 452)
//                .addScaleAnimationBy(-0.8f)
//                .startAnimator();
//
//    }


}
