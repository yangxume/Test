package com.xy.robolectric.net.concrete;

import com.xy.robolectric.net.LoggingInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConcreteService {

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(ConcreteApi.BASE_URL)
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();

    public static ConcreteApi createApiServie(){
        return retrofit.create(ConcreteApi.class);
    }

    private static OkHttpClient getOkHttpClient() {

        return new OkHttpClient.Builder()
                .addInterceptor(new LoggingInterceptor())
                .build();
    }

}
