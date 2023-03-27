package com.wzy.imooccache;

import com.wzy.imooccache.compute.ExpensiveFunction;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池去测试缓存性能
 *
 * @author wzy
 * @version 1.0
 * @date 2022/7/2 9:23 上午
 */
public class ImoocCache12 {

    public final static ImoocCache10<String, Integer> expensiveComputer = new ImoocCache10<>(
            new ExpensiveFunction()
    );

    public static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        // 10000个线程直接内存溢出
        ExecutorService service = Executors.newFixedThreadPool(100);

        long start = System.currentTimeMillis();

        for (int i = 0; i < 100; i++) {
            service.submit(() -> {
                Integer result = null;

                try {
                    System.out.println(Thread.currentThread().getName() + "开始等待");
                    latch.await();
                    System.out.println(Thread.currentThread().getName() + "被放行");
                    System.out.println(Thread.currentThread().getName() + "  放行时间：" + ThreadSafeFormatter.dateFormatter.get()
                            .format(new Date()));
                    result = expensiveComputer.compute("666");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

                System.out.println(result);
            });
        }
        Thread.sleep(5000);
        latch.countDown();
        service.shutdown();

//        service.shutdown();
//        while (!service.isTerminated()) {
//
//        }
//
//        System.out.println("总耗时：" + (System.currentTimeMillis() - start));
    }

}

class ThreadSafeFormatter {
    public static ThreadLocal<SimpleDateFormat> dateFormatter = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("mm:ss");
        }

        @Override
        public SimpleDateFormat get() {
            return super.get();
        }
    };

}
