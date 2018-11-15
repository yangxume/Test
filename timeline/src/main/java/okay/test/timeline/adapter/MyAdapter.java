//package okay.test.timeline.adapter;
//
//import android.content.Context;
//import android.support.v7.widget.AppCompatTextView;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import java.util.List;
//
//import okay.test.timeline.R;
//import okay.test.timeline.bean.TimeLineBean;
//import okay.test.timeline.view.TimeLineMarkerView;
//
///**
// * Copyright
// * <p>
// * Created by xuyang on 17/10/20 15:10
// * <p>
// * email xuyangme@126.com
// * <p>
// * ${FILENAME}
// * <p>
// * Description
// * <p>
// * Update records:
// */
//
//public class MyAdapter extends RecyclerView.Adapter<MyAdapter.TimeLineViewHolder> {
//
//
//    private Context ctx;
//    private List<TimeLineBean> datas;
//
//    public MyAdapter(Context ctx, List<TimeLineBean> datas) {
//        this.ctx = ctx;
//        this.datas = datas;
//    }
//
//
//    @Override
//    public TimeLineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//
//        final LayoutInflater inflater = LayoutInflater.from(ctx);
//
//
//        final View view = inflater.inflate(R.layout.item_timeline_horizontal, parent, false);
//
//        return new TimeLineViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(TimeLineViewHolder holder, int position) {
//
//
//        holder.textview1.setText(datas.get(position).content);
//        holder.textview2.setText(datas.get(position).time);
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return (datas != null ? datas.size() : 0);
//    }
//
//    class TimeLineViewHolder extends RecyclerView.ViewHolder {
//
//
//        private TimeLineMarkerView timeLineMarkerView;
//        private AppCompatTextView textview1;
//        private AppCompatTextView textview2;
//
//        public TimeLineViewHolder(View itemView) {
//            super(itemView);
//
//            timeLineMarkerView = itemView.findViewById(R.id.time_line);
//            textview1 = itemView.findViewById(R.id.tv1);
//            textview2 = itemView.findViewById(R.id.tv2);
//
//        }
//
//
//    }
//}
