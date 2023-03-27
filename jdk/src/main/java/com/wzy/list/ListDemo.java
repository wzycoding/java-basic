package com.wzy.list;

import java.util.ArrayList;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {
        List intList = new ArrayList();

        intList.add(1);
        intList.add("我爱你中国");

        for (Object item : intList) {
            System.out.println((int) item + 1);
        }
    }
}
