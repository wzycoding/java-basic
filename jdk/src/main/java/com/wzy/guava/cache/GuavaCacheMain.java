package com.wzy.guava.cache;

import com.alibaba.fastjson.JSON;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.Data;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class GuavaCacheMain {
    /**
     * 用户本地缓存，缓存有效时间为5s
     */
    public static final LoadingCache<Long, User> userLocalCache = CacheBuilder.newBuilder()
            .expireAfterWrite(5, TimeUnit.SECONDS)
            .build(new CacheLoader<Long, User>() {
                @Override
                public User load(Long userId) {
                    return loadDbUserInfo(userId);
                }
            });

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        User userFirst = userLocalCache.get(1L);
        System.out.println("第1次加载用户信息缓存：" + JSON.toJSONString(userFirst));
        Thread.sleep(2000);
        User userSecond = userLocalCache.get(1L);
        System.out.println("第2次加载用户信息缓存：" + JSON.toJSONString(userSecond));
        Thread.sleep(4000);
        User userThird = userLocalCache.get(1L);
        System.out.println("第3次加载用户信息缓存：" + JSON.toJSONString(userThird));
    }

    @Data
    public static class User {
        private Long id;
        private String name;
        private Integer age;
    }

    /**
     * 模拟通过数据库获取用户信息
     *
     * @param userId 用户id
     * @return 用户信息
     */
    public static User loadDbUserInfo(Long userId) {
        System.out.println("查询db，获取用户id为: [" + userId + "]的用户信息");

        User user1 = new User();
        user1.setId(1L);
        user1.setName("张三");
        user1.setAge(18);

        User user2 = new User();
        user2.setId(2L);
        user2.setName("李四");
        user2.setAge(16);

        if (userId == 1L) {
            return user1;
        }

        if (userId == 2L) {
            return user2;
        }
        return null;
    }
}
