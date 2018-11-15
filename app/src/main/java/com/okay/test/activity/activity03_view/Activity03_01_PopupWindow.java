package com.okay.test.activity.activity03_view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.okay.test.R;

/**
 * Copyright
 * <p>
 * Created by xuyang on 17/11/13 11:39
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */

public class Activity03_01_PopupWindow extends Activity {

    private static final String TAG = Activity03_01_PopupWindow.class.getSimpleName();

    private Context ctx;
    private Button btn_show_popupWindow;
    private Button btn_show_popupWindow2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = Activity03_01_PopupWindow.this;

        setContentView(R.layout.activity03_01_popupwindow);
        btn_show_popupWindow = (Button) findViewById(R.id.btn_show_popupWindow);
        btn_show_popupWindow2 = (Button) findViewById(R.id.btn_show_popupWindow2);

        btn_show_popupWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow(1,btn_show_popupWindow);
            }
        });

        btn_show_popupWindow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindow(2,btn_show_popupWindow2);
            }
        });


    }

    private void showPopupWindow(int type,View btn) {
        final PopupWindow popupWindow = new PopupWindow(ctx);
        View view = LayoutInflater.from(ctx).inflate(R.layout.task_report_query_type_list, null);

        if (type == 1){
            view.setBackgroundResource(R.drawable.task_report_customspinner_bg);

        }else{
            view.setBackgroundResource(R.drawable.task_reslist_popup_bg);

        }

        popupWindow.setContentView(view);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        popupWindow.setOutsideTouchable(true);
        popupWindow.showAsDropDown(btn, -100, -21);
//        popupWindow.showAsDropDown(btn_show_popupWindow);

        final TextView publishTv = (TextView) view.findViewById(R.id.tv_publish);
        publishTv.setVisibility(View.VISIBLE);
        publishTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(ctx, "11");
                popupWindow.dismiss();
            }
        });

        TextView publishAnswerTv = (TextView) view.findViewById(R.id.tv_publish_answer);
        publishAnswerTv.setVisibility(View.VISIBLE);
        publishAnswerTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(ctx, "22");
                popupWindow.dismiss();
            }
        });

        TextView cancelTv = (TextView) view.findViewById(R.id.tv_cancel);
        cancelTv.setVisibility(View.VISIBLE);

        cancelTv.setTextColor(Color.parseColor("#FFC5D8E6"));
        cancelTv.setBackgroundResource(android.R.color.transparent);
        cancelTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(ctx, "33");
                popupWindow.dismiss();
            }
        });
    }

    private void showToast(Context ctx, String text) {

        Toast.makeText(ctx, text, Toast.LENGTH_LONG).show();

    }

}
