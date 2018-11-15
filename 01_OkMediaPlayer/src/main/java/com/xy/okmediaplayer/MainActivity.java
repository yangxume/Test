package com.xy.okmediaplayer;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.okay.mediaplayersdk.media.IPlayerEndListener;
import com.okay.mediaplayersdk.media.IPlayerErrorListener;
import com.okay.mediaplayersdk.media.IPlayerProgressListener;
import com.okay.mediaplayersdk.player.IOkMediaPlayer;
import com.okay.mediaplayersdk.player.OkMediaInfo;
import com.okay.mediaplayersdk.player.OkMediaPlayer;
import com.okay.mediaplayersdk.player.OkMediaPlayerOption;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IOkMediaPlayer{

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {


        OkMediaPlayer okMediaPlayer = findViewById(R.id.media_player);

        List<OkMediaInfo> list = new ArrayList<>();

        OkMediaInfo okMediaInfo = new OkMediaInfo();
        okMediaInfo.url = "https://rv.okjiaoyu.cn/rv_13ifdbxfgbu.normal.h264.mp4";
        list.add(okMediaInfo);

        OkMediaPlayerOption okMediaPlayerOption = new OkMediaPlayerOption
                .Builder()
                .setMediaInfoList(list)
                .build();

        okMediaPlayer.setOption(okMediaPlayerOption);

    }

    @Override
    public void setOption(OkMediaPlayerOption okMediaPlayerOption) {

    }

    @Override
    public void play() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void seekTo(int i) {

    }

    @Override
    public void request2FullScreen() {

    }

    @Override
    public void quit2FullScreen() {

    }

    @Override
    public void request2Size(int i, int i1) {

    }

    @Override
    public boolean isCurrentFullScreenMode() {
        return false;
    }

    @Override
    public Bitmap getThubmnail() {
        return null;
    }

    @Override
    public boolean isPlaying() {
        return false;
    }

    @Override
    public void setSpeed(float v) {

    }

    @Override
    public void switchStream(String s) {

    }

    @Override
    public void setIPlayerProgressListener(IPlayerProgressListener iPlayerProgressListener) {

    }

    @Override
    public void setIPlayerErrorListener(IPlayerErrorListener iPlayerErrorListener) {

    }

    @Override
    public void setIPlayerEndListener(IPlayerEndListener iPlayerEndListener) {

    }

    @Override
    public int getDuration() {
        return 0;
    }

    @Override
    public int getBufferPercentage() {
        return 0;
    }

    @Override
    public int getCurrentPosition() {
        return 0;
    }

    @Override
    public void saveState() {

    }

    @Override
    public void restoreState() {

    }
}
