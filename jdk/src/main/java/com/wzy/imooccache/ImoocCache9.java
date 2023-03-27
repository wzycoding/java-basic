package com.wzy.imooccache;

import com.wzy.imooccache.compute.Computable;
import com.wzy.imooccache.compute.MayFail;

import java.util.Map;
import java.util.concurrent.*;

/**
 * 利用Future避免重复计算
 *
 * @author wzy
 * @version 1.0
 * @date 2022/7/2 9:23 上午
 */
public class ImoocCache9<A, V> implements Computable<A, V> {

    public final Map<A, Future<V>> cache = new ConcurrentHashMap<>();

    private final Computable<A, V> c;

    public ImoocCache9(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException, ExecutionException {
        System.out.println("进入缓存机制");

        while (true) {
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

            try {
                return f.get();
            } catch (CancellationException e) {
                // 抛出异常会缓存错误的结果，抛出异常就应该移除
                System.out.println("被取消了");
                cache.remove(arg);
                throw e;
            } catch (InterruptedException e) {
                cache.remove(arg);
                throw e;
            } catch (ExecutionException e) {
                //这里需要重试，说明出错
                System.out.println("计算错误，进行重试");
                cache.remove(arg);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ImoocCache9<String, Integer> cache = new ImoocCache9<>(new MayFail());

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
        // 进行取消
//        Future<Integer> future = cache.cache.get("666");
//        future.cancel(true);
    }
}