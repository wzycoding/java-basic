package com.wzy.concurrent.threadpool;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池基本用法
 *
 * @author wzy
 * @version 1.0
 * @date 2022/6/28 6:49 下午
 */
public class SimpleThreadPoolExecutor {
    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                10, 20, 30, TimeUnit.SECONDS, new LinkedBlockingDeque<>(2));

        while (true) {
            threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("当前线程名称：" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            Thread.sleep(10);
        }
    }
}