package com.xy.robolectric.net.concrete;

import com.xy.robolectric.bean.Login;
import com.xy.robolectric.bean.User;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ConcreteApi {

    String BASE_URL = "http://39.97.253.40/";

//    @GET("users/{username}")
//    Observable<User> getUser(@Path("username") String username);

    /**
     *  登录
     */
    @POST("rbac/api/user/login")
    Observable<Login>  login(@Body RequestBody body);
}
