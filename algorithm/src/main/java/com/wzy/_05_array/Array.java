package com.wzy._05_array;

import java.util.Arrays;

/**
 * 实现一个简易的基于数组的list
 * 1) 数组的插入、删除、按照下标随机访问操作；
 * 2）数组中的数据是int类型的；
 */
public class Array {
    /**
     * 保存元素的数组
     */
    private int[] data;
    /**
     * 定义数组长度
     */
    private int n;
    /**
     * 当前数组中有多少个元素
     */
    private int count;

    public Array(int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }

    public int find(int index) {
        if (index < 0 || index >= n) {
            return -1;
        }
        return data[index];
    }

    public boolean insert(int index, int value) {
        // 如果数组元素已经满了，则直接返回
        if (count == n) {
            System.out.println("数组插入元素已满");
            return false;
        }

        if (index < 0 || index > count) {
            System.out.println("数组插入元素位置不合法");
            return false;
        }

        // 否则需要移动元素位置,从前往后移动，空出插入元素的位置
        for (int i = count; i > index; i--) {
            this.data[i] = this.data[i - 1];
        }
        this.data[index] = value;
        count++;

        return true;
    }

    public boolean delete(int index) {
        if (index < 0 || index > count) {
            System.out.println("数组插入元素索引不合法");
            return false;
        }

        // 从后往前移动
        for (int i = index + 1; i < count; i++) {
            this.data[i - 1] = data[i];
        }
        // 删除数组最后一个元素
        data[count - 1] = 0;
        // 元素个数
        count--;
        return true;
    }

    @Override
    public String toString() {
        return "Array{" +
                "data=" + Arrays.toString(data) +
                ", n=" + n +
                ", count=" + count +
                '}';
    }

    public static void main(String[] args) {
        Array array = new Array(10);

        array.insert(0, 1);
        array.insert(1, 2);
        array.insert(2, 3);
        array.insert(3, 4);
        array.insert(4, 5);
        array.insert(5, 6);
        array.insert(6, 7);
        array.insert(7, 8);

        System.out.println(array);
        System.out.println(array.find(6));

        array.delete(5);

        System.out.println(array);
        array.insert(0, 10);
        System.out.println(array);
    }
}
