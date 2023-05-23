package com.wzy.sort;

/**
 * 三个基本排序算法，冒泡排序，插入排序，选择排序
 *
 * @author wzy
 * @date 2023年05月17日12:45:44
 */
public class BaseSort {

    /**
     * 冒泡排序
     *
     * @param intArray 待排序的数组
     * @param n        数组长度
     */
    public static void bubbleSort(int[] intArray, int n) {
        // 第一个循环的i代表，当前已经排好了几个元素（几个元素是有序的）
        for (int i = 0; i < n; i++) {
            // 标志当前冒泡排序是否有交换
            boolean flag = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (intArray[j + 1] < intArray[j]) {
                    int temp = intArray[j];
                    intArray[j] = intArray[j + 1];
                    intArray[j + 1] = temp;
                    flag = true;
                }
            }
            // 没有数据交换说明数组有序了，直接停止循环
            if (!flag) {
                break;
            }
        }
    }

    /**
     * 插入排序
     *
     * @param intArray 待排序数组
     * @param n        数组长度
     */
    public static void insertionSort(int[] intArray, int n) {
        if (n <= 1) {
            return;
        }

        for (int i = 1; i < n; i++) {
            int value = intArray[i];
            int j = i - 1;
            // 查找插入的合适位置
            for (; j >= 0; --j) {
                if (intArray[j] > value) {
                    // 数据移动
                    intArray[j + 1] = intArray[j];
                } else {
                    break;
                }
            }
            // 插入数据
            intArray[j + 1] = value;
        }
    }

    /**
     * 插入排序
     *
     * @param intArray 数组
     * @param n        数组长度
     */
    public static void selectionSort(int[] intArray, int n) {

        if (n <= 1) {
            return;
        }
        for (int i = 1; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i; j < n; j++) {
                if (intArray[minIndex] > intArray[j]) {
                    minIndex = j;
                }
            }

            int temp = intArray[i];
            intArray[i] = intArray[minIndex];
            intArray[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        // 冒泡排序
        int[] intArray = {1, 4, 2, 6, 7, 8, 3, 5};
        bubbleSort(intArray, intArray.length);
        printArray(intArray);

        // 插入排序
        int[] intArray2 = {1, 4, 2, 6, 7, 8, 3, 5};
        insertionSort(intArray2, intArray.length);
        printArray(intArray2);

        // 选择排序
        int[] intArray3 = {1, 4, 2, 6, 7, 8, 3, 5};
        selectionSort(intArray3, intArray.length);
        printArray(intArray3);
    }

    public static void printArray(int[] intArray) {
        for (int element : intArray) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
