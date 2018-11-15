package okay.test.timeline;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import okay.test.timeline.view.TimelineView;

/**
 * Copyright
 * <p>
 * Created by xuyang on 17/10/20 14:40
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */

public class TimeLineTestActivity extends AppCompatActivity {

    @BindView(R.id.timelineview)
    TimelineView timelineview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline_test);
        ButterKnife.bind(this);
    }

}
