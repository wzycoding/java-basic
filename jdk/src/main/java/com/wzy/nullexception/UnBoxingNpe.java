package com.wzy.nullexception;

/**
 * 自动拆箱引发的空指针问题
 *
 * @author wzy
 * @version 1.0
 * @date 2022/7/4 11:12 上午
 */
public class UnBoxingNpe {

    private static boolean compare(long x, long y) {
        return x >= y;
    }

    public static void main(String[] args) {
        //1、变量赋值自动拆箱出现空指针
        Long count = null;
        long count_ = count;
//
//        //2、方法传参时自动拆箱引发的空指针
//        Integer left = null;
//        Integer right = null;
//
//        System.out.println(add(left, right));

        //3、用于大小比较场景
//        Long left = 10L;
//        Long right = null;
//        System.out.println(compare(left, right));
    }

    private static int add(int x, int y) {
        return x + y;
    }
}