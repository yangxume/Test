package com.okay.test.activity.activity01_image;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.okay.test.R;
import com.okay.test.utils.BitmapLruCache;
import com.okay.test.utils.DateUtil;
import com.okay.test.utils.Drawable2BitmapUtil;
import com.okay.test.view.RoundImageView;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/1/18 11:38
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */

public class Activity01_05_LruCache extends AppCompatActivity {


    private Context ctx;
    private ImageView imageview;
    private RoundImageView roundImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity01_05_lrucache);
        ctx = Activity01_05_LruCache.this;

        initView();
        testLruCache();
        testRoundImageView();
    }

    private void testRoundImageView() {

        roundImageView.setImageDrawable(ContextCompat.getDrawable(ctx,R.mipmap.ic_launcher));

    }

    private void initView() {

        imageview = (ImageView) findViewById(R.id.imageview);
        roundImageView = (RoundImageView) findViewById(R.id.roundImageView);

    }

    private void testLruCache() {

        long currentTimeMillis = SystemClock.currentThreadTimeMillis();
        String date = DateUtil.transferLongToDate(currentTimeMillis);
//        Bitmap bitmap = Drawable2BitmapUtil.drawable2BitmapByBitmapFactory(ctx, R.mipmap.ic_launcher);
//        Bitmap bitmap = Drawable2BitmapUtil.drawable2BitmapByBitmapDrawable(ctx, R.mipmap.ic_launcher);
        Bitmap bitmap = Drawable2BitmapUtil.drawable2BitmapByCanvas(ctx, R.mipmap.ic_launcher);
        imageview.setImageBitmap(bitmap);

        long maxMemory = Runtime.getRuntime().maxMemory()/ (1024 * 1024);
        BitmapLruCache bitmapLruCache = new BitmapLruCache((int) (maxMemory / 50));
        bitmapLruCache.put(date, bitmap);


    }
}
