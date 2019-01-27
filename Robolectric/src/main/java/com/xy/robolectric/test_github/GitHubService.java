package com.xy.robolectric.test_github;

import com.xy.robolectric.test_github.bean.Repository;
import com.xy.robolectric.test_github.bean.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubService {

    String BASE_URL = "https://api.github.com/";

    @GET("users/{username}/repos")
    Call<List<Repository>> publicRepositories(@Path("username") String username);

    @GET("users/{username}/following")
    Call<List<User>> followingUser(@Path("username") String username);

    @GET("users/{username}")
    Call<User> user(@Path("username") String username);


    class Factory {
        public static GitHubService create() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retrofit.create(GitHubService.class);
        }
    }
}
