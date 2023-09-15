package com.wzy.concurrent.threadpool;

import java.util.concurrent.*;

/**
 * 线程池顺序执行任务
 *
 * @author wzy
 * @date 2023年09月15日14:25:38
 */
public class OrderedExecThreadPoolExecutor {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        singleThreadPoolExecutor();
        scheduleThreadPoolExecutor();
    }

    private static void scheduleThreadPoolExecutor() throws ExecutionException, InterruptedException {

        Runnable task1 = () -> {
            System.out.println("执行task1");
        };

        Runnable task2 = () -> {
            System.out.println("执行task2");
        };

        Runnable task3 = () -> {
            System.out.println("执行task3");
        };

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        ScheduledFuture<?> future1 = executor.schedule(task1, 0, TimeUnit.MILLISECONDS);
        future1.get();
        ScheduledFuture<?> future2 = executor.schedule(task2, 0, TimeUnit.MILLISECONDS);
        future2.get();
        ScheduledFuture<?> future3 = executor.schedule(task3, 0, TimeUnit.MILLISECONDS);
        future3.get();
        System.out.println("main 线程执行结束，关闭线程池");
        executor.shutdown();

    }

    /**
     * 单线程保证线程池顺序执行
     *
     * @throws InterruptedException e
     */
    private static void singleThreadPoolExecutor() throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Runnable task1 = () -> {
            System.out.println("执行task1");
        };

        Runnable task2 = () -> {
            System.out.println("执行task2");
        };

        Runnable task3 = () -> {
            System.out.println("执行task3");
        };

        executorService.submit(task1);
        executorService.submit(task2);
        executorService.submit(task3);

        Thread.sleep(1000);
        System.out.println("main 线程执行结束，关闭线程池");
        executorService.shutdown();
    }

}
