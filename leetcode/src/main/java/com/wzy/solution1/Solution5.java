package com.wzy.solution1;

public class Solution5 {
    public static int majorityElement(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int middle = nums.length / 2;

        for (int i = 0; i < nums.length - 1; i++) {
            int elementNum = 1;
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] == nums[j]) {
                    elementNum++;
                }

                if (elementNum > middle) {
                    return nums[i];
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        int result = majorityElement(nums);
        System.out.println(result);
    }
}
