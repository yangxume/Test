package okay.gallery;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

public class GalleryActivity extends Activity
        implements AdapterView.OnItemClickListener,
        ViewSwitcher.ViewFactory,
        AdapterView.OnItemSelectedListener {

    Context ctx;
    Gallery gallery1;
    ViewPager viewPager;
    private int mindex = 0;


    private int[] mimage = new int[]{
            R.mipmap.ic_launcher_round,
            R.mipmap.ic_launcher_round,
            R.mipmap.ic_launcher_round,

            R.mipmap.ic_launcher_round,
            R.mipmap.ic_launcher_round,
            R.mipmap.ic_launcher_round,

            R.mipmap.ic_launcher_round,
            R.mipmap.ic_launcher_round,
            R.mipmap.ic_launcher_round,

            R.mipmap.ic_launcher_round,
            R.mipmap.ic_launcher_round,
            R.mipmap.ic_launcher_round,

            R.mipmap.ic_launcher_round,
            R.mipmap.ic_launcher_round
    };

    private Integer[] datas = new Integer[14];
    GalleryAdapter adapter;
    int question_num = 14;
    int selectItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ctx = this;

        for (int i = 0; i < question_num; i++)
            datas[i] = i;


        viewPager = (ViewPager) findViewById(R.id.vp);
        viewPager.setAdapter(new MyAdapter(ctx,datas));
        gallery1 = (Gallery) findViewById(R.id.gallery);
        adapter = new GalleryAdapter(ctx, datas, 14, 0);
        gallery1.setAdapter(adapter);

        gallery1.setOnItemClickListener(this);
        gallery1.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        adapter.setSelectItem(position);  //当滑动时，事件响应，调用适配器中的这个方法。
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
//        imageSwitcher.setImageResource(mimage[arg2]);
    }

    @Override
    public View makeView() {

        return new ImageView(this);

    }


    private class MyAdapter extends PagerAdapter {

        Context ctx;
        Integer [] data;

        public MyAdapter(Context ctx, Integer[] data) {
            this.ctx = ctx;
            this.data = data;
        }

        @Override
        public int getCount() {
            return data.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return false;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            return super.instantiateItem(container, position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
        }

    }

//    class GalleryAdapter extends BaseAdapter {
//        private int selectItem;
//        public void setSelectItem(int selectItem) {
//
//            if (this.selectItem != selectItem) {
//                this.selectItem = selectItem;
//                notifyDataSetChanged();
//            }
//        }
//
//        @Override
//        public int getCount() {
//            return mimage.length;
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return mimage[position];
//        }
//
//        @Override
//        public long getItemId(int position) {
//
//
//            return mimage[position];
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//
//            ViewHolder holder;
//            if (convertView == null){
//
//                holder = new ViewHolder();
//                convertView = View.inflate(ctx,R.layout.gallery_item,null);
//                holder.item_ll = (LinearLayout) convertView.findViewById(R.id.item_ll);
//                holder.item_iv = (ImageView) convertView.findViewById(R.id.item_iv);
//                holder.item_tv = (TextView) convertView.findViewById(R.id.item_tv);
//
//                convertView.setTag(holder);
//
//            }else{
//                holder = (ViewHolder) convertView.getTag();
//            }
//
//            if(selectItem==position){
////                holder.item_ll.setBackgroundColor(ContextCompat.getColor(ctx,android.R.color.holo_red_light));
//                  setItemViewSelected(holder,selectItem,question_num);
//            }
//            else{
////                holder.item_ll.setBackgroundColor(ContextCompat.getColor(ctx,android.R.color.darker_gray));
//                  setItemViewDefault(holder);
//            }
//
////            holder.item_ll.setBackgroundColor(ContextCompat.getColor(ctx,android.R.color.holo_red_light));
//
//            holder.item_iv.setImageResource(mimage[position]);
//            holder.item_tv.setText(position+"-p");
//
//            return convertView;
//        }
//
//
//        class ViewHolder{
//
//            LinearLayout item_ll;
//            ImageView item_iv;
//            TextView item_tv;
//
//        }
//
//
//    }
//    private void setItemViewDefault(GalleryAdapter.ViewHolder viewHolder) {
//        viewHolder.item_iv.setVisibility(View.VISIBLE);
//        viewHolder.item_tv.setVisibility(View.GONE);
//        viewHolder.item_tv.setBackgroundResource(R.drawable.task_report_bottom_navigation_default);
//    }
//
//    private void setItemViewSelected(GalleryAdapter.ViewHolder viewHolder, int selectPosition, int total_num) {
//        viewHolder.item_iv.setVisibility(View.GONE);
//        viewHolder.item_tv.setVisibility(View.VISIBLE);
//        viewHolder.item_ll.setBackgroundResource(R.drawable.task_report_bottom_navigation_selected);
//        viewHolder.item_tv.setText(selectPosition + "/" + total_num);
//    }


}
