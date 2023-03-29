package com.wzy.genericity;

import java.util.ArrayList;
import java.util.List;

public class GenericityExtendsDemo {
    public static void main(String[] args) {
        List<Number> integerList = new ArrayList<>();

        integerList.add(1);
        integerList.add(2);
        integerList.add(3);

        print(integerList);
    }

    public static void print(List<? super Integer> numberList) {
//        Number result;
//        numberList.remove(1);
//        for (Number number : numberList) {
//            System.out.println(number);
//        }
    }
}
