package com.xy.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.btn_recy_list)
    Button btnRecyList;
    @BindView(R.id.btn_recy_grid)
    Button btnRecyGrid;
    @BindView(R.id.btn_raise_hand)
    Button btnRaiseHand;
    @BindView(R.id.btn_twinkling_refresh)
    Button btnTwinklingRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @OnClick({R.id.btn_recy_list, R.id.btn_recy_grid, R.id.btn_raise_hand, R.id.btn_twinkling_refresh})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_recy_list:
                startActivity(new Intent(this, RecyListActivity.class));

                break;
            case R.id.btn_recy_grid:
                startActivity(new Intent(this, RecyGridActivity.class));

                break;
            case R.id.btn_raise_hand:
                startActivity(new Intent(this, RaiseHandActivity.class));

                break;
            case R.id.btn_twinkling_refresh:
                startActivity(new Intent(this, TwinklingRefreshLayoutActivity.class));

                break;
        }
    }
}
