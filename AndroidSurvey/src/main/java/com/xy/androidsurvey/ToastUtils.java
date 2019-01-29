package com.xy.androidsurvey;

import android.content.Context;
import android.widget.Toast;

class ToastUtils {
    public static void showLong(Context ctx, String msg) {

        Toast.makeText(ctx,msg,Toast.LENGTH_LONG).show();

    }

    public static void show(Context ctx, String msg) {
        Toast.makeText(ctx,msg,Toast.LENGTH_SHORT).show();

    }
}
