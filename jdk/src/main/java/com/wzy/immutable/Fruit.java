package com.wzy.immutable;

import java.lang.reflect.Field;

/**
 * @author wzy
 * @version 1.0
 * @date 2022/6/30 3:40 下午
 */
public class Fruit {
    private final String name = "甜点";

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Fruit fruit = new Fruit();

        Field nameField = fruit.getClass().getDeclaredField("name");

        nameField.setAccessible(true);
        nameField.set(fruit, "蔬菜");

        System.out.println(fruit);

    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                '}';
    }
}