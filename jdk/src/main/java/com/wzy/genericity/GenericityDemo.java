package com.wzy.genericity;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class GenericityDemo {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> integerList = new ArrayList<>();

        integerList.add(10);
        integerList.add(20);

        Method addMethod = integerList.getClass().getDeclaredMethod("add", Object.class);

        addMethod.invoke(integerList, "我爱你中国");

        System.out.println(integerList.toString());
    }
}
