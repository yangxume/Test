package com.xy.t_popupwindow.easypopup.easypop;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xy.t_popupwindow.R;

public class ComplexAdapter extends BaseQuickAdapter<String,BaseViewHolder> {

    public ComplexAdapter() {
        super(R.layout.item_complex, null);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_complex_item,item);
        helper.addOnClickListener(R.id.btn_complex_delete);
    }
}
