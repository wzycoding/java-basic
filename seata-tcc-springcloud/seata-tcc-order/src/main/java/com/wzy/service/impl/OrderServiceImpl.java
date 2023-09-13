package com.wzy.service.impl;

import com.wzy.dao.OrderMapper;
import com.wzy.entity.Order;
import com.wzy.feign.AccountFeignClient;
import com.wzy.feign.param.AccountDeductParam;
import com.wzy.param.OrderCreateParam;
import com.wzy.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;

    @Resource
    private AccountFeignClient accountFeignClient;

    @Override
    public int createOrder(OrderCreateParam orderCreateParam) {


        // 1、 先扣减用户金额
        AccountDeductParam accountDeductParam = new AccountDeductParam();
        accountDeductParam.setUserId(orderCreateParam.getUserId());
        accountDeductParam.setAmount(orderCreateParam.getPayAmount());

        accountFeignClient.deductAmount(accountDeductParam);

        // 2、创建订单
        Order order = new Order();

        order.setProductId(orderCreateParam.getProductId());
        order.setUserId(orderCreateParam.getPayAmount());
        order.setPayAmount(orderCreateParam.getPayAmount());
        order.setCount(orderCreateParam.getCount());

        return orderMapper.insert(order);
    }
}
