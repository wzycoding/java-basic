package com.wzy.concurrent.optionalusage;

import java.util.Optional;

/**
 * @author wzy
 * @version 1.0
 * @date 2022/7/9 4:44 下午
 */
public class OptionalDemo {

    public static class User {
        private Long id;
        private String name;

        public User(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main1(String[] args) {
        User user = null;

        if (user != null) {
            System.out.println(user.toString());
        }
    }

    public static void main(String[] args) {

        User user = null;
        Optional<User> userOptional = Optional.ofNullable(user);

        if (userOptional.isPresent()) {
            System.out.println(userOptional.get().toString());
        }

        User targetUser = null;

        userOptional.ifPresent(o -> System.out.println(o.toString()));

        targetUser = userOptional.orElse(new User(1L, "小明"));

        targetUser = userOptional.orElseThrow(RuntimeException::new);

        targetUser = userOptional.orElseGet(() -> new User(2L, "小李"));

        Integer nameLength = userOptional.map(o -> o.name).map(o -> o.length()).get();

        System.out.println(nameLength);
    }
}