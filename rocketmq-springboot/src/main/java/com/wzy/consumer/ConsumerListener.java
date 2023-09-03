package com.wzy.consumer;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @author wzy
 */
@Slf4j
@Component
@RocketMQMessageListener(consumerGroup = "MySpringBootConsumerGroup", topic = "TestTopic")
public class ConsumerListener implements RocketMQListener<String> {
    @Override
    public void onMessage(String msgInfo) {
        log.info("消费者收到消息：{}", msgInfo);
    }
}
