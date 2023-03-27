package com.wzy.publisher;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoginCounterListener {

    @EventListener
    public void handleLoginCounter(LoginEvent loginEvent) {
        log.info("登录次数监听器监听到登录消息：{}", JSON.toJSONString(loginEvent));
    }
}
