package com.okay.test.activity.activity03_view;

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
 * Created by xuyang on 17/11/13 11:39
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */

public class Activity03_AboutView extends Activity {

    private static final String TAG = Activity03_AboutView.class.getSimpleName();
    @BindView(R.id.btn01_livetemplates)
    Button btn01Livetemplates;
    @BindView(R.id.btn01_string_span)
    Button btn01StringSpan;
    @BindView(R.id.btn01_image_span)
    Button btn01ImageSpan;
    @BindView(R.id.btn01_snackbar)
    Button btn01Snackbar;

    private Context ctx;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = Activity03_AboutView.this;
        setContentView(R.layout.activity03_aboutview);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.btn01_livetemplates,
            R.id.btn01_string_span,
            R.id.btn01_image_span,
            R.id.btn01_snackbar
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn01_livetemplates:
                startActivity(
                        new Intent(ctx, Activity03_01_PopupWindow.class)
                );
                break;
            case R.id.btn01_string_span:
                startActivity(
                        new Intent(ctx, Activity03_02_NiceSpinner.class)
                );
                break;
            case R.id.btn01_image_span:
                startActivity(
                        new Intent(ctx, Activity03_03_StatusBar.class)
                );
                break;
            case R.id.btn01_snackbar:
                startActivity(
                        new Intent(ctx, Activity03_04_Snackbar.class)
                );
                break;
        }
    }

    @OnClick(R.id.btn01_snackbar)
    public void onViewClicked() {
    }
}
