package com.wzy.concurrent.imooccache.compute;

import java.io.IOException;

/**
 * @author wzy
 * @version 1.0
 * @date 2022/7/2 10:42 上午
 */
public class MayFail implements Computable<String, Integer> {
    @Override
    public Integer compute(String arg) throws Exception {
        double random = Math.random();

        if (random > 0.5) {
            throw new IOException("读取文件出错");
        }

        Thread.sleep(3000);
        return Integer.valueOf(arg);
    }
}