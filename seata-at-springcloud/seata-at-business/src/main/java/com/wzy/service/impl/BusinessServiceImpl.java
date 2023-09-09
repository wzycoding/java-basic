package com.wzy.service.impl;

import com.wzy.feign.OrderFeignClient;
import com.wzy.feign.StockFeignClient;
import com.wzy.feign.param.OrderCreateParam;
import com.wzy.feign.param.StockDeductParam;
import com.wzy.param.MakeOrderParam;
import com.wzy.service.BusinessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wzy
 */
@Slf4j
@Service
public class BusinessServiceImpl implements BusinessService {

    @Resource
    private StockFeignClient stockFeignClient;
    @Resource
    private OrderFeignClient orderFeignClient;

    @Override
    public String makeOrder(MakeOrderParam makeOrderParam) {

        // 1、先扣减库存
        StockDeductParam stockDeductParam = new StockDeductParam();

        stockDeductParam.setProductId(makeOrderParam.getProductId());
        stockDeductParam.setCount(makeOrderParam.getCount());

        stockFeignClient.deductCount(stockDeductParam);

        // 2、创建订单
        OrderCreateParam orderCreateParam = new OrderCreateParam();
        BeanUtils.copyProperties(makeOrderParam, orderCreateParam);
        orderFeignClient.createOrder(orderCreateParam);

        return "SUCCESS";
    }
}
