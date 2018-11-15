package okay.test.timeline;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Copyright
 * <p>
 * Created by xuyang on 17/10/20 14:36
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records: 时间轴使用 timeline
 */

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.btn_basic_timeline)
    Button btnBasicTimeline;
    @BindView(R.id.btn_horizontal_vertical_timeline)
    Button btnHorizontalVerticalTimeline;
    @BindView(R.id.btn_test_timeline)
    Button btnTestTimeline;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_basic_timeline, R.id.btn_horizontal_vertical_timeline, R.id.btn_test_timeline})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_basic_timeline:
                startActivity(new Intent(this, TimeLineBasicActivity.class));
                break;
            case R.id.btn_horizontal_vertical_timeline:
                startActivity(new Intent(this, TimeLineInRecyclerViewActivity.class));
                break;
            case R.id.btn_test_timeline:
                startActivity(new Intent(this, TimeLineTestActivity.class));
                break;
        }
    }
}
