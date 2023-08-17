package com.wzy.concurrent.imooccache;

import com.wzy.concurrent.imooccache.compute.Computable;
import com.wzy.concurrent.imooccache.compute.ExpensiveFunction;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 直接替换成线程安全的容器ConcurrentHashMap
 *
 * @author wzy
 * @version 1.0
 * @date 2022/7/2 9:23 上午
 */
public class ImoocCache6<A, V> implements Computable<A, V> {

    private final Map<A, V> cache = new ConcurrentHashMap<>();

    private final Computable<A, V> c;

    public ImoocCache6(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws Exception {
        System.out.println("进入缓存机制");
        V result = cache.get(arg);

        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        ImoocCache6<String, Integer> cache = new ImoocCache6<>(new ExpensiveFunction());

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Integer result = cache.compute("666");
                    System.out.println("第一次的结果：" + result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Integer result = cache.compute("667");
                    System.out.println("第二次的结果：" + result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Integer result = cache.compute("666");
                    System.out.println("第三次的结果：" + result);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}