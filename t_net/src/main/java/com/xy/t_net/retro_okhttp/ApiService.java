package com.xy.t_net.retro_okhttp;

import com.google.gson.JsonObject;


import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * @Author: yangxume@gmail.com
 * @Time: 2019-09-06 16:23
 * @Desc:
 */
public interface ApiService {

//    https://www.wanandroid.com/user/login

    @POST("user/login")
    Observable<JsonObject> login(@Body JsonObject jsonObject);

    @POST("user/login")
    Call<JsonObject> login2();
}
