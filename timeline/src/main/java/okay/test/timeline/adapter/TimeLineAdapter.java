package okay.test.timeline.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.github.vipulasri.timelineview.TimelineView;

import java.util.List;

import okay.test.timeline.R;
import okay.test.timeline.bean.TimeLineBean;
import okay.test.timeline.enu.OrderStatus;
import okay.test.timeline.enu.Orientation;
import okay.test.timeline.utils.DateTimeUtils;
import okay.test.timeline.utils.VectorDrawableUtils;

/**
 * Copyright
 * <p>
 * Created by xuyang on 17/10/20 16:37
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */

public class TimeLineAdapter extends RecyclerView.Adapter<TimeLineAdapter.TimeLineViewHolder> {

    private LinearLayout linearLayout;
    private List<TimeLineBean> mFeedList;
    private Context mContext;
    private Orientation mOrientation;
    private boolean mWithLinePadding;
    private LayoutInflater mLayoutInflater;

    public TimeLineAdapter(List<TimeLineBean> feedList, Orientation orientation, boolean withLinePadding) {
        mFeedList = feedList;
        mOrientation = orientation;
        mWithLinePadding = withLinePadding;
    }

//    @Override
//    public int getItemViewType(int position) {
//        return TimelineView.getTimeLineViewType(position, getItemCount());
//    }

    @Override
    public TimeLineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        mLayoutInflater = LayoutInflater.from(mContext);
        View view;

        if (mOrientation == Orientation.HORIZONTAL) {
              view = mLayoutInflater.inflate(R.layout.item_timeline_horizontal,parent,false);
        } else {
              view = mLayoutInflater.inflate(R.layout.item_timeline_vertical,parent,false);
        }

        return new TimeLineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TimeLineViewHolder holder, int position) {

        TimeLineBean TimeLineBean = mFeedList.get(position);

        if (TimeLineBean.status == OrderStatus.INACTIVE) {
            holder.mTimelineView.setMarker(VectorDrawableUtils.getDrawable(mContext, R.drawable.ic_marker_inactive, android.R.color.darker_gray));
        } else if (TimeLineBean.status == OrderStatus.ACTIVE) {
            holder.mTimelineView.setMarker(VectorDrawableUtils.getDrawable(mContext, R.drawable.ic_marker_active, R.color.colorPrimary));
        } else {
            holder.mTimelineView.setMarker(ContextCompat.getDrawable(mContext, R.drawable.ic_marker), ContextCompat.getColor(mContext, R.color.colorPrimary));
        }

        if (!TimeLineBean.date.isEmpty()) {
            holder.text_timeline_date.setVisibility(View.VISIBLE);
            holder.text_timeline_date.setText(DateTimeUtils.parseDateTime(TimeLineBean.date, "yyyy-MM-dd HH:mm", "hh:mm a, dd-MMM-yyyy"));
        } else
            holder.text_timeline_date.setVisibility(View.GONE);

        holder.text_timeline_title.setText(TimeLineBean.message);
    }

    @Override
    public int getItemCount() {
        return (mFeedList != null ? mFeedList.size() : 0);
    }

    class TimeLineViewHolder extends RecyclerView.ViewHolder{

        TimelineView mTimelineView;
        AppCompatTextView text_timeline_title;
        AppCompatTextView text_timeline_date;

        public TimeLineViewHolder(View itemView) {
            super(itemView);

            mTimelineView = itemView.findViewById(R.id.time_marker);
            text_timeline_title = itemView.findViewById(R.id.text_timeline_title);
            text_timeline_date = itemView.findViewById(R.id.text_timeline_date);

        }
    }

}
