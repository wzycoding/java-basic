package com.wzy.concurrent.thread;

import java.util.concurrent.*;

/**
 * 线程创建的五种方式
 * 1、实现Runnable接口
 * 2、FutureTask内部传入Callable接口，并提交到线程池
 * 3、直接创建线程池，将Runnable接口对象提交到线程池
 * 4、继承Thread类，覆盖run方法
 * 5、CompletableFuture异步非阻塞方法，如果不指定线程池，则使用公用线程池
 * <p>
 * <p>
 * 使用Thread类线程，线程的六种状态
 * 1、NEW(初始化)
 * 2、RUNNABLE(运行)
 * 3、BLOCKED(阻塞)
 * 4、WAITING(等待)
 * 5、TIME_WAITING(超时等待)
 * 6、TERMINATED(终止)
 *
 * @author wzy
 * @date 2023-09-16 10:24:08
 */
@SuppressWarnings("all")
public class ThreadCreate {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1、实现Runnable接口创建线程
        Thread thread1 = new Thread(() -> {
            System.out.println("Task 1当前时间戳是：" + System.currentTimeMillis());
        });

        thread1.start();

        // 2、FutureTask创建线程
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        FutureTask futureTask = new FutureTask(() -> {
            long currentTimeMillis = System.currentTimeMillis();
            System.out.println("Task 2当前时间戳是：" + currentTimeMillis);
            return currentTimeMillis;
        });

        executorService.submit(futureTask);

        long currentTimeMillis = (long) futureTask.get();
        System.out.println("Task 2返回的结果：" + currentTimeMillis);
        executorService.shutdown();

        // 3、创建线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20,
                10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10));

        threadPoolExecutor.submit(() -> {
            System.out.println("Task 3当前时间戳是：" + System.currentTimeMillis());
        });

        Thread.sleep(1000L);
        threadPoolExecutor.shutdown();

        // 4、自己继承线程类，这个很少用
        CustomThread customThread = new CustomThread();
        customThread.start();

        // 5、使用CompletableFuture类
        CompletableFuture completableFuture = CompletableFuture.runAsync(() -> {
            System.out.println("Task 5当前时间戳是：" + System.currentTimeMillis());
        });
    }

    public static class CustomThread extends Thread {
        @Override
        public void run() {
            System.out.println("Task 4当前时间戳是：" + System.currentTimeMillis());
        }
    }
}
