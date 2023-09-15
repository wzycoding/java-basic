package com.wzy.concurrent.thread;

/**
 * 使用Thread类线程
 * 1、NEW(初始化)
 * 2、RUNNABLE(运行)
 * 3、BLOCKED(阻塞)
 * 4、WAITING(等待)
 * 5、TIME_WAITING(超时等待)
 * 6、TERMINATED(终止)
 *
 * @author wzy
 * @version 1.0
 * @date 2022/6/24 11:47 上午
 */
@SuppressWarnings("all")
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