package com.xy.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = (RecyclerView) findViewById(R.id.rv);

        // 初始化列表数据
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 300; i++) {
            data.add(""+i);
        }

        // 竖向列表布局
        rv.setLayoutManager(new LinearLayoutManager(this));
        // 创建Adapter
        BaseRecyclerViewAdapter  adapter = new BaseRecyclerViewAdapter(this,data);
        // 设置展示动画
        adapter.setAnimation(new SlideInRightAnimation());
        // 设置Adapter
        rv.setAdapter(adapter);
    }


}
