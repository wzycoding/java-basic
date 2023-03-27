package com.wzy.concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wzy
 * @version 1.0
 * @date 2022/6/29 9:16 下午
 */
public class OptionsNotSafe implements Runnable {
    private static ConcurrentHashMap<String, Integer> scores = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {
        scores.put("小明", 0);
        Thread t1 = new Thread(new OptionsNotSafe());
        Thread t2 = new Thread(new OptionsNotSafe());

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(scores.get("小明"));
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Integer score = scores.get("小明");
            while (!scores.replace("小明", score, ++score)) {
                score = scores.get("小明");
            }

        }
    }
}