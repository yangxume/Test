package com.xy.t_load_image;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

/**
*https://www.jianshu.com/p/c68a3b9ca07a
*/
public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private ImageView imageview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageview = findViewById(R.id.imageView);

        baseUser();
    }

    private void baseUser() {

        String imageUrl = "https://hd.okjiaoyu.cn/hd_1c1lvUDAfpC.jpg";

        Picasso.get().load(imageUrl)
                .error(R.mipmap.ic_launcher)
                .placeholder(R.mipmap.ic_launcher_round)
                .transform(new CircleTransform(getApplicationContext()))
                .into(imageview, new Callback() {
                    @Override
                    public void onSuccess() {
                        Log.d(TAG, "onSuccess: ");
                    }

                    @Override
                    public void onError(Exception e) {
                        Log.e(TAG, "onError: " + e.getMessage());
                    }
                });
    }


}
