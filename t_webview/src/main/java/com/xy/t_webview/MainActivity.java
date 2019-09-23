package com.xy.t_webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webView = findViewById(R.id.webview);

        //打开本包内asset目录下的test.html文件
        webView.loadUrl(" file:///android_asset/t_agreement.html");
        //打开本地sd卡内的kris.html文件
//        webView.loadUrl("content://com.android.htmlfileprovider/sdcard/kris.html");
        //打开指定URL的html文件
//        webView.loadUrl("https://www.baidu.com");
    }
}
