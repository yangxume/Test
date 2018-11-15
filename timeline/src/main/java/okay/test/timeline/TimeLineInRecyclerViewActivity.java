package okay.test.timeline;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okay.test.timeline.adapter.TimeLineAdapter;
import okay.test.timeline.bean.TimeLineBean;
import okay.test.timeline.enu.OrderStatus;
import okay.test.timeline.enu.Orientation;

/**
 * Copyright
 * <p>
 * Created by xuyang on 17/10/20 14:39
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */

public class TimeLineInRecyclerViewActivity extends AppCompatActivity {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.btn_horizontal_timeline)
    Button btnHorizontalTimeline;
    @BindView(R.id.btn_vertical_timeline)
    Button btnVerticalTimeline;

    private List<TimeLineBean> mDataList;
    private LinearLayoutManager linearLayoutManager;
    Orientation orientation = Orientation.HORIZONTAL;
    TimeLineAdapter timeLineAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline_horizontal_vertical);
        ButterKnife.bind(this);
        setDataListItems();

        setView();

    }

    private void setView() {
        if (orientation == Orientation.HORIZONTAL) {

            linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        } else if (orientation == Orientation.VERTICAL) {

            linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        }
        recyclerview.setLayoutManager(linearLayoutManager);
        timeLineAdapter = new TimeLineAdapter(mDataList, orientation, false);
        recyclerview.setAdapter(timeLineAdapter);
    }


    private void setDataListItems() {

        mDataList = new ArrayList<>();

        mDataList.add(new TimeLineBean("Item successfully delivered", "", OrderStatus.INACTIVE));
        mDataList.add(new TimeLineBean("Courier is out to delivery your order", "2017-02-12 08:00", OrderStatus.ACTIVE));
        mDataList.add(new TimeLineBean("Item has reached courier facility at New Delhi", "2017-02-11 21:00", OrderStatus.COMPLETED));
        mDataList.add(new TimeLineBean("Item has been given to the courier", "2017-02-11 18:00", OrderStatus.COMPLETED));
        mDataList.add(new TimeLineBean("Item is packed and will dispatch soon", "2017-02-11 09:30", OrderStatus.COMPLETED));
        mDataList.add(new TimeLineBean("Order is being readied for dispatch", "2017-02-11 08:00", OrderStatus.COMPLETED));
        mDataList.add(new TimeLineBean("Order processing initiated", "2017-02-10 15:00", OrderStatus.COMPLETED));
        mDataList.add(new TimeLineBean("Order confirmed by seller", "2017-02-10 14:30", OrderStatus.COMPLETED));
        mDataList.add(new TimeLineBean("Order placed successfully", "2017-02-10 14:00", OrderStatus.COMPLETED));
    }

    @OnClick({R.id.btn_horizontal_timeline, R.id.btn_vertical_timeline})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_horizontal_timeline:

                orientation = Orientation.HORIZONTAL;
                setView();


                break;
            case R.id.btn_vertical_timeline:
                orientation = Orientation.VERTICAL;
                setView();
                break;
        }
    }
}
