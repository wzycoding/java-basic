package com.wzy.guava.limiter;

import com.google.common.util.concurrent.RateLimiter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RateLimiterMain {
    public static RateLimiter rateLimiter = RateLimiter.create(2);

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (true) {
                if (rateLimiter.tryAcquire()) {
                    System.out.println("线程1执行成功-" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                if (rateLimiter.tryAcquire()) {
                    System.out.println("线程2执行成功-" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}
