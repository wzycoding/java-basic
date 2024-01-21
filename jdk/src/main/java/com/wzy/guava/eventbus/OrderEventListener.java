package com.wzy.guava.eventbus;

import com.google.common.eventbus.Subscribe;

public class OrderEventListener {
    @Subscribe
    public void dealWithEvent(OrderMessage event) {
        System.out.println("收到订单事件，内容：" + event);
    }
}
