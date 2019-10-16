package com.xy.recyclerview.recymultiadapter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.xy.recyclerview.R;

/**
 * @Author: yangxume@gmail.com
 * @Time: 2019-10-16 19:13
 * @Desc: https://www.jianshu.com/p/f86f59dccaef
 */
public class MultiAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_view_type);

    }

    public static final int ONE_ITEM = 1;
    public static final int TWO_ITEM = 2;

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
        @Override
        public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return null;
        }

        @Override
        public void onBindViewHolder(MyAdapter.MyViewHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 0;
        }

        @Override
        public int getItemViewType(int position) {
            return super.getItemViewType(position);
        }

        //继承RecyclerView.ViewHolder
        class MyViewHolder extends  RecyclerView.ViewHolder{

            public MyViewHolder(View itemView) {
                super(itemView);
            }
        }
    }


}
