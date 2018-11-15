package com.okay.test.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.okay.test.R;
import com.okay.test.activity.activity01_image.Activity01_AboutImage;
import com.okay.test.activity.activity02_util.Activity02_AboutUtil;
import com.okay.test.activity.activity03_view.Activity03_AboutView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Copyright
 * <p>
 * Created by xuyang on 17/11/6 15:35
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn1_about_image)
    Button btn1AboutImage;
    @BindView(R.id.btn2_about_util)
    Button btn2AboutUtil;
    @BindView(R.id.btn3_about_view)
    Button btn3AboutView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick({R.id.btn1_about_image,
            R.id.btn2_about_util,
            R.id.btn3_about_view

    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn1_about_image:
                startActivity(new Intent(MainActivity.this,Activity01_AboutImage.class));
                break;
            case R.id.btn2_about_util:
                startActivity(new Intent(MainActivity.this,Activity02_AboutUtil.class));
                break;
            case R.id.btn3_about_view:
                startActivity(new Intent(MainActivity.this,Activity03_AboutView.class));
                break;
        }
    }
}
