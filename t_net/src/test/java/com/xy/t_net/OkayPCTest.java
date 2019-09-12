package com.xy.t_net;

import com.google.gson.JsonObject;
import com.xy.t_net.retro_okhttp.ApiServicePC;
import com.xy.t_net.retro_okhttp.ApiServiceWanAndroid;
import com.xy.t_net.retro_okhttp.RetrofitClient;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLog;

import java.io.IOException;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class,sdk = 24)
public class OkayPCTest {

    @Before
    public void setUp(){

        ShadowLog.stream = System.out;
        initRxJava2();

    }

    private void initRxJava2() {

        RxJavaPlugins.reset();
        RxJavaPlugins.setIoSchedulerHandler(new Function<Scheduler, Scheduler>() {
            @Override
            public Scheduler apply(Scheduler scheduler) throws Exception {
                return Schedulers.trampoline();
            }
        });

        RxAndroidPlugins.reset();
        RxAndroidPlugins.setMainThreadSchedulerHandler(new Function<Scheduler, Scheduler>() {
            @Override
            public Scheduler apply(Scheduler scheduler) throws Exception {
                return Schedulers.trampoline();
            }
        });

    }


    @Test
    public void login(){

        JsonObject params = new JsonObject();
        params.addProperty("username","xuyang");
        params.addProperty("password","Xu_Yang011502");

        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), params.toString());


        RetrofitClient.getInstance().create(ApiServicePC.class)
                .login(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JsonObject>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JsonObject user) {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    private String getLoginParams(){

        String json = "";

        return json;

    }


}