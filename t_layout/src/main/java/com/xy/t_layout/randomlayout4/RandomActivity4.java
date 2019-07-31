package com.xy.t_layout.randomlayout4;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.xy.t_layout.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**

 *
 *
 *

 */
public class RandomActivity4 extends AppCompatActivity {

    String[] tag1 = new String[]{
            "博鳌亚洲论坛", "哈佛商业评论", "财经国家周刊", "每日经济新闻", "中国企业家", "路透中文网", "国际金融报",
            "中国证券网", "中国经营报", "经济观察报", "中国经济网",
            "印度去年四季度GDP增7.3% 领跑全", "大年初一全国电影总票房6.6亿元刷新纪", "都说爱钱如命 你知道人民币上的姑娘是谁",
            "中国最美女富豪身价过百亿 马云曾千里寻", "100万在世界各国能买什么房 最后一张", "一个捡破烂的！他三年竟然赚了270万"};
    String[] tag2 = new String[]{"FT中文网", "财经网", "创业家", "福布斯", "美通社", "21世纪经济报道", "华尔街见闻", "中国黄金交易网",
            "CCTV证券资讯网", "中国发展研究基金会", "证券日报", "中国民族证券", "新财富杂志", "环球企业家", "中国证券报",
            "证券时报网", "易三板", "中国金融网", "易三板", "未央网", "商学院", "欧美股市大跌 金价创八个月来新高",
            "证券市场周刊", "财新网", "华夏时报", "第一财经",
            "中国货币政策拐点或已到来", "春运最拥挤火车站公布 北京西站未进前十", "日本拟建1700米高“天空之城” 超越"};

    List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randomlayout4);

        list = new ArrayList<>();

        // 简单的设置要显示的文字源
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 11; j++) {
                list.add("第" + i + "组" + "文字" + j);
            }
        }

        StellarMap stellarMap = new StellarMap(this);
        // 1.设置内部的TextView距离四周的内边距
        int padding = 15;
        stellarMap.setInnerPadding(padding, padding, padding, padding);
        stellarMap.setAdapter(new StellarMapAdapter());
        // 设置默认显示第几组的数据
        stellarMap.setGroup(0, true);// 这里默认显示第0组
        // 设置x和y方向上的显示的密度
        stellarMap.setRegularity(15, 15);// 如果值设置的过大，有可能造成子View摆放比较稀疏

        stellarMap.startAnimation(AnimationUtil.createZoomOutNearAnim());

        // 把fragment显示至界面,new出fragment对象
        FrameLayout fl = (FrameLayout) findViewById(R.id.fl);
        fl.addView(stellarMap);

    }

    class StellarMapAdapter implements StellarMap.Adapter {
        /**
         * 返回多少组数据
         */
        @Override
        public int getGroupCount() {
            return 3;
        }

        /**
         * 每组多少个数据
         */
        @Override
        public int getCount(int group) {
            return 11;
        }

        /**
         * group: 当前是第几组 position:是当前组的position
         */
        @Override
        public View getView(int group, int position, View convertView) {
            final TextView textView = new TextView(RandomActivity4.this);
            // 根据group和组中的position计算出对应的在list中的位置
            int listPosition = group * getCount(group) + position;
            textView.setText(list.get(listPosition));

            // 1.设置随机的字体大小(随机大小)
            Random random = new Random();
            textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,
                    random.nextInt(15) + 14);// 14-29
            // 2.上色，设置随机的字体颜色
            // 如果三原色的值过大会偏白色，过小会偏黑色，所以应该随机一个中间的颜色的值
            int red = random.nextInt(150) + 50;// 50-199
            int green = random.nextInt(150) + 50;// 50-199
            int blue = random.nextInt(150) + 50;// 50-199
//			int textColor = Color.rgb(red, green, blue);// 在rgb三原色的基础上混合出一种新的颜色
            int textColor = Color.WHITE;
            textView.setTextColor(textColor);
            return textView;
        }

        /**
         * 虽然定义了，但是并没有什么乱用
         */
        @Override
        public int getNextGroupOnPan(int group, float degree) {
            return 0;
        }

        /**
         * 当前组缩放完成之后下一组加载哪一组的数据 group： 表示当前是第几组
         */
        @Override
        public int getNextGroupOnZoom(int group, boolean isZoomIn) {
            // 0->1->2->0
            return (group + 1) % getGroupCount();
        }

    }



}
