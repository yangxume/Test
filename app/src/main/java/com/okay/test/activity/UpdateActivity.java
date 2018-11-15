package com.okay.test.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;


/**
 * @Copyright (C), 2011-2012, 北京国电通网络技术有限公司.
 * @FileName
 * @Author yang.xu
 * @Version
 * @Date 2016/12/21
 * @Description:
 */

public class UpdateActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

//        配置更新库功能
//        final UpdaterConfiguration config = new UpdaterConfiguration();

//        config.updateChecker(new UpdateChecker() {
//            @Override
//            public void check(UpdateCheckCallback callback) {
//                //此处模拟更新信息获取,信息获取后需要将UpdateInfo设置到配置信息中，然后要调用相应的回调方法才能使整个流程完整执行
//                UpdateInfo updateInfo = new UpdateInfo();
//                updateInfo.setVersionCode(2);
//                updateInfo.setVersionName("v1.2");
//                updateInfo.setUpdateTime("2016/10/28");
//                updateInfo.setUpdateSize(1024);
//                updateInfo.setUpdateInfo("更新日志:\n1.新增万能更新库，实现更新功能只要几行代码。");
//                //使用全量更新信息
//                updateInfo.setUpdateType(UpdateInfo.UpdateType.TOTAL_UPDATE);
//                UpdateInfo.TotalUpdateInfo totalUpdateInfo = new UpdateInfo.TotalUpdateInfo();
//                totalUpdateInfo.setApkUrl("http://wap.apk.anzhi.com/data2/apk/201609/05/f06abcb0e2cba4c8ce2301c4b437a492_72932500.ap");
//                updateInfo.setTotalUpdateInfo(totalUpdateInfo);
//                if (updateInfo != null) {
//                    //设置更新信息，这样各模块就可以通过config.getUpdateInfo()共享这个数据了,注意这个方法一定要调用且要在UpdateCheckCallback.onCheckSuccess之前调用
//                    config.updateInfo(updateInfo);
//                    callback.onCheckSuccess();
//                } else {
//                    callback.onCheckFail("");
//                }
//            }
//        });

//        UpdaterConfiguration config = new UpdaterConfiguration();
//        config.updateChecker(new UpdateCh(){
//
//            @Override
//            public void check(UpdateCheckCallback callback) {
//
//            }
//        });
//
////        启用更新检查功能
//        Updater.getInstance().init(config);
//
//        //此处的Context默认必须为Activity
//        Updater.getInstance().check(this);

    }

//    class My implements


}
