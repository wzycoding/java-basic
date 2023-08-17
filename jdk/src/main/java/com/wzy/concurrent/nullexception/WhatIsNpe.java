package com.wzy.concurrent.nullexception;

/**
 * @author wzy
 * @version 1.0
 * @date 2022/7/4 10:38 上午
 */
public class WhatIsNpe {

    public static class User {
        public String name;
        public String[] address;

        public String readBook() {
            System.out.println("User Read Imooc Escape");
            return null;
        }
    }

    public static class CustomException extends RuntimeException {

    }

    public static void main(String[] args) {
//        User user = null;
        // 第一种访问空对象方法
//        user.readBook();

        //第二种访问空对象属性
//        System.out.println(user.name);

        //第三种访问未初始化的数组
//        System.out.println(user.address.length);

//        CustomException exception = null;
//        throw exception;

        //第五种方法返回结果是null直接使用
        User user = new User();
        String result = user.readBook();
        System.out.println(result.length());
    }
}