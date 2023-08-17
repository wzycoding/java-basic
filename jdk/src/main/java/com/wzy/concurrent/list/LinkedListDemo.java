package com.wzy.concurrent.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wzy
 * @version 1.0
 * @date 2022/7/3 9:08 下午
 */
public class LinkedListDemo {

    public static void main(String[] args) {
        List<String> personList = new LinkedList<>();

        personList.add("张三");
        personList.add("汤姆");
        personList.add("杰瑞");

        Iterator<String> iterator = personList.iterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}