package com.okay.test.activity.activity01_image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.okay.test.R;
import com.okay.test.view.SpliceDrawableView;

/**
 * Copyright
 * <p>
 * Created by xuyang on 17/11/6 15:40
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */

public class Activity01_03_SpliceBitmap extends AppCompatActivity{

    private Context ctx;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity01_03_splicebitmap);

        ctx = Activity01_03_SpliceBitmap.this;

        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.mipmap.png1);
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.mipmap.png2);
        Bitmap bitmap3 = BitmapFactory.decodeResource(getResources(), R.mipmap.png3);
        final Bitmap [] bitmaps = {
                bitmap1,bitmap2,bitmap3,
                bitmap1,bitmap2,bitmap3,
                bitmap1,bitmap2,bitmap3,
                bitmap1,bitmap2,bitmap3,
                bitmap1,bitmap2,bitmap3,
                bitmap1,bitmap2,bitmap3
        };

        findViewById(R.id.btn_splice_bitmap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spliceBitmap("简答题",bitmaps);
            }

        });

    }

    private void spliceBitmap(String text , Bitmap ... bitmaps) {

        SpliceDrawableView spliceDrawableView = new SpliceDrawableView(ctx);
        Bitmap bitmap = spliceDrawableView.spliceBitmap(text,bitmaps);

        ImageView imageView1 = (ImageView) findViewById(R.id.iv1);
        imageView1.setImageBitmap(bitmap);

    }
}
