package com.wzy.nullexception;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串、数组、集合在使用时出现空指针
 *
 * @author wzy
 * @version 1.0
 * @date 2022/7/4 11:46 上午
 */
public class BasicUsageNpe {

    private static boolean stringEqual(String x, String y) {
        return x.equals(y);
    }

    public static class User {
        public String name;
        public String[] address;

        public String readBook() {
            System.out.println("User Read Imooc Escape");
            return null;
        }
    }

    public static void main(String[] args) {
        // 第一种，字符串使用equals
//        System.out.println(stringEqual("xyz", null));
//        System.out.println(stringEqual(null, "xyz"));
        // 第二种，对象数组new出来了，没有初始化，一样会报空指针
//        User[] users = new User[10];
//        users[0].readBook();

        // 第三种 List对象addAll 传递null会抛出空指针
        List<User> userList = new ArrayList<>();
        User user = null;

        List<User> userList_ = null;

        userList.add(user);
        userList.addAll(userList_);
    }
}