package com.wzy.solution1;

public class Solution7 {
    public static int maxProfit(int[] prices) {
        int slow = 0;
        int fast = 1;
        int maxProfit = 0;
        for (; fast < prices.length; fast++) {
            int profit = prices[fast] - prices[slow];

            System.out.println("profit：" + profit);
            if (profit > maxProfit) {
                maxProfit = profit;
            }

            if (profit < 0) {
                System.out.println("slow=" + fast);
                slow = fast;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};

        System.out.println(maxProfit(prices));
    }
}
