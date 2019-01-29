package com.xy.robolectric.net;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class GithubService {

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(GithubApi.BASE_URL)
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();

    public static GithubApi createApiServie(){
        return retrofit.create(GithubApi.class);
    }

    private static OkHttpClient getOkHttpClient() {

        return new OkHttpClient.Builder()
                .addInterceptor(new LoggingInterceptor())
                .build();
    }

}
