package com.wzy.concurrent.imooccache.compute;

import java.util.concurrent.TimeUnit;

/**
 * 耗时(这个耗时指的是慢查询等操作)计算的实现类，实现了Computable接口，但是本身
 * 不具备缓存能力，不需要考虑缓存的事情。
 *
 * @author wzy
 * @version 1.0
 * @date 2022/7/2 9:21 上午
 */
public class ExpensiveFunction implements Computable<String, Integer> {
    @Override
    public Integer compute(String arg) throws Exception {
        TimeUnit.SECONDS.sleep(5);

        return new Integer(arg);
    }
}