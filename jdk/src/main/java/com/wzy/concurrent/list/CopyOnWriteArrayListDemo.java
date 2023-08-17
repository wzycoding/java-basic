package com.wzy.concurrent.list;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author wzy
 * @version 1.0
 * @date 2022/7/4 2:16 下午
 */
public class CopyOnWriteArrayListDemo {
    public static void main(String[] args) {
        List<String> persons = new CopyOnWriteArrayList<>();

        persons.add("张三");
        persons.add("李四");
        persons.add("王五");

        Iterator<String> personIterator = persons.iterator();

        while (personIterator.hasNext()) {
            String currentElement = personIterator.next();
            if ("李四".equals(currentElement)) {
                persons.add("赵六");
            }
            System.out.println(currentElement);
        }

        System.out.println("实际persons中的元素：" + persons);
    }
}