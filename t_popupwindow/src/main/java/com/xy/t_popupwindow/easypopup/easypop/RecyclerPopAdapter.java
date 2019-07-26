package com.xy.t_popupwindow.easypopup.easypop;

import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xy.t_popupwindow.R;

/**
 * Created by zyyoona7 on 2017/9/14.
 */

public class RecyclerPopAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

    private View.OnTouchListener mOnTouchListener;

    public RecyclerPopAdapter() {
        super(R.layout.layout_item_pop, null);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, String s) {
        baseViewHolder.addOnClickListener(R.id.iv_close);
        baseViewHolder.itemView.setOnTouchListener(mOnTouchListener);
    }

    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.mOnTouchListener = onTouchListener;
    }
}
