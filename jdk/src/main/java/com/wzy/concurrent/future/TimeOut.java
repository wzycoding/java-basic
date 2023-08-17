package com.wzy.concurrent.future;

import java.util.concurrent.*;

/**
 * 演示get的超时方法，需要注意超时后处理，调用cancel方法，演示cancel传入true和false的区别
 * 代表是否中断正在执行的任务
 *
 * @author wzy
 * @version 1.0
 * @date 2022/7/1 10:12 上午
 */
public class TimeOut {
    private static final Ad DEFAULT_AD = new Ad("无网络时候的默认广告");

    public static final ExecutorService exec = Executors.newFixedThreadPool(10);


    static class Ad {
        String name;

        public Ad(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Ad{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    static class FetchAdTask implements Callable<Ad> {

        @Override
        public Ad call() throws Exception {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("sleep 期间被中断了");
                return new Ad("被中断的默认广告");
            }

            return new Ad("旅游订票哪家强？找某程");

        }
    }

    public void printAd() {
        Future<Ad> f = exec.submit(new FetchAdTask());

        Ad ad;

        try {
            ad = f.get(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            ad = new Ad("被中断的默认广告");
            e.printStackTrace();
        } catch (ExecutionException e) {
            ad = new Ad("异常时的默认广告");
            e.printStackTrace();
        } catch (TimeoutException e) {
            ad = new Ad("超时默认广告");
            System.out.println("超时未获取广告");
            // 传入true把线程中断，收到中断信号，抛出InterruptedException
            // false程序会继续运行，会正常运行到结束，不会发出中断信号
            boolean cancel = f.cancel(false);
            System.out.println("cancel的结果" + cancel);
        }
        exec.shutdown();
        System.out.println(ad);
    }

    public static void main(String[] args) {
        TimeOut timeOut = new TimeOut();

        timeOut.printAd();
    }
}