package com.xy.t_net.retro_okhttp;

import com.google.gson.JsonObject;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * @Author: yangxume@gmail.com
 * @Time: 2019-09-11 17:46
 * @Desc:
 */
public interface ApiServicePC {

//    https://teacherpad-hotfix.xk12.cn/api/t_pad/user/login/

    /**
     *  登录
     */
    @POST("api/t_pad/user/login/")
    Observable<JsonObject> login(@Body RequestBody body);

    /**
     * 登出
     */
    @GET("user/logout")
    Observable<JsonObject> getLogout();

}
