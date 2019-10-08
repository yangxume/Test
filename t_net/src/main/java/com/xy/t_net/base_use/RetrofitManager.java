package com.xy.t_net.base_use;

import retrofit2.Retrofit;

/**
 * @Author: yangxume@gmail.com
 * @Time: 2019-09-27 15:54
 * @Desc:
 */
public class RetrofitManager {

    private RetrofitManager instance;



    public RetrofitManager getInstance(){

        if (null == instance){

            Retrofit.Builder builder = new Retrofit.Builder();

            Retrofit build = builder.build();


        }
        return instance;
    }


}
