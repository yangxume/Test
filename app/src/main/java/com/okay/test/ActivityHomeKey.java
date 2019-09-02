package com.okay.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @ProjectName: Test
 * @Package: com.okay.test
 * @ClassName: ActivityHomeKey
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2019-08-30 15:57
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019-08-30 15:57
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class ActivityHomeKey extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homekey);
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        return;
    }
}
