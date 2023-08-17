package com.wzy.concurrent.future;

import java.util.concurrent.*;

/**
 * 演示get方法中抛出异常，for循环为了演示抛出Exception时机，
 * 并不是说一产生异常就抛出，直到我们get执行时才会抛出。
 *
 * @author wzy
 * @version 1.0
 * @date 2022/7/1 10:02 上午
 */
public class GetException {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(20);

        Future<Integer> future = service.submit(new CallableTask());

        try {

            for (int i = 0; i < 5; i++) {
                System.out.println(i);
                Thread.sleep(1000);
            }
            //只会打印是否完成，无论执行结果成功还是失败
            System.out.println(future.isDone());
            // 只有执行get的时候才会感知到异常抛出
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("InterruptedException异常");
        } catch (ExecutionException e) {
            e.printStackTrace();
            System.out.println("ExecutionException异常");
        }

        service.shutdown();
    }

    static class CallableTask implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {

            throw new IllegalArgumentException("callable抛出异常");
        }
    }
}