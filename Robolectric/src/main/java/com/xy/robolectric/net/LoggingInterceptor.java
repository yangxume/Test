package com.xy.robolectric.net;

import android.text.TextUtils;
import android.util.Log;

import java.io.IOException;
import java.net.URLDecoder;
import java.security.spec.ECField;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoggingInterceptor implements Interceptor {

    private static final String TAG = LoggingInterceptor.class.getSimpleName();

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request request = chain.request();

        long startTime = System.currentTimeMillis();
        Response response = chain.proceed(chain.request());
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        MediaType mediaType = response.body().contentType();

        Log.d(TAG, "\n");
        Log.d(TAG, "----------Start----------------");
        Log.d(TAG, "| RequestUrl:" + request.url());
        Log.d(TAG, "| RequestHeaders:\n" + request.headers());

        String method = request.method();

        if ("POST" == method){
            StringBuilder sb = new StringBuilder();
            RequestBody body = request.body();

            if (body instanceof FormBody){
                int size = ((FormBody) body).size();
                for (int i = 0;i<size;i++){
                    sb.append(((FormBody) body).encodedName(i)+":");
                    if (TextUtils.isEmpty(((FormBody) body).encodedValue(i))){
                        Log.e(TAG,"参数为空");
                    }else{
                        URLDecoder.decode(((FormBody) body).encodedValue(i),"utf-8");
                    }
                    if (sb.length() != 0){
                        sb.delete(sb.length() -1 ,sb.length());
                    }
                    Log.d(TAG, "| RequestParams:\n");
                    try {
                        Log.d(TAG, "{" + sb.toString() + "}");
                    } catch (Exception e){
                        Log.d(TAG, "{" + sb.toString() + "}");
                    }
                }
            }
        }
        Log.d(TAG, "| ResponseHeaders:\n" + response.headers());
        String content = response.body().toString();
        try {
            Log.d(TAG, content);
        } catch (Exception e){
            Log.d(TAG, content);
        }
        Log.d(TAG, "----------End:" + duration + "毫秒----------");
        return response.newBuilder()
                .body(okhttp3.ResponseBody.create(mediaType, content))
                .build();
    }
}


