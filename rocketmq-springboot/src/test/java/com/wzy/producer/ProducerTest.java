package com.wzy.producer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class ProducerTest {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Test
    public void sendMsg() {
        String msgInfo = "SpringBoot发出的消息：" + System.currentTimeMillis();
        log.info("发出消息内容：" + msgInfo);
        rocketMQTemplate.convertAndSend("TestTopic",
                msgInfo);
    }
}