package com.wzy.solution1;

public class Solution4 {
    public static int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }

        int slow = 2;
        int fast = 2;
        while (fast < nums.length) {
            if (nums[fast] == nums[slow - 1] && nums[fast] == nums[slow - 2]) {
                fast++;
            } else {
                nums[slow] = nums[fast];
                slow++;
                fast++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3};

        int slow = removeDuplicates(nums);

        for (int num : nums) {
            System.out.println(num);
        }

        System.out.println(slow);
    }
}
