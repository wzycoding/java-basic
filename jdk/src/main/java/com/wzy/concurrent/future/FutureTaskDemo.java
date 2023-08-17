package com.wzy.concurrent.future;

import java.util.concurrent.*;

/**
 * @author wzy
 * @version 1.0
 * @date 2022/7/1 10:40 上午
 */
public class FutureTaskDemo {

    public static void main(String[] args) {
        Task task = new Task();

        FutureTask<Integer> integerFutureTask = new FutureTask<>(task);

//        new Thread(integerFutureTask).start();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.submit(integerFutureTask);
        try {
            Integer integer = integerFutureTask.get();

            System.out.println("task 运行结果：" + integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


}

class Task implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("子线程正在计算");
        Thread.sleep(3000);

        int sum = 0;

        for (int i = 0; i < 100; i++) {
            sum += i;
        }

        return sum;
    }
}