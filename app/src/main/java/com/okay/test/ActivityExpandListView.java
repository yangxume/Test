package com.okay.test;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.okay.test.adapter.ExPandableListViewAdapter;
import com.okay.test.bean.ChildrenData;
import com.okay.test.bean.FatherData;

import java.util.ArrayList;


public class ActivityExpandListView extends AppCompatActivity {

    private Context mCtx;

    private ExpandableListView expandablelistview;

    private ExPandableListViewAdapter adapter;
    private ArrayList<FatherData> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand_listview);

        expandablelistview = (ExpandableListView) findViewById(R.id.expandablelistview);

        mCtx = ActivityExpandListView.this;
        initView();
        setData();
        setAdapter();

    }

    // 初始化控件
    private void initView() {
        // 设置ExpandableListView的监听事件
        // 设置一级item点击的监听器
//        expandablelistview.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
//            @Override
//            public boolean onGroupClick(ExpandableListView arg0, View arg1, int arg2, long arg3) {
//                // TODO Auto-generated method stub
//                Toast.makeText(mCtx, datas.get(arg2).getTitle(), Toast.LENGTH_LONG).show();
//                return false;
//            }
//        });
//
//        // 设置二级item点击的监听器，同时在Adapter中设置isChildSelectable返回值true，同时二级列表布局中控件不能设置点击效果
//        expandablelistview.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//            @Override
//            public boolean onChildClick(ExpandableListView arg0, View arg1, int arg2, int arg3, long arg4) {
//                // TODO Auto-generated method stub
//                Toast.makeText(mCtx, datas.get(arg2).getList().get(arg3).getTitle(), Toast.LENGTH_LONG).show();
//                return false;
//            }
//        });
    }

    /**
     * 自定义setAdapter
     */
    private void setAdapter() {
        if (adapter == null) {
            adapter = new ExPandableListViewAdapter(this, datas);
            expandablelistview.setAdapter(adapter);
        } else {
            adapter.flashData(datas);
        }
    }

    // 定义数据
    private void setData() {
        if (datas == null) {
            datas = new ArrayList<>();
        }
        // 一级列表中的数据
        for (int i = 0; i < 5; i++) {
            FatherData fatherData = new FatherData();
            fatherData.setTitle("闹钟列表" + i);
            // 二级列表中的数据
            ArrayList<ChildrenData> itemList = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                ChildrenData childrenData = new ChildrenData();
                childrenData.setTitle("闹钟主题" + j);
                childrenData.setDesc(j + ":30");
                itemList.add(childrenData);
            }
            fatherData.setList(itemList);
            datas.add(fatherData);
        }
    }
}
