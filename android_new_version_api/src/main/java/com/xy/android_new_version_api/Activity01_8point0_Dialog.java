package com.xy.android_new_version_api;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Copyright
 * <p>
 * Created by xuyang on 18/8/16 11:41
 * <p>
 * email xuyangme@126.com
 * <p>
 * ${FILENAME}
 * <p>
 * Description
 * <p>
 * Update records:
 */
public class Activity01_8point0_Dialog extends AppCompatActivity {

    private Context ctx;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ctx = Activity01_8point0_Dialog.this;

        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M){

            if(Settings.canDrawOverlays(ctx)){

                startWindowDialogService(ctx);

            }else {
                Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
                Toast.makeText(ctx,"需要取得权限才能使用!",Toast.LENGTH_LONG).show();
                startService(intent);
            }

        }else{
            startWindowDialogService(ctx);
        }

    }

    private void startWindowDialogService(Context context){

        Intent intent = new Intent(context, WindowDialogService.class);
        startService(intent);
        finish();

    }
}
