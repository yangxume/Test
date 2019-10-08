package com.xy.t_net;

import com.google.gson.JsonObject;
import com.xy.t_net.retro_okhttp.ApiServicePC;
import com.xy.t_net.retro_okhttp.HeaderInterceptor;
import com.xy.t_net.retro_okhttp.HttpLoggingInterceptor;
import com.xy.t_net.retro_okhttp.RetrofitClient;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLog;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.http.POST;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 24)
public class BaseUseTest {

    @Before
    public void setUp() {

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
    public void baseUse() {

        String base_url = "https://api.github.com/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .client(getOkHttpClient())
                .build();

        HttpService httpService = retrofit.create(HttpService.class);



    }


    public interface HttpService {

        @POST("octocat")
        Observer<JsonObject> octocat();
    }

    private OkHttpClient getOkHttpClient() {

        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();

        builder.addInterceptor(new HeaderInterceptor());
        builder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(3,TimeUnit.SECONDS);
        builder.writeTimeout(10,TimeUnit.SECONDS);
        builder.retryOnConnectionFailure(true);

        OkHttpClient okHttpClient = builder.build();

        return okHttpClient;
    }


}