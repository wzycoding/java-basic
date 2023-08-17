package com.wzy.concurrent.copyonwrite;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author wzy
 * @version 1.0
 * @date 2022/6/29 10:09 下午
 */
public class CopyOnWriteArrayListDemo {

//    public static void main(String[] args) {
//        List<String> names = new ArrayList<>();
//
//        names.add("wzy");
//        names.add("lisi");
//        names.add("zhaoliu");
//
//        Iterator<String> namesIterator = names.iterator();
//
//        while (namesIterator.hasNext()) {
//            System.out.println(namesIterator.next());
//            names.add("bob");
//        }
//    }

    public static void main(String[] args) {
        List<String> names = new CopyOnWriteArrayList<>();
        names.add("com/wzy");
        names.add("lisi");
        names.add("zhaoliu");
        Iterator<String> namesIterator = names.iterator();
        while (namesIterator.hasNext()) {
            System.out.println(namesIterator.next());
            names.add("bob");
        }

        System.out.println("最终集合内容：" + names);
    }
}