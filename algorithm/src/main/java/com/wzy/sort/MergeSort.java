package com.wzy.sort;

/**
 * 归并排序
 *
 * @author wzy
 * @date 2023年05月24日20:46:26
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] intArray = {1, 4, 2, 6, 7, 8, 3, 5};
        mergeSort(intArray, intArray.length);
        printArray(intArray);
    }

    private static void mergeSort(int[] intArray, int n) {
        // [0, n-1]
        _mergeSort(intArray, 0, n - 1);
    }

    private static void _mergeSort(int[] intArray, int p, int r) {
        // 如果起点index小于等于终点，则直接返回，说明只有一个或者0个元素
        if (p >= r) {
            return;
        }

        // 找到中点
        int q = (p + r) / 2;

        // 对[p, q]进行排序
        _mergeSort(intArray, p, q);
        // 对[q+1, r]进行排序
        _mergeSort(intArray, q + 1, r);

        // 对两个有序的数组区间进行合并
        _merge(intArray, p, q, r);
    }

    private static void _merge(int[] intArray, int p, int q, int r) {
        // 创建临时数组进行归并
        int[] temp = new int[r - p + 1];

        int i = p;
        int j = q + 1;
        int k = 0;

        // 标记两段数组，分别用i和j表示，因为都是闭区间，所以都用了等号
        while (i <= q && j <= r) {
            // 让在前面的相等的元素还排在前面，这样就是一个稳定的排序算法了
            if (intArray[i] <= intArray[j]) {
                temp[k++] = intArray[i++];
            } else {
                temp[k++] = intArray[j++];
            }
        }

        // 将归并的两个区间，判断哪个有剩余元素，顺序放到临时数组
        int start = i;
        int end = q;

        if (j <= r) {
            start = j;
            end = r;
        }

        while (start <= end) {
            temp[k++] = intArray[start++];
        }

        int l = p;
        int m = 0;
        // 将排好序的临时数组中的元素覆盖回原数组
        while (m <= r - p) {
            intArray[l++] = temp[m++];
        }
    }

    public static void printArray(int[] intArray) {
        for (int element : intArray) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
