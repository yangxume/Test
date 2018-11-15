package okay.test.immersive;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Android沉浸式状态栏完全解析
 */
public class MainActivity extends AppCompatActivity {

    private View decorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        decorView = getWindow().getDecorView();

        /**
         *1.隐藏状态栏，
         */

//        final int systemUiFlagFullscreen = View.SYSTEM_UI_FLAG_FULLSCREEN;
//        decorView.setSystemUiVisibility(systemUiFlagFullscreen);


        /**
         * 2.透明状态栏-必须android 5.0以上才支持
         */
//        if (Build.VERSION.SDK_INT > 21) {
//
//            //让应用的主体内容占用系统状态栏的空间，
//            final int status_bar_transtant = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
//            decorView.setSystemUiVisibility(status_bar_transtant);
//            getWindow().setStatusBarColor(Color.TRANSPARENT);
//        }

        /**
         * 3.隐藏导航栏
         */
//        final int hide_navigation = View.SYSTEM_UI_FLAG_FULLSCREEN
//                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION;
//
//        decorView.setSystemUiVisibility(hide_navigation);


        /**
         * 4.状态栏和导航栏都透明
         */
//        if (Build.VERSION.SDK_INT >= 21) {
//
//            final int statusbar_navigation_transtant =
//                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION |
//                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
//            decorView.setSystemUiVisibility(statusbar_navigation_transtant);
//            getWindow().setStatusBarColor(Color.TRANSPARENT);
//            getWindow().setNavigationBarColor(Color.TRANSPARENT);
//        }

        /**
         * 隐藏actionbar
         */
        final ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.hide();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        if (Build.VERSION.SDK_INT > 19){

            final View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    |View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    |View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    |View.SYSTEM_UI_FLAG_FULLSCREEN
                    |View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    |View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
            );

        }

    }
}
