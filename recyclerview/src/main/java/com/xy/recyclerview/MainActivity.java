package com.xy.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.xy.recyclerview.adapter.MainAdapter;
import com.xy.recyclerview.bean.StudentBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainAdapter.OnItemClickListener {

    private EditText et_stu_id;
    private Button btn_raise_hand;
    private RecyclerView mRecyclerView;

    private MainAdapter mAdapter;

    private List<StudentBean> mDatas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        initOnClickListener();
    }

    private void initOnClickListener() {

        mAdapter.setOnItemClickListener(this);

        btn_raise_hand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String str = et_stu_id.getText().toString().trim();

                if (!TextUtils.isEmpty(str)){

                    int stu_position = Integer.parseInt(str);
                    mAdapter.notifyItemChanged(stu_position,"raise_hand");

                }
            }
        });

    }

    private void initView() {

        et_stu_id = (EditText) findViewById(R.id.et_stu_id);
        btn_raise_hand = (Button) findViewById(R.id.btn_raise_hand);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        /**
         * 既然是动画，就会有时间，我们把动画执行时间变大一点来看一看效果
         */
        DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
        defaultItemAnimator.setAddDuration(1000);
        defaultItemAnimator.setRemoveDuration(1000);
        mRecyclerView.setItemAnimator(defaultItemAnimator);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * 这里通过两个菜单按钮来观看我们的动画效果
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                mAdapter.addData(1);
                break;
            case R.id.action_remove:
                mAdapter.removeData(1);
                break;
        }
        return true;
    }


    private void initData() {

        mDatas = new ArrayList<>();

        for (int i = 'A'; i < 'Z'; i++) {
            StudentBean studentBean = new StudentBean("学生"+Integer.toString(i), 0);
            mDatas.add(studentBean);
        }

        mAdapter = new MainAdapter(this, mDatas);
        mRecyclerView.setAdapter(mAdapter);
    }


    @Override
    public void onItemClick(View view) {
        int position = mRecyclerView.getChildAdapterPosition(view);

        if (DataManager.getDataManager().getSpeakState() == 0){

            DataManager.getDataManager().setSpeakState(1);

            StudentBean studentBean = mAdapter.getDataList().get(position);
            studentBean.state = 1;

            mAdapter.getDataList().set(position,studentBean);

            mAdapter.notifyItemChanged(position,"audio");


        }else{
            Toast.makeText(MainActivity.this,"连接中,请稍候", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onItemLongClick(View view) {

    }
}
