package com.okay.test.activity.activity01_image;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.okay.test.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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

public class Activity01_AboutImage extends AppCompatActivity {

    private static final String TAG = Activity01_AboutImage.class.getSimpleName();
    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.btn2)
    Button btn2;
    @BindView(R.id.btn3)
    Button btn3;
    @BindView(R.id.btn4)
    Button btn4;

    private Context ctx;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity01_aboutimage);
        ButterKnife.bind(this);
        ctx = Activity01_AboutImage.this;
    }

    @OnClick({R.id.btn1,
            R.id.btn2,
            R.id.btn3,
            R.id.btn4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                startActivity(new Intent(ctx, Activity01_01_DrawDashLine.class));
                break;
            case R.id.btn2:
                startActivity(new Intent(ctx, Activity01_02_ShapeCorner.class));
                break;
            case R.id.btn3:
                startActivity(new Intent(ctx, Activity01_03_SpliceBitmap.class));
                break;
            case R.id.btn4:
                startActivity(new Intent(ctx,Activity01_05_LruCache.class));
                break;

        }
    }

}
