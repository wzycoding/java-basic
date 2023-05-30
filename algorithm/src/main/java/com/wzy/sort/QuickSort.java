package com.wzy.sort;

/**
 * 快速排序
 *
 * @author wzy
 * @date 2023年05月31日00:23:16
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] intArray = {1, 4, 2, 6, 7, 8, 3, 5, 9, 0, 12};
        quickSort(intArray, intArray.length);
        printArray(intArray);
    }

    private static void quickSort(int[] intArray, int n) {

        quick_sort_c(intArray, 0, n - 1);
    }

    private static void quick_sort_c(int[] intArray, int p, int r) {
        if (p >= r) {
            return;
        }

        int q = partition(intArray, p, r);
        quick_sort_c(intArray, p, q - 1);
        quick_sort_c(intArray, q + 1, r);
    }

    private static int partition(int[] intArray, int p, int r) {

        int q = r;

        int i = p;
        for (int j = p; j < r; j++) {
            if (intArray[j] < intArray[q]) {
                int temp = intArray[i];
                intArray[i] = intArray[j];
                intArray[j] = temp;
                i++;
            }
        }
        int temp = intArray[q];
        intArray[q] = intArray[i];
        intArray[i] = temp;

        return i;
    }

    public static void printArray(int[] intArray) {
        for (int element : intArray) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
