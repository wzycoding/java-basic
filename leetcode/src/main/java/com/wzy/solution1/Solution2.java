package com.wzy.solution1;

public class Solution2 {

    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index + 1;
    }

    public static int removeElement1(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        int[] num1 = {0, 1, 2, 2, 3, 0, 4, 2};
        int[] num2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int i2 = removeElement(num1, 2);
        int i3 = removeElement1(num2, 2);

        for (int j1 : num1) {
            System.out.println(j1);
        }
        System.out.println("=====");
        for (int j2 : num2) {
            System.out.println(j2);
        }
        System.out.println("=====");
        System.out.println(num1.length);

    }
}
