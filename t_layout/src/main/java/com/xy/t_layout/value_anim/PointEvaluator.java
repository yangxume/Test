package com.xy.t_layout.value_anim;

import android.animation.TypeEvaluator;

/**
 * @ProjectName: Test
 * @Package: com.xy.t_layout.value_anim
 * @ClassName: PointEvaluator
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2019-08-07 14:34
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019-08-07 14:34
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */

public class PointEvaluator implements TypeEvaluator {

    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        Point startPoint = (Point) startValue;
        Point endPoint = (Point) endValue;
        float x = startPoint.getX() + fraction * (endPoint.getX() - startPoint.getX());
        float y = startPoint.getY() + fraction * (endPoint.getY() - startPoint.getY());
        Point point = new Point(x, y);
        return point;
    }

}
