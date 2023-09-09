package com.wzy.service;

import com.wzy.param.OrderCreateParam;

public interface OrderService {
    /**
     * 创建订单
     */
    int createOrder(OrderCreateParam orderCreateParam);
}
