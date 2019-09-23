package com.xy.t_expandablelistview;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> group=new ArrayList<String>();
    private List<List<String>> child=new ArrayList<List<String>>();
    private ExpandableAdapter adapter;
    private ExpandableListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initView() {
        listView=(ExpandableListView) findViewById(R.id.expandablelistview);
        adapter=new ExpandableAdapter();
        listView.setAdapter(adapter);
        listView.setCacheColorHint(0); //防止拖动时出现黑色背景
        listView.setGroupIndicator(null);//设置自带的箭头消失
        listView.setDivider(null);//设置没有分割线

        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(MainActivity.this, "点击了"+adapter.getChild(groupPosition, childPosition), 1000).show();
                return false;
            }
        });
    }

    private void initData() {
        //添加父布局数据
        group.add("测试数据1");
        group.add("测试数据2");
        group.add("测试数据3");
        group.add("测试数据4");
        group.add("测试数据5");
        //添加子布局数据
        for(int j=0;j<5;j++){
            List<String> childitem=new ArrayList<String>();
            for(int i=0;i<5;i++){
                childitem.add("子数据"+i);
            }
            child.add(childitem);
        }
    }
    class ExpandableAdapter extends BaseExpandableListAdapter {

        @Override
        public int getGroupCount() {
            return group.size();//获取父布局个数
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return child.get(groupPosition).size();//获取子布局个数
        }

        @Override
        public Object getGroup(int groupPosition) {
            return group.get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return child.get(groupPosition).get(childPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }
        //父布局样式
        @Override
        public View getGroupView(int groupPosition, boolean isExpanded,
                                 View convertView, ViewGroup parent) {
            if(convertView==null){
                LayoutInflater inflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView=inflater.inflate(R.layout.layout_item_group, null);
            }
            TextView tvparent=(TextView) convertView.findViewById(R.id.tvparent);
            tvparent.setText(getGroup(groupPosition).toString());
            ImageView ivView=(ImageView) convertView.findViewById(R.id.ivfx);
            if(isExpanded){
                ivView.setBackgroundResource(R.mipmap.icon_arrow_down);
            }else{
                ivView.setBackgroundResource(R.mipmap.icon_arrow_right);
            }
            return convertView;
        }
        //子布局样式
        @Override
        public View getChildView(int groupPosition, int childPosition,
                                 boolean isLastChild, View convertView, ViewGroup parent) {
            if(convertView==null){
                LayoutInflater inflater=(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView=inflater.inflate(R.layout.layout_item_children, null);
            }
            TextView tvchild=(TextView) convertView.findViewById(R.id.tvchild);
            tvchild.setText(getChild(groupPosition, childPosition).toString());
            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

    }

//    原文链接：https://blog.csdn.net/u012077817/article/details/50351629

}
