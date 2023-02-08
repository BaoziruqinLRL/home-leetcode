package com.yyhome.leetcode.hard;

/**
 * 123 买卖股票的最佳时机
 * @Author: linabell
 * @Date: 2023/2/8 13:38:07
 */
public class MaxProfit123 {

    public static void main(String[] args) {
        System.out.println(new MaxProfit123().maxProfit(new int[]{1,2}));
        System.out.println(new MaxProfit123().maxProfit(new int[]{3,3,5,0,0,3,1,4}));
        System.out.println(new MaxProfit123().maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(new MaxProfit123().maxProfit(new int[]{7,6,4,3,1}));
        System.out.println(new MaxProfit123().maxProfit(new int[]{1}));
    }

    /**
     * 执行耗时:24 ms,击败了26.77% 的Java用户
     * 内存消耗:52.8 MB,击败了76.77% 的Java用户
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        if (prices.length == 2) {
            return Math.max(0, prices[1] - prices[0]);
        }
        // dp[i][j]代表在第i天时的最大利润, j=0或2表示买入, j=1或3表示卖出
        int[][] dp = new int[prices.length+1][4];
        dp[0][0] = -prices[0];
        // 第一次一定买入一次的最大利润
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(-prices[i], dp[i-1][0]);
        }
        // 第一次卖出的最大利润, 第i天最大利润=Math.max(第i-1天交易一次的最大利润, 第i天卖出和第i-1天第一次买入的最大利润之和)
        for (int i = 1; i < prices.length; i++) {
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] + prices[i]);
        }
        if (prices.length == 3) {
            return dp[prices.length-1][1];
        }
        dp[2][2] = dp[1][1] - prices[2];
        // 第二次一定买入的最大利润
        for (int i = 3; i < prices.length; i++) {
            dp[i][2] = Math.max(dp[i-1][1] - prices[i], dp[i-1][2]);
        }
        // 第三次卖出的最大利润, 第i天最大利润=Math.max(第i天交易1次的最大利润, 第i-1天交易两次的最大利润, 第i天卖出和第i-1天第二次买入的最大利润之和)
        for (int i = 3; i < prices.length; i++) {
            dp[i][3] = Math.max(dp[i][1], Math.max(dp[i-1][3], dp[i-1][2] + prices[i]));
        }
        return Math.max(dp[prices.length - 1][3], 0);
    }
}
