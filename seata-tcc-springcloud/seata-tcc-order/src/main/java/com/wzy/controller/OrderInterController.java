package com.wzy.controller;

import com.wzy.param.OrderCreateParam;
import com.wzy.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/order/inter")
public class OrderInterController {

    @Resource
    private OrderService orderService;

    @PostMapping("/createOrder")
    public Integer createOrder(@RequestBody OrderCreateParam orderCreateParam) {
        return orderService.createOrder(orderCreateParam);
    }
}
