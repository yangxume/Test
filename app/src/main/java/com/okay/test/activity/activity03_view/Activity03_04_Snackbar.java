package com.okay.test.activity.activity03_view;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.okay.test.R;

import butterknife.ButterKnife;

public class Activity03_04_Snackbar extends AppCompatActivity {

    Button btn_test;

    RelativeLayout rl_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity03_04_snackbar);
        ButterKnife.bind(this);

        btn_test = (Button) findViewById(R.id.btn_test);
        rl_main = (RelativeLayout) findViewById(R.id.rl_main);

        btn_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(rl_main,"snackabr_test",2000).show();


            }
        });


    }

}
