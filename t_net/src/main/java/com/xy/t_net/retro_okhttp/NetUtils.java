package com.xy.t_net.retro_okhttp;

import com.google.gson.JsonObject;

import io.reactivex.Observable;

/**
 * @Author: yangxume@gmail.com
 * @Time: 2019-09-10 11:46
 * @Desc:
 */
public class NetUtils {

    public void login(){

        JsonObject jsonObject = new JsonObject();

        Observable<JsonObject> login = RetrofitClient.getInstance().create(ApiServiceWanAndroid.class)
                .login(jsonObject);


    }

}
