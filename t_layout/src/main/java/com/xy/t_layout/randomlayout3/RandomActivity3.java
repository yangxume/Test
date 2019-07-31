package com.xy.t_layout.randomlayout3;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;

import com.xy.t_layout.R;
import com.xy.t_layout.util.ToastUtil;

/**
 * https://github.com/Windsander/AnimatedRandomLayout
 *
 * 可操控参数：
 *   随机生成的周期                  setLooperDuration(int mLooperDuration)
 *   最大动画时长                    setDefaultDruation(int mDefaultDruation)
 *   同一时刻随机生成控件的最大个数  setItemShowCount(int itemShowCount)
 *   随机控件分布网格空间大小        setRegularity(int xRegularity, int yRgularity)
 *   随机控件总数和显示（类似Adapter）setOnCreateItemViewListener(OnCreateItemViewListener itemViewListener)
 * #
 *
 * 子控件特点：
 *   对于子控件没有确切的要求，只要是控件父类为 View 类，就可以使用本随机布局添加显示。
 * #
 *
 * 注意：
 *   如果期望修改动画，可以先自定义动画，随后修改com.special.simplecloudview.random_layout
 *   文档中CloudRandomLayout.java（即，布局的所在文件）的startZoomAnimation方法即可。
 *
 *
 */
public class RandomActivity3 extends AppCompatActivity {

	private List<String> list;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_randomlayout3);
		AnimatedRandomLayout cloudRandomLayout = (AnimatedRandomLayout) findViewById(R.id.rl_cloud);
		
		
		String[] str = {"1","2","3","4","5","6","7","8","9","10","a","b","c","d","e","f","g","h","i",
						"j","k","l","m","n","o","p","r","s","u","v","w","x","y","z"};

		String[] str2 = new String[]{
				"博鳌亚洲论坛", "哈佛商业评论", "财经国家周刊", "每日经济新闻", "中国企业家", "路透中文网", "国际金融报",
				"中国证券网", "中国经营报", "经济观察报", "中国经济网",
				"印度去年四季度GDP增7.3% 领跑全", "大年初一全国电影总票房6.6亿元刷新纪", "都说爱钱如命 你知道人民币上的姑娘是谁",
				"中国最美女富豪身价过百亿 马云曾千里寻", "100万在世界各国能买什么房 最后一张", "一个捡破烂的！他三年竟然赚了270万"};
		String[] str3 = new String[]{   "FT中文网", "财经网", "创业家", "福布斯", "美通社", "21世纪经济报道", "华尔街见闻", "中国黄金交易网",
				"CCTV证券资讯网", "中国发展研究基金会", "证券日报", "中国民族证券", "新财富杂志", "环球企业家", "中国证券报",
				"证券时报网", "易三板", "中国金融网", "易三板", "未央网", "商学院", "欧美股市大跌 金价创八个月来新高",
				"证券市场周刊", "财新网", "华夏时报", "第一财经",
				"中国货币政策拐点或已到来", "春运最拥挤火车站公布 北京西站未进前十", "日本拟建1700米高“天空之城” 超越"};


		list = Arrays.asList(str2);
		
		
		cloudRandomLayout.setRegularity(15, 15);
		cloudRandomLayout.setItemShowCount(2);
		cloudRandomLayout.setLooperDuration(100);
		cloudRandomLayout.setDefaultDruation(10000);
		cloudRandomLayout.setOnCreateItemViewListener(new AnimatedRandomLayout.OnCreateItemViewListener() {
			
			@Override
			public int getCount() {
				return list.size();
			}
			
			@Override
			public View createItemView(int position, View convertView) {
				final TextView textView = new TextView(getApplicationContext());
				//1.设置文本数据
				int listPosition = position;
				textView.setText(list.get(listPosition) + "");
				//2.设置随机的字体
				Random random = new Random();
				textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,random.nextInt(8)+24);//14-21
				//3.上色，设置随机字体颜色
//				textView.setTextColor(ColorUtil.randomColor());
				textView.setTextColor(Color.WHITE);
				//4.设置点击事件
				textView.setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View v) {
						ToastUtil.showToast(getApplicationContext(), textView.getText().toString());
					}
				});
				
				return textView;
			}
		});
		
		cloudRandomLayout.start();
		
	}


}
