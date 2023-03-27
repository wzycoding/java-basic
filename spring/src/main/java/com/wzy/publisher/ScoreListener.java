package com.wzy.publisher;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ScoreListener {
    @EventListener
    public void handleScore(PlaceOrderEvent placeOrderEvent) {
        log.info("积分监听器监听到下单消息：{}", JSON.toJSONString(placeOrderEvent));
    }
}
