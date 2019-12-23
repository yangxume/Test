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


/**
 * android:scrollbars=”vertical”是否显示滚动条，它的取值可以是vertical，horizontal或none。
 * android:fadeScrollbars=”true”（默认参数）是在滑块不滚动时，隐藏
 * android:fadeScrollbars=”false”是在滑块不滚动时，不隐藏
 * android:scrollbarThumbVertical=”@drawable/ic_launcher”自定义滑块的背景图
 * android:scrollbarStyle=”insideOverlay”
 * insideOverlay：默认值，表示在padding区域内并且覆盖在view上
 * insideInset：表示在padding区域内并且插入在view后面
 * outsideOverlay：表示在padding区域外并且覆盖在view上
 * outsideInset：表示在padding区域外并且插入在view后面
 * ————————————————
 * 原文链接：https://blog.csdn.net/zxg_1991/article/details/77567392
 */
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
        GridLayoutManager layoutManager = new GridLayoutManager(this, 5);
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
        for (int i = 0; i < 50; i++) {
            RecyGridBean bank = new RecyGridBean();
            bank.setId(String.valueOf(i));
            bank.setTitle("title" + i);
            list.add(bank);
        }
    }
}