package com.xy.recyclerview.recylist;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xy.recyclerview.R;
import com.xy.recyclerview.view.DividerGridItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * 基本使用：https://blog.csdn.net/lmj623565791/article/details/45059587
 *
 * 各种分割线：
 *       https://www.jianshu.com/p/e68a0b5fd383
 *       https://blog.csdn.net/crazyzhangxl/article/details/81043205
 */
public class RecyListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> mDatas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recy_list);
        initView();
        initData();
    }

    private void initView() {

        mRecyclerView = findViewById(R.id.recyclerview);

//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        mRecyclerView.setLayoutManager(linearLayoutManager);
//        mRecyclerView.addItemDecoration(new DividerListItemDecoration(this, DividerListItemDecoration.VERTICAL_LIST));


        //添加默认分割线
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        //设置Item增加、移除动画
//        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.addItemDecoration(new DividerGridItemDecoration(this));

    }

    protected void initData() {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            mDatas.add("" + (char) i);
        }

        RecyListAdapter mAdapter = new RecyListAdapter(this, mDatas);
        //设置adapter
        mRecyclerView.setAdapter(mAdapter);
    }

    class RecyListAdapter extends RecyclerView.Adapter<RecyListAdapter.MyViewHolder> {

        Context mCtx;
        List<String> mDatas;

        public RecyListAdapter(Context mCtx, List<String> mDatas) {
            this.mCtx = mCtx;
            this.mDatas = mDatas;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    RecyListActivity.this).inflate(R.layout.item_layout_recy_list, parent,
                    false));
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {

            myViewHolder.tv.setText(mDatas.get(position));

        }

        @Override
        public int getItemCount() {
            return mDatas == null ? 0 : mDatas.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            TextView tv;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                tv = itemView.findViewById(R.id.id_num);
            }
        }
    }

}
