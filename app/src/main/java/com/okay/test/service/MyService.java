package com.okay.test.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * @ProjectName: Test
 * @Package: com.okay.test.service
 * @ClassName: MyService
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2019-09-03 10:38
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019-09-03 10:38
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class MyService extends Service {


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
