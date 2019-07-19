package com.xy.t_layout.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.xy.t_layout.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_coordinatorlayout)
    Button btnCoordinatorlayout;
    @BindView(R.id.btn_flowlayout)
    Button btnFlowlayout;
    @BindView(R.id.btn_flexboxlayout)
    Button btnFlexboxlayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_coordinatorlayout,
            R.id.btn_flowlayout,
            R.id.btn_multi_flowlayout,
            R.id.btn_flexboxlayout
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_coordinatorlayout:
                startActivity(new Intent(MainActivity.this, Activity_01_CoordinatorLayout.class));
                break;
            case R.id.btn_flowlayout:
                startActivity(new Intent(MainActivity.this, Activity_02_FlowLayout.class));
                break;
            case R.id.btn_multi_flowlayout:
                startActivity(new Intent(MainActivity.this, Activity_03_MultiFlowLayout.class));
                break;
            case R.id.btn_flexboxlayout:
                startActivity(new Intent(MainActivity.this, Activity_04_FlexboxLayout.class));
                break;
        }
    }
}
