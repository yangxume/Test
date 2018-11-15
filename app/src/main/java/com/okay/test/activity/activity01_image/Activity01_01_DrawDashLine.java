package com.okay.test.activity.activity01_image;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.okay.test.R;
import com.okay.test.utils.DashLineUtils;

/**
 * Copyright
 * <p>
 * Created by xuyang on 17/11/14 16:05
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description 图片相关
 * <p>
 * Update records:
 */

public class Activity01_01_DrawDashLine extends AppCompatActivity
implements View.OnClickListener{

    private static final String TAG  = Activity01_01_DrawDashLine.class.getSimpleName();

    private Context ctx;

    private ImageView iv_one;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity01_01_drawdashline);
        ctx = Activity01_01_DrawDashLine.this;
        findView();
    }

    private void findView() {

        iv_one = (ImageView) findViewById(R.id.iv_one);

        DashLineUtils dashLineUtils = new DashLineUtils(ctx);

        iv_one.setImageBitmap(dashLineUtils.drawDashLine() );

    }

    @Override
    public void onClick(View v) {



    }
}
