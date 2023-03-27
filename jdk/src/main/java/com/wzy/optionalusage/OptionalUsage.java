package com.wzy.optionalusage;

import java.util.Optional;

/**
 * @author wzy
 * @version 1.0
 * @date 2022/7/5 2:17 下午
 */
public class OptionalUsage {

    public static class User {
        private String name;

        public String getName() {
            return name;
        }
    }

    private static void isUserEqualNull() {

        User user = null;
        Optional<User> optional = Optional.empty();
        if (user != null) {
            System.out.println("User is not null");
        } else {
            System.out.println("User is null");
        }

        if (optional.isPresent()) {
            System.out.println("User is not null");
        } else {
            System.out.println("User is null");
        }
    }

    public static void main(String[] args) {
        // 没有意义的使用方法
        isUserEqualNull();

        User user = null;

        Optional<User> optionalUser = Optional.ofNullable(user);
        // 存在即返回，空则提供默认值
        optionalUser.orElse(new User());
        // 存在即返回，空则由函数去产生
        optionalUser.orElseGet(() -> anonymous());
        // 存在即返回，否则抛出异常
        optionalUser.orElseThrow(RuntimeException::new);

        // 存在才做相应处理
        optionalUser.ifPresent(u -> System.out.println(u.getName()));

        // map 可以对Optional中的对象执行某种操作，且会返回一个Optional对象
        optionalUser.map(u -> u.getName()).orElse("anonymous");

        // map可以无限级联的
        optionalUser.map(u -> u.getName()).map(name -> name.length()).orElse(0);


    }

    private static User anonymous() {
        return new User();
    }
}