package com.wzy.concurrent.imooccache;

import com.wzy.concurrent.imooccache.compute.Computable;
import com.wzy.concurrent.imooccache.compute.ExpensiveFunction;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 利用Future避免重复计算
 *
 * @author wzy
 * @version 1.0
 * @date 2022/7/2 9:23 上午
 */
public class ImoocCache8<A, V> implements Computable<A, V> {

    private final Map<A, Future<V>> cache = new ConcurrentHashMap<>();

    private final Computable<A, V> c;

    public ImoocCache8(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws Exception {
        System.out.println("进入缓存机制");
        Future<V> f = cache.get(arg);

        if (f == null) {
            Callable<V> callable = new Callable<V>() {
                @Override
                public V call() throws Exception {
                    return c.compute(arg);
                }
            };

            FutureTask<V> ft = new FutureTask<>(callable);
            f = cache.putIfAbsent(arg, ft);

            if (f == null) {
                f = ft;
                System.out.println("从FutureTask获取缓存内容函数，获取的key：" + arg);
                ft.run();
            }

        }

        return f.get();
    }

    public static void main(String[] args) throws Exception {
        ImoocCache8<String, Integer> cache = new ImoocCache8<>(new ExpensiveFunction());

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