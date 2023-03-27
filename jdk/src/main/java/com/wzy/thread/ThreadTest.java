package com.wzy.thread;

/**
 * @author wzy
 * @version 1.0
 * @date 2022/6/24 11:47 上午
 */
public class ThreadTest {

    public static void attack() {
        System.out.println("Fight");
        System.out.println("Current Thread is: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                attack();
            }
        });

        System.out.println("current main thread is : " + Thread.currentThread().getName());
        t.start();

    }
}