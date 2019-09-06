package com.xy.t_net;

import com.google.gson.JsonObject;
import com.xy.t_net.retro_okhttp.ApiService;
import com.xy.t_net.retro_okhttp.RetrofitClient;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLog;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class,sdk = 24)
public class RetrofitOkHttpTest {

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

        RetrofitClient.getInstance().create(ApiService.class)
                .login(params)
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

    @Test
    public void register(){

        JsonObject params = new JsonObject();
        params.addProperty("username","test1");
        params.addProperty("password","test1");
        params.addProperty("repassword","test1");

        RetrofitClient.getInstance().create(ApiService.class)
                .register(params)
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
}