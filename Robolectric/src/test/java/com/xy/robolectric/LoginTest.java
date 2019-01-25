package com.xy.robolectric;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

//1.constants = BuildConfig.class不加，会找不到资源文件
//2.最新版本的Robolectric不支持api为28的
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class,sdk = 26)
public class LoginTest {

    @Test
    public void testLogin(){

    }

    //测试的方法前面，一定要加@Test的注释
    @Test
    public void testActivity(){
        LoginActivity loginActivity = Robolectric.setupActivity(LoginActivity.class);
        Assert.assertNotNull(loginActivity);
    }


}
