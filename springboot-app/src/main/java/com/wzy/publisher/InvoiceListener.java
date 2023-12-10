package com.wzy.publisher;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class InvoiceListener {
    @EventListener
    public void handleInvoice(PlaceOrderEvent placeOrderEvent) {
        log.info("发票监听器监听到下单消息：{}", JSON.toJSONString(placeOrderEvent));
    }
}
