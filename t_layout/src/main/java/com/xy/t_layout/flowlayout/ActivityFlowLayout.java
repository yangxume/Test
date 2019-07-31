package com.xy.t_layout.flowlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.xy.t_layout.R;

public class ActivityFlowLayout extends AppCompatActivity {


    private String[] mVals = new String[]
            {
                    "新增+",
                    "小学四年级",
                    "小学五年级",
                    "小学六年级",
                    "小学四年级",
                    "小学五年级",
                    "小学六年级",
                    "小学四年级",
                    "小学五年级",
                    "小学六年级",
                    "小学四年级",
                    "小学五年级",
                    "小学六年级",
                    "小学四年级",
                    "小学五年级",
                    "小学六年级",
                    "小学四年级",
                    "小学五年级",
                    "小学六年级",
                    "小学四年级",
                    "小学五年级",
                    "小学六年级",
                    "小学四年级",
                    "小学五年级",
                    "小学六年级",
                    "小学四年级",
                    "小学五年级",
                    "小学六年级"
            };

    private TagFlowLayout mFlowLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowlayout);

        mFlowLayout = (TagFlowLayout) findViewById(R.id.flowlayout);
        mFlowLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ActivityFlowLayout.this,
                        "FlowLayout Clicked",
                        Toast.LENGTH_SHORT).show();
            }
        });

        final LayoutInflater mInflater = LayoutInflater.from(ActivityFlowLayout.this);

        mFlowLayout.setAdapter(new TagAdapter<String>(mVals) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = (TextView) mInflater.inflate(R.layout.layout_item_tv,
                        mFlowLayout, false);
                tv.setText(s);
                return tv;
            }

        });
    }
}