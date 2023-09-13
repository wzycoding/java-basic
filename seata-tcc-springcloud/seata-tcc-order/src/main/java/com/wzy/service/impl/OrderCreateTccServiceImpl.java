package com.wzy.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.wzy.dao.OrderMapper;
import com.wzy.entity.Order;
import com.wzy.feign.AccountFeignClient;
import com.wzy.param.OrderCreateParam;
import com.wzy.service.OrderCreateTccService;
import io.seata.rm.tcc.api.BusinessActionContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wzy
 */
@Slf4j
@Service
public class OrderCreateTccServiceImpl implements OrderCreateTccService {
    @Resource
    private OrderMapper orderMapper;

    @Resource
    private AccountFeignClient accountFeignClient;

    @Override
    public Integer createOrder(BusinessActionContext businessActionContext, OrderCreateParam orderCreateParam) {
        // 创建订单
        Order order = new Order();

        order.setProductId(orderCreateParam.getProductId());
        order.setUserId(orderCreateParam.getPayAmount());
        order.setPayAmount(orderCreateParam.getPayAmount());
        order.setCount(orderCreateParam.getCount());

        Integer id = orderMapper.insert(order);
        orderCreateParam.setId(id);
        log.info("订单创建成功，id：{}", id);

        return id;
    }

    @Override
    public boolean commit(BusinessActionContext businessActionContext) {

        OrderCreateParam orderCreateParam = businessActionContext.getActionContext("orderCreateParam",
                OrderCreateParam.class);

        log.info("创建订单提交，订单信息:{}", JSON.toJSONString(orderCreateParam));
        return true;
    }

    @Override
    public boolean rollback(BusinessActionContext businessActionContext) {
        OrderCreateParam orderCreateParam = businessActionContext.getActionContext("orderCreateParam",
                OrderCreateParam.class);
        LambdaQueryWrapper<Order> queryWrapper = new LambdaQueryWrapper<>();

        queryWrapper.eq(Order::getId, orderCreateParam.getId());

        orderMapper.delete(queryWrapper);

        log.info("创建订单回滚，订单信息:{}", JSON.toJSONString(orderCreateParam));

        return true;
    }
}
