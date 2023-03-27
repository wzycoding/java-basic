package com.wzy;

import redis.clients.jedis.Jedis;

/**
 * @author wzy
 * @version 1.0
 * @date 2022/7/7 9:27 上午
 */
public class JedisDemo1 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        String value = jedis.ping();

        System.out.println(value);
    }
}