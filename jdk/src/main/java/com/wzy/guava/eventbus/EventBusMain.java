package com.wzy.guava.eventbus;

import com.google.common.eventbus.EventBus;

public class EventBusMain {

    public static void main(String[] args) {
        EventBus eventBus = new EventBus("orderEvent");
        //将监听器注册到eventBus
        eventBus.register(new OrderEventListener());
        //创建事件对象
        OrderMessage orderMessage = new OrderMessage();
        orderMessage.setMessage("创建了一个订单");
        //发布事件
        eventBus.post(orderMessage);
    }
}
