package com.wzy.aqs;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * 自己用AQS实现一个简单的线程协作器
 *
 * @author wzy
 * @version 1.0
 * @date 2022/6/30 11:44 下午
 */
public class OneShotLatch {

    private final Sync sync = new Sync();

    public void await() {
        sync.acquireShared(0);
    }

    public void signal() {
        sync.releaseShared(0);
    }

    private class Sync extends AbstractQueuedSynchronizer {

        @Override
        protected boolean tryReleaseShared(int arg) {
            setState(1);
            return true;
        }

        @Override
        protected int tryAcquireShared(int arg) {
            return sync.getState() == 1 ? 1 : -1;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        OneShotLatch oneShotLatch = new OneShotLatch();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + ":尝试获取latch，获取失败就等待");
                    oneShotLatch.await();

                    System.out.println(Thread.currentThread().getName() + ":开闸放行，继续运行");
                }
            }).start();
        }

        Thread.sleep(5000);
        oneShotLatch.signal();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ":尝试获取latch，获取失败就等待");
                oneShotLatch.await();

                System.out.println(Thread.currentThread().getName() + ":开闸放行，继续运行");
            }
        }).start();

    }

}