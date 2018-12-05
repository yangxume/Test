package com.xy.okmediaplayer;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.okay.mediaplayersdk.player.MediaInfo;
import com.okay.mediaplayersdk.player.MediaPlayer;
import com.okay.mediaplayersdk.player.MediaPlayerOption;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private String media_json = "[\n" +
            "  {\n" +
            "    \"url_n\": \"https://rv.okjiaoyu.cn/rv_13ifdbxfgbu.normal.h264.mp4\",\n" +
            "    \"url_h\": \"https://rv.okjiaoyu.cn/rv_13ifdbxfgbu.high.h264.mp4\",\n" +
            "    \"url_l\": \"https://rv.okjiaoyu.cn/rv_13ifdbxfgbu.low.h264.mp4\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"url_n\": \"https://rv.okjiaoyu.cn/rv_11OvXWXtRXq.normal.h264.mp4\",\n" +
            "    \"url_h\": \"https://rv.okjiaoyu.cn/rv_11OvXWXtRXq.high.h264.mp4\",\n" +
            "    \"url_l\": \"https://rv.okjiaoyu.cn/rv_11OvXWXtRXq.low.h264.mp4\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"url_n\": \"https://rv.okjiaoyu.cn/rv_12kfeOvDy8g.normal.h264.mp4\",\n" +
            "    \"url_h\": \"https://rv.okjiaoyu.cn/rv_12kfeOvDy8g.high.h264.mp4\",\n" +
            "    \"url_l\": \"https://rv.okjiaoyu.cn/rv_12kfeOvDy8g.low.h264.mp4\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"url_n\": \"https://rv.okjiaoyu.cn/rv_12kfkO96oFi.normal.h264.mp4\",\n" +
            "    \"url_h\": \"https://rv.okjiaoyu.cn/rv_12kfkO96oFi.high.h264.mp4\",\n" +
            "    \"url_l\": \"https://rv.okjiaoyu.cn/rv_12kfkO96oFi.low.h264.mp4\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"url_n\": \"https://rv.okjiaoyu.cn/rv_12EQSOY2SWI.normal.h264.mp4\",\n" +
            "    \"url_h\": \"https://rv.okjiaoyu.cn/rv_12EQSOY2SWI.high.h264.mp4\",\n" +
            "    \"url_l\": \"https://rv.okjiaoyu.cn/rv_12EQSOY2SWI.low.h264.mp4\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"url_l\": \"https://ra.okjiaoyu.cn/ra_yd7xsx1aaA.mp3\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"url_l\": \"https://ra.okjiaoyu.cn/ra_xJhhk3Xjtm.mp3\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"url_l\": \"https://ra.okjiaoyu.cn/ra_11d8qTWH1te.mp3\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"url_h\": \"https://rv.okjiaoyu.cn/rv_12plxi2cXEA.mp4\"\n" +
            "  }\n" +
            "]";
    private MediaPlayer okMediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {


        okMediaPlayer = findViewById(R.id.media_player);

        List<MediaInfo> list = new ArrayList<>();

        MediaInfo okMediaInfo = new MediaInfo();
        okMediaInfo.url = "https://rv.okjiaoyu.cn/rv_13ifdbxfgbu.normal.h264.mp4";
        list.add(okMediaInfo);

        MediaPlayerOption okMediaPlayerOption = new MediaPlayerOption
                .Builder()
                .setMediaInfoList(list)
                .build();

        okMediaPlayer.setOption(okMediaPlayerOption);

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (okMediaPlayer != null) {
            okMediaPlayer.saveState();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (okMediaPlayer != null) {
            okMediaPlayer.restoreState();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (okMediaPlayer != null) {
            okMediaPlayer.stop();
        }
    }
}
