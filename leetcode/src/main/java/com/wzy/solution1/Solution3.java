package com.wzy.solution1;

public class Solution3 {
    public static int removeDuplicates(int[] nums) {
        int p = 1;
        
        for (int q = 1; q < nums.length; q++) {
            if (nums[p - 1] < nums[q]) {
                nums[p] = nums[q];
                p++;
            }
        }

        return p;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3, 4, 4, 5};

        int result = removeDuplicates(nums);

        System.out.println(result);

        for (int num : nums) {
            System.out.println(num);
        }
    }
}
