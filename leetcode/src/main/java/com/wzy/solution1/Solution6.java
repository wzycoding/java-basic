package com.wzy.solution1;

public class Solution6 {
    public static void rotate(int[] nums, int k) {
        int moveNum = k % nums.length;
        int[] resultNums = new int[nums.length];
        if (moveNum == 0) {
            return;
        }

        System.out.println("moveNum" + moveNum);

        for (int i = 0; i < nums.length; i++) {
            if (i + moveNum < nums.length) {
                resultNums[i + moveNum] = nums[i];
            } else {
                resultNums[i + moveNum - nums.length] = nums[i];
            }
        }
        System.arraycopy(resultNums, 0, nums, 0, resultNums.length);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);

        for (int num : nums) {
            System.out.println(num);
        }
    }
}
