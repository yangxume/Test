//package com.xy.robolectric;
//
//import android.util.Log;
//
//import com.google.gson.Gson;
//import com.xy.robolectric.bean.Repository;
//import com.xy.robolectric.net.GithubApi;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.robolectric.RobolectricTestRunner;
//import org.robolectric.annotation.Config;
//
//import java.io.IOException;
//import java.util.List;
//
//import retrofit2.Call;
//import retrofit2.Response;
//
//@RunWith(RobolectricTestRunner.class)
//@Config(constants = BuildConfig.class,sdk = 26)
//public class GitHubTest {
//
//    private static final String TAG = GithubApi.class.getSimpleName();
//
//    @Test
//    public void publicRepositories() throws IOException {
//
//        GithubApi githubService = GithubApi.Factory.create();
//
//        Call<List<Repository>> call = githubService.publicRepositories("geniusmart");
//        Response<List<Repository>> execute = call.execute();
//
//        List<Repository> list = execute.body();
//        //可输出完整的响应结果，帮助我们调试代码
//        Log.d(TAG,new Gson().toJson(list));
//    }
//
//}
