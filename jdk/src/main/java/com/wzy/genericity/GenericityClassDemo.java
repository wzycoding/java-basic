package com.wzy.genericity;

/**
 * 泛型类例子
 *
 * @author wzy
 */
public class GenericityClassDemo {

    public interface CustomOptional<T> {
        /**
         * 判断是否为空
         *
         * @return 是否为空
         */
        boolean ifPresent();

        /**
         * 获取内部保存的对象
         *
         * @return 内部保存对象
         */
        T getObj();
    }

    public static class CustomOptionalImpl<T> implements CustomOptional<T> {
        public final T obj;

        public CustomOptionalImpl(T obj) {
            this.obj = obj;
        }

        public static <K> CustomOptionalImpl<K> of(K obj) {
            return new CustomOptionalImpl<>(obj);
        }

        @Override
        public boolean ifPresent() {
            return this.obj != null;
        }

        @Override
        public T getObj() {
            return this.obj;
        }
    }

    public static void main(String[] args) {
        User user = null;
        CustomOptional<User> userCustomOptional = CustomOptionalImpl.of(user);
        if (userCustomOptional.ifPresent()) {
            System.out.println("执行不为空逻辑");
        } else {
            System.out.println("执行为空的逻辑");
        }
    }

    public static class User {
        private String username;
        private Integer age;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }
    }
}
