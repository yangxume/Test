package okay.gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Copyright
 * <p>
 * Created by xuyang on 17/5/26 11:43
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */

public class GalleryAdapter extends BaseAdapter {

    private Context ctx;
    private Integer [] datas;
    private int question_num;
    private int current_num;

    public GalleryAdapter(Context ctx, Integer[] datas,int question_num,int current_num) {
        this.ctx = ctx;
        this.datas = datas;
        this.question_num = question_num;
        this.current_num = current_num;
    }

    private int selectItem;
    public void setSelectItem(int selectItem) {

        if (this.selectItem != selectItem) {
            this.selectItem = selectItem;
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return datas.length;
    }

    @Override
    public Object getItem(int position) {
        return datas[position];
    }

    @Override
    public long getItemId(int position) {


        return datas[position];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if (convertView == null) {

            holder = new ViewHolder();
            convertView = View.inflate(ctx, R.layout.gallery_item, null);
            holder.item_ll = (LinearLayout) convertView.findViewById(R.id.item_ll);
            holder.item_iv = (ImageView) convertView.findViewById(R.id.item_iv);
            holder.item_tv = (TextView) convertView.findViewById(R.id.item_tv);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (selectItem == position) {
//                holder.item_ll.setBackgroundColor(ContextCompat.getColor(ctx,android.R.color.holo_red_light));
            setItemViewSelected(holder, selectItem, question_num);
        } else {
//                holder.item_ll.setBackgroundColor(ContextCompat.getColor(ctx,android.R.color.darker_gray));
            setItemViewDefault(holder);
        }

//            holder.item_ll.setBackgroundColor(ContextCompat.getColor(ctx,android.R.color.holo_red_light));

        holder.item_tv.setText(position + "-p");

        return convertView;
    }

    private void setItemViewDefault(ViewHolder viewHolder) {
        viewHolder.item_iv.setVisibility(View.VISIBLE);
        viewHolder.item_tv.setVisibility(View.GONE);
        viewHolder.item_tv.setBackgroundResource(R.drawable.task_report_bottom_navigation_default);
    }

    private void setItemViewSelected(ViewHolder viewHolder, int select_position_num, int total_question_num) {
        viewHolder.item_iv.setVisibility(View.GONE);
        viewHolder.item_tv.setVisibility(View.VISIBLE);
        viewHolder.item_ll.setBackgroundResource(R.drawable.task_report_bottom_navigation_selected);
        viewHolder.item_tv.setText(select_position_num + "/" + total_question_num);
    }

    class ViewHolder {

        LinearLayout item_ll;
        ImageView item_iv;
        TextView item_tv;

    }

}
