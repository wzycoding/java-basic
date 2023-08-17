package com.wzy.concurrent.future;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author wzy
 * @version 1.0
 * @date 2022/7/1 9:29 上午
 */
public class OneFutureLambada {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);

        Future<Integer> future = service.submit(() -> {
            Thread.sleep(3000);
            return new Random().nextInt();
        });

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        service.shutdown();

    }
}