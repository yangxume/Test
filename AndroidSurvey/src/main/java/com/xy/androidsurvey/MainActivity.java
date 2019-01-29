package com.xy.androidsurvey;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


//https://github.com/firefly1984982452/android-knowledge

//https://blog.csdn.net/qq_32519693/article/details/76863070

//https://blog.csdn.net/jing110fei/article/details/46618229

public class MainActivity extends AppCompatActivity
implements View.OnClickListener {

    private Button btn1;
    private Button btn2;
    private Button btn3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.btn1:

                Intent intent = new Intent(MainActivity.this, Survey1Activity.class);
                startActivity(intent);
                finish();

                break;

            case R.id.btn2:

                Intent intent2 = new Intent(MainActivity.this, Survey2Activity.class);
                startActivity(intent2);
                finish();

                break;

        }


    }
}
