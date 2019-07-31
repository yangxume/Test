package com.xy.t_layout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.xy.t_layout.activity.ActivityCoordinatorLayout;
import com.xy.t_layout.activity.ActivityMultiFlowLayout;
import com.xy.t_layout.activity.ActivityFlexboxLayout;
import com.xy.t_layout.flowlayout.ActivityFlowLayout;
import com.xy.t_layout.randomlayout1.RandomActivity1;
import com.xy.t_layout.randomlayout2.RandomActivity2;
import com.xy.t_layout.randomlayout3.RandomActivity3;
import com.xy.t_layout.randomlayout4.RandomActivity4;

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
    @BindView(R.id.btn_randomlayout4)
    Button btnRandomlayout4;

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
            R.id.btn_randomlayout4
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_coordinatorlayout:
                startActivity(new Intent(MainActivity.this, ActivityCoordinatorLayout.class));
                break;
            case R.id.btn_flowlayout:
                startActivity(new Intent(MainActivity.this, ActivityFlowLayout.class));
                break;
            case R.id.btn_multi_flowlayout:
                startActivity(new Intent(MainActivity.this, ActivityMultiFlowLayout.class));
                break;
            case R.id.btn_flexboxlayout:
                startActivity(new Intent(MainActivity.this, ActivityFlexboxLayout.class));
                break;
            case R.id.btn_randomlayout1:
                startActivity(new Intent(MainActivity.this, RandomActivity1.class));
                break;
            case R.id.btn_randomlayout2:
                startActivity(new Intent(MainActivity.this, RandomActivity2.class));
                break;
            case R.id.btn_randomlayout3:
                startActivity(new Intent(MainActivity.this, RandomActivity3.class));
                break;
            case R.id.btn_randomlayout4:
                startActivity(new Intent(MainActivity.this, RandomActivity4.class));
                break;
        }
    }
}
