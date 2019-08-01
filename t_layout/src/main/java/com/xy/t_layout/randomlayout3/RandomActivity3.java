package com.xy.t_layout.randomlayout3;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import android.animation.Animator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieAnimationView;
import com.xy.t_layout.R;
import com.xy.t_layout.flowlayout.ActivityFlowLayout;
import com.xy.t_layout.flowlayout.FlowLayout;
import com.xy.t_layout.flowlayout.TagAdapter;
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
public class RandomActivity3 extends AppCompatActivity
implements OnClickListener{

	String[] str1 = {"1","2","3","4","5","6","7","8","9","10","a","b","c","d","e","f","g","h","i",
			"j","k","l","m","n","o","p","r","s","u","v","w","x","y","z"};

	String[] str2 = new String[]{
			"博鳌亚洲论坛", "哈佛商业评论", "财经国家周刊", "每日经济新闻",
			"中国企业家", "路透中文网", "国际金融报",
			"中国证券网", "中国经营报", "经济观察报", "中国经济网"};

	private List<String> list;
	private LottieAnimationView lottieLike;
	private AnimatedRandomLayout animatedRandomLayout;

	private Button btn_start,btn_pause,btn_stop;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_randomlayout3);

		initView();

		testLottieAnim();

		testRandomLayout();

	}

	private void testLottieAnim() {

		lottieLike.playAnimation();  //播放
//		lottieLike.pauseAnimation(); //暂停
//		lottieLike.cancelAnimation(); //取消
//		lottieLike.getDuration();  //获取动画时长
		lottieLike.addAnimatorListener(new Animator.AnimatorListener() { //添加动画监听
			@Override
			public void onAnimationStart(Animator animation) {

			}

			@Override
			public void onAnimationEnd(Animator animation) {

			}

			@Override
			public void onAnimationCancel(Animator animation) {

			}

			@Override
			public void onAnimationRepeat(Animator animation) {

			}
		});

	}

	private void initView() {
		lottieLike = findViewById(R.id.lottie_likeanim);
		animatedRandomLayout = (AnimatedRandomLayout) findViewById(R.id.rl_cloud);

		btn_start = findViewById(R.id.btn_start);
		btn_pause= findViewById(R.id.btn_pause);
		btn_stop = findViewById(R.id.btn_stop);

		btn_start.setOnClickListener(this);
		btn_pause.setOnClickListener(this);
		btn_stop.setOnClickListener(this);
	}

	private void testRandomLayout() {
		list = Arrays.asList(str2);

		animatedRandomLayout.setRegularity(15, 15);
		animatedRandomLayout.setItemShowCount(2);
		animatedRandomLayout.setLooperDuration(100);
		animatedRandomLayout.setDefaultDruation(10000);

		animatedRandomLayout.setOnCreateItemViewListener(new AnimatedRandomLayout.OnCreateItemViewListener() {

			@Override
			public int getCount() {
				return list.size();
			}

			@Override
			public View createItemView(int position, View certView) {


				final TextView textView = new TextView(getApplicationContext());
				//1.设置文本数据
				int listPosition = position;
				textView.setText(list.get(listPosition) + "");
				//2.设置随机的字体
				Random random = new Random();
				textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,random.nextInt(8)+44);//14-21
				//3.上色，设置随机字体颜色
//				textView.setTextColor(ColorUtil.randomColor());
				textView.setTextColor(Color.WHITE);

				textView.setBackground(ContextCompat.getDrawable(RandomActivity3.this,R.drawable.shape_circle_bg_white_touming));

				int paddingLeft = 24;
				int paddingTop = 12;

				textView.setPadding(paddingLeft,paddingTop,paddingLeft,paddingTop);

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

		animatedRandomLayout.start();

	}

	@Override
	protected void onPause() {
		super.onPause();

		if (animatedRandomLayout != null){
			animatedRandomLayout.cancelAnimation();
		}

	}

	@Override
	public void onClick(View v) {

		int id = v.getId();

		switch (id){

			case R.id.btn_start:
				lottieLike.playAnimation();
				break;

			case R.id.btn_pause:
				lottieLike.pauseAnimation();
				break;

			case R.id.btn_stop:
				lottieLike.cancelAnimation();
				break;

		}

	}
}
