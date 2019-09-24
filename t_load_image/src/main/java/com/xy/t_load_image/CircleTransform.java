package com.xy.t_load_image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;

import com.squareup.picasso.Transformation;

public class CircleTransform implements Transformation {
    Context context;
    private boolean isRoundCorner; //true：圆角 false：圆形

    public CircleTransform(boolean isRoundCorner) {
        this.isRoundCorner = isRoundCorner;
    }

    public CircleTransform(Context context) {
        this.context = context;
    }

    @Override
    public Bitmap transform(Bitmap source) {
        if (isRoundCorner)
            return createRoundCornerImage(context, source);
        else
            return createCircleImage(source);
    }

    private Bitmap createCircleImage(Bitmap source) {
        int size = Math.min(source.getWidth(), source.getHeight());

        int x = (source.getWidth() - size) / 2;
        int y = (source.getHeight() - size) / 2;

        Bitmap squaredBitmap = Bitmap.createBitmap(source, x, y, size, size);
        if (squaredBitmap != source) {
            source.recycle();
        }

        Bitmap bitmap = Bitmap.createBitmap(size, size, source.getConfig());

        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        BitmapShader shader = new BitmapShader(squaredBitmap,
                BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP);
        paint.setShader(shader);
        paint.setAntiAlias(true);

        float r = size / 2f;
        canvas.drawCircle(r, r, r, paint);

        squaredBitmap.recycle();
        return bitmap;
    }

    /**
     * @param source
     * @return
     */
    private Bitmap createRoundCornerImage(Context context, Bitmap source) {
        Bitmap output = Bitmap.createBitmap(source.getWidth(),
                source.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, source.getWidth(), source.getHeight());
        final RectF rectF = new RectF(rect);
        //----------
        final float roundPx = context.getResources().getDimension(R.dimen.dp_20);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(source, rect, rect, paint);
        source.recycle();
        return output;
    }

    @Override
    public String key() {
        if (isRoundCorner)
            return "corner";
        return "circle";
    }
}
