package com.wzy.imooccache;

import com.wzy.imooccache.compute.Computable;
import com.wzy.imooccache.compute.MayFail;

import java.util.Map;
import java.util.concurrent.*;

/**
 * 出于安全性考虑，缓存需要设置有效期，到期自动失效，
 * 否则如果缓存一直不失效，会造成缓存不一致的问题
 *
 * @author wzy
 * @version 1.0
 * @date 2022/7/2 9:23 上午
 */
public class ImoocCache11<A, V> implements Computable<A, V> {

    public final Map<A, Future<V>> cache = new ConcurrentHashMap<>();

    private final Computable<A, V> c;

    public ImoocCache11(Computable<A, V> c) {
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

    public final static ScheduledExecutorService executor =
            Executors.newScheduledThreadPool(5);

    public V compute(A arg, long expire) throws ExecutionException, InterruptedException {
        if (expire > 0) {
            executor.schedule(new Runnable() {
                @Override
                public void run() {
                    expire(arg);
                }
            }, expire, TimeUnit.MILLISECONDS);
        }

        return compute(arg);
    }

    /**
     * 随机设置缓存失效时间
     */
    public V computeRandomExpire(A arg) throws ExecutionException, InterruptedException {
        long randExpire = (long) (Math.random() * 10000);

        return compute(arg, randExpire);
    }

    public synchronized void expire(A key) {
        Future<V> future = cache.get(key);

        if (!future.isDone()) {
            System.out.println("Future任务被取消");
            future.cancel(true);
        }

        if (future != null) {
            System.out.println("过期时间到，缓存被清除");
            cache.remove(key);
        }
    }

    public static void main(String[] args) throws Exception {
        ImoocCache11<String, Integer> cache = new ImoocCache11<>(new MayFail());

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Integer result = cache.compute("666", 5000);
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

        Thread.sleep(6000L);

        //过期后缓存会被清除
        Integer result = cache.compute("666");
        System.out.println("主线程计算结果：" + result);


        // 进行取消
//        Future<Integer> future = cache.cache.get("666");
//        future.cancel(true);
    }
}