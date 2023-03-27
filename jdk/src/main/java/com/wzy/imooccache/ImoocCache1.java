package com.wzy.imooccache;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author wzy
 * @version 1.0
 * @date 2022/7/2 8:44 上午
 */
public class ImoocCache1 {
    private final HashMap<String, Integer> cache = new HashMap<>();

    public synchronized Integer computer(String userId) throws InterruptedException {
        Integer result = cache.get(userId);

        // 如果找不到，则重新计算，并保存到HashMap
        if (result == null) {
            result = doCompute(userId);
            cache.put(userId, result);
        }

        return result;
    }

    private Integer doCompute(String userId) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);

        return new Integer(userId);
    }

    public static void main(String[] args) throws InterruptedException {
        ImoocCache1 cache = new ImoocCache1();

        System.out.println("开始计算了");
        Integer result = cache.computer("13");
        System.out.println("第一次计算结果：" + result);

        result = cache.computer("13");
        System.out.println("第二次计算结果：" + result);
    }
}