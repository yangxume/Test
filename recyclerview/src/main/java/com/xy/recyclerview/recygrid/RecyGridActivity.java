package com.xy.recyclerview.recygrid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xy.recyclerview.R;
import com.xy.recyclerview.recygrid.bean.RecyGridBean;
import com.xy.recyclerview.view.SpacesItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class RecyGridActivity extends AppCompatActivity {

    private List<RecyGridBean> list = new ArrayList<>();

    RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recy_grid);
        recyclerview = findViewById(R.id.recyclerview);

        initData();

        //设置布局的方式
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerview.setLayoutManager(layoutManager);

        recyclerview.addItemDecoration(new SpacesItemDecoration(12));
        //直接new一个匿名类，就不用单独创建Adapter类文件了。
        recyclerview.setAdapter(new BaseQuickAdapter<RecyGridBean, BaseViewHolder>(R.layout.item_layout_recy_grid, list) {
            @Override
            protected void convert(BaseViewHolder helper, RecyGridBean item) {
                //调用赋值
                helper.setText(R.id.tv_item, item.getTitle());
            }
        });
    }

    //模拟数据
    private void initData() {
        for (int i = 0; i < 10; i++) {
            RecyGridBean bank = new RecyGridBean();
            bank.setId(String.valueOf(i));
            bank.setTitle("title" + i);
            list.add(bank);
        }
    }
}