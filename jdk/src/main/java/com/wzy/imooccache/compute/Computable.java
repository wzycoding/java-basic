package com.wzy.imooccache.compute;

/**
 * 有一个计算函数computer，用来代表耗时计算，
 * 每个计算器都要实现这个接口，这样可以无侵入实现缓存功能
 *
 * @author wzy
 * @version 1.0
 * @date 2022/7/2 9:16 上午
 */
public interface Computable<A, V> {

    V compute(A arg) throws Exception;

}