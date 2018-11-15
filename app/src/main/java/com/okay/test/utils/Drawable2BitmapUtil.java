package com.okay.test.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/1/18 15:25
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */

public class Drawable2BitmapUtil {

//    通过 BitmapFactory 中的 decodeResource 方法，将资源文件中的 R.drawable.ic_drawable 转化成Bitmap
    public static Bitmap drawable2BitmapByBitmapFactory(Context ctx,int drawableId){

        Resources resources = ctx.getResources();
        Bitmap bitmap = BitmapFactory.decodeResource(resources, drawableId);

        return bitmap;
    }
//    将 Drable 对象先转化成 BitmapDrawable ，然后调用 getBitmap 方法 获取
    public static Bitmap drawable2BitmapByBitmapDrawable(Context ctx,int drawableId){

        Drawable drawable = ContextCompat.getDrawable(ctx, drawableId);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;

        return bitmapDrawable.getBitmap();

    }
//    根据已有的Drawable创建一个新的Bitmap
    public static Bitmap drawable2BitmapByCanvas(Context ctx,int drawableId){

        Drawable drawable = ContextCompat.getDrawable(ctx, drawableId);
        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();

        Bitmap.Config config = drawable.getOpacity() != PixelFormat.OPAQUE ?
                Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;

        Bitmap bitmap = Bitmap.createBitmap(width, height, config);
        //注意，下面三行代码要用到，否则在View或者SurfaceView里的canvas.drawBitmap会看不到图
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0,0,width,height);
        drawable.draw(canvas);

        return bitmap;

    }

    public static Drawable Bitmap2Drawable(Context ctx,Bitmap bitmap){

        Resources resources = ctx.getResources();
        Drawable drawable = new BitmapDrawable(resources, bitmap);

        return drawable;
    }


}
