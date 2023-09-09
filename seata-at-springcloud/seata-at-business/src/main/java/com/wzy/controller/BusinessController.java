package com.wzy.controller;

import com.wzy.param.MakeOrderParam;
import com.wzy.service.BusinessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@RequestMapping("/business/inter")
public class BusinessController {

    @Resource
    private BusinessService businessService;

    @PostMapping("/makeOrder")
    public String makeOrder(@RequestBody MakeOrderParam makeOrderParam) {
        return businessService.makeOrder(makeOrderParam);
    }
}
