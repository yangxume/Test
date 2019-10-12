package com.xy.t_eventbus;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * @Author: yangxume@gmail.com
 * @Time: 2019-10-08 15:58
 * @Desc:
 */
public class MessageEvent {

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event){

    }


}
