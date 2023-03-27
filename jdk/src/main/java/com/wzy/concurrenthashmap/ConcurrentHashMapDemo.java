package com.wzy.concurrenthashmap;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wzy
 * @version 1.0
 * @date 2022/7/1 3:23 下午
 */
public class ConcurrentHashMapDemo {
    public static void main(String[] args) {
        Map<String, Integer> ageMap = new ConcurrentHashMap<>();

        ageMap.put("zhangsan", 20);
        ageMap.put("lisi", 30);
        ageMap.put("wangwu", 18);

        System.out.println(ageMap.get("zhangsan"));
    }
}