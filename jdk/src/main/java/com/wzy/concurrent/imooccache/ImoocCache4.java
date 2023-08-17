package com.wzy.concurrent.imooccache;

import com.wzy.concurrent.imooccache.compute.Computable;
import com.wzy.concurrent.imooccache.compute.ExpensiveFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * 缩小了锁的范围，但是依然线程不安全，多线程读取，读取的值可能会错乱
 *
 * @author wzy
 * @version 1.0
 * @date 2022/7/2 9:23 上午
 */
public class ImoocCache4<A, V> implements Computable<A, V> {

    private final Map<A, V> cache = new HashMap<>();

    private final Computable<A, V> c;

    public ImoocCache4(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws Exception {
        System.out.println("进入缓存机制");
        V result = cache.get(arg);

        if (result == null) {
            result = c.compute(arg);
            synchronized (this) {
                cache.put(arg, result);
            }
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        ImoocCache4<String, Integer> cache = new ImoocCache4<>(new ExpensiveFunction());

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