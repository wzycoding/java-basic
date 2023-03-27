package com.wzy;

import com.wzy.publisher.LoginEvent;
import com.wzy.publisher.PlaceOrderEvent;
import com.wzy.utils.SpringContextHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ApplicationPublisherTest {

    @Test
    public void testPublishLoginEvent() {
        ApplicationContext applicationContext = SpringContextHolder.getApplicationContext();

        applicationContext.publishEvent(LoginEvent.builder()
                .username("wzy")
                .password("123456")
                .build()
        );
    }

    @Test
    public void testPublishPlaceOrderEvent() {
        ApplicationContext applicationContext = SpringContextHolder.getApplicationContext();

        applicationContext.publishEvent(PlaceOrderEvent.builder()
                .orderId(20220808221402L)
                .price(10000)
                .userId(1L)
                .build()
        );
    }
}
