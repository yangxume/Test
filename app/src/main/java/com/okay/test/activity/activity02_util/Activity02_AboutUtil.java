package com.okay.test.activity.activity02_util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.okay.test.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Copyright
 * <p>
 * Created by xuyang on 17/7/18 11:16
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */

public class Activity02_AboutUtil extends Activity {

    @BindView(R.id.btn01_livetemplates)
    Button btn01Livetemplates;
    @BindView(R.id.btn01_string_span)
    Button btn01StringSpan;
    @BindView(R.id.btn01_image_span)
    Button btn01ImageSpan;

    private Context ctx;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity02_aboututil);
        ButterKnife.bind(this);
        ctx = Activity02_AboutUtil.this;
    }


    @OnClick({R.id.btn01_livetemplates, R.id.btn01_string_span, R.id.btn01_image_span})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn01_livetemplates:
                startActivity(new Intent(ctx, Activity02_01_LiveTemplates.class));

                break;
            case R.id.btn01_string_span:
                startActivity(new Intent(ctx, Activity02_02_StringSpannable.class));

                break;
            case R.id.btn01_image_span:
                startActivity(new Intent(ctx, Activity02_03_ImageSpan.class));

                break;
        }
    }
}
