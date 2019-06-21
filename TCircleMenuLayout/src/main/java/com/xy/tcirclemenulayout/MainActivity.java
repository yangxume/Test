package com.xy.tcirclemenulayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CircleMenuLayout circleMenuLayout;

    private CircleMenuLayout mCircleMenuLayout;

    private String[] mItemTexts = new String[] {
            "安全中心 ",
            "特色服务",
            "投资理财",
            "转账汇款",
            "我的账户",
            "信用卡" };
    private int[] mItemImgs = new int[] {

            R.mipmap.home_mbank_1_normal,
            R.mipmap.home_mbank_2_normal,
            R.mipmap.home_mbank_3_normal,
            R.mipmap.home_mbank_4_normal,
            R.mipmap.home_mbank_5_normal,
            R.mipmap.home_mbank_6_normal
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCircleMenuLayout = findViewById(R.id.circleMenuLayout);
        mCircleMenuLayout.setMenuItemIconsAndTexts(mItemImgs, mItemTexts);

        mCircleMenuLayout.setOnMenuItemClickListener(new CircleMenuLayout.OnMenuItemClickListener(){
            @Override
            public void onItemClick(View view, int pos)
            {
                Toast.makeText(MainActivity.this, mItemTexts[pos],
                        Toast.LENGTH_SHORT).show();

            }
            @Override
            public void onItemCenterClick(View view)
            {
                Toast.makeText(MainActivity.this,
                        "you can do something just like ccb  ",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
