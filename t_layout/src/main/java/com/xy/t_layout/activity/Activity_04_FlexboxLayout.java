package com.xy.t_layout.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.flexbox.FlexboxLayout;
import com.xy.t_layout.R;
import com.xy.t_layout.util.UIUtil;
import com.xy.t_layout.bean.Grade;
/**
 * https://www.jianshu.com/p/217b3f4a1a18
 */
public class Activity_04_FlexboxLayout extends AppCompatActivity {


    private static final String TAG = Activity_04_FlexboxLayout.class.getSimpleName();

    private String[] gradeNames = new String[]
            {
                    "小学四年级",
                    "小学五年级",
                    "小学六年级",
                    "小学四年级",
                    "小学五年级",
                    "小学六年级",
                    "小学四年级",
                    "小学五年级",
                    "小学六年级",
                    "小学四年级",
                    "小学五年级",
                    "小学六年级",
                    "小学四年级",
                    "小学五年级",
                    "小学六年级",
                    "小学四年级",
                    "小学五年级",
                    "小学六年级",
                    "小学四年级",
                    "小学五年级",
                    "小学六年级",
                    "小学四年级",
                    "小学五年级",
                    "小学六年级",
                    "小学四年级",
                    "小学五年级",
                    "小学六年级"
            };

    private FlexboxLayout flexboxLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_04_flexboxlayout);

        flexboxLayout = (FlexboxLayout) findViewById(R.id.flexbox_layout);
        for (int i = 0; i < gradeNames.length; i++) {
            Grade grade = new Grade();
            grade.setId(i);
            grade.setName(gradeNames[i]);

            flexboxLayout.addView(createNewFlexItemTextView(grade));
        }
    }



    private TextView createTextView(Grade grade){

        View view = LayoutInflater
                .from(this)
                .inflate(R.layout.pc_layout_item_teaching_info_normal,null);

        TextView tv = view.findViewById(R.id.tv);

        tv.setText(grade.getName());

        return tv;
    }
    /**
     * 动态创建TextView
     * @param grade
     * @return
     */
    private TextView createNewFlexItemTextView(final Grade grade) {

        TextView textView = new TextView(this);
        textView.setHeight(UIUtil.dpToPixel(this,43));
        textView.setGravity(Gravity.CENTER);
        textView.setText(grade.getName());
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 21);
        textView.setTextColor(getResources().getColor(R.color.black_FF335166));
        textView.setBackgroundResource(R.drawable.shape_circle_bg_white_blue);
        textView.setTag(grade.getId());
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e(TAG, grade.getName());
            }
        });
//        int padding = UIUtil.dpToPixel(this, 4);
        int paddingLeftAndRight = UIUtil.dpToPixel(this, 24);
        ViewCompat.setPaddingRelative(textView, paddingLeftAndRight, 0, paddingLeftAndRight, 0);
        FlexboxLayout.LayoutParams layoutParams = new FlexboxLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        int margin = UIUtil.dpToPixel(this, 6);
        int marginTop = UIUtil.dpToPixel(this, 16);
        layoutParams.setMargins(margin, marginTop, margin, 0);
        textView.setLayoutParams(layoutParams);
        return textView;
    }

}
