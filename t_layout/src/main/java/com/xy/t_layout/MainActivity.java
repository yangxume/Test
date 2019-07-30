package com.xy.t_layout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.xy.t_layout.activity.Activity_01_CoordinatorLayout;
import com.xy.t_layout.flowlayout.Activity_02_FlowLayout;
import com.xy.t_layout.activity.Activity_03_MultiFlowLayout;
import com.xy.t_layout.activity.Activity_04_FlexboxLayout;
import com.xy.t_layout.randomlayout1.Random1Activity;
import com.xy.t_layout.randomlayout2.Random2Activity;
import com.xy.t_layout.randomlayout3.Random3Activity;

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
    @BindView(R.id.btn_randomlayout1)
    Button btnRandomlayout1;
    @BindView(R.id.btn_randomlayout2)
    Button btnRandomlayout2;
    @BindView(R.id.btn_randomlayout3)
    Button btnRandomlayout3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_coordinatorlayout,
            R.id.btn_flowlayout,
            R.id.btn_multi_flowlayout,
            R.id.btn_flexboxlayout,
            R.id.btn_randomlayout1,
            R.id.btn_randomlayout2,
            R.id.btn_randomlayout3,
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
            case R.id.btn_randomlayout1:
                startActivity(new Intent(MainActivity.this, Random1Activity.class));
                break;
            case R.id.btn_randomlayout2:
                startActivity(new Intent(MainActivity.this, Random2Activity.class));
                break;
            case R.id.btn_randomlayout3:
                startActivity(new Intent(MainActivity.this, Random3Activity.class));
                break;
        }
    }
}
