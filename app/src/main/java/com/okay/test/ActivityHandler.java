package com.okay.test;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**参考：https://blog.csdn.net/guolin_blog/article/details/9991569
 * @ProjectName: Test
 * @Package: com.okay.test
 * @ClassName: ActivityHandler
 * @Description: java类作用描述
 * @Author: 作者名
 * @CreateDate: 2019-08-29 19:55
 * @UpdateUser: 更新者：
 * @UpdateDate: 2019-08-29 19:55
 * @UpdateRemark: 更新说明：
 * @Version: 1.0
 */
public class ActivityHandler extends AppCompatActivity {

    Handler handler1;
    Handler handler2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        create();

        sendMsg();

    }

    private void sendMsg() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                Message msg = new Message();
                msg.arg1 = 1;

                Bundle bundle = new Bundle();
                bundle.putInt("data",1);
                msg.setData(bundle);

                handler1.sendMessage(msg);
            }
        }).start();


    }

    private void create() {
        handler1 = new Handler();

        new Thread(new Runnable() {
            @Override
            public void run() {

                Looper.prepare();
                handler2 = new Handler();

            }
        }).start();
    }
}
