package com.wzy.solution1;

public class Solution1 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length < nums2.length) {
            return;
        }

        int nums2Index = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (nums2Index >= n) {
                return;
            }
            System.out.println(i + ", " + nums2Index);
            if (nums1[i] < nums2[nums2Index]) {
                continue;
            } else {
                // 从当前元素后移动一个位置
                move(nums1, i);
                nums1[i] = nums2[nums2Index];
                nums2Index++;
                m++;
            }
        }

        // 把num2剩余的元素移动过来
        for (int i = nums2Index; i < n; i++) {
            nums1[m++] = nums2[i];
        }
    }

    public static void move(int[] nums1, int moveIndex) {
        for (int i = nums1.length - 1; i > moveIndex; i--) {
            nums1[i] = nums1[i - 1];
        }
    }

    public static void main(String[] args) {
        int[] num1 = new int[]{2, 0};
        int[] num2 = new int[]{1};
        merge(num1, 1, num2, 1);

//        move(num1, 1);

        for (int i : num1) {
            System.out.println(i);
        }
    }
}
