package com.yyhome.leetcode.hard;

/**
 * 188 买卖股票的最佳时机
 * @Author: linabell
 * @Date: 2023/3/3 15:15:04
 */
public class MaxProfit188 {

    public static void main(String[] args) {
        System.out.println(new MaxProfit188().maxProfit(2, new int[]{1,2,4,7}));
        System.out.println(new MaxProfit188().maxProfit(2, new int[]{2,4,1}));
        System.out.println(new MaxProfit188().maxProfit(2, new int[]{3,2,6,5,0,3}));
    }

    /**
     * 执行耗时:8 ms,击败了11.74% 的Java用户
     * 内存消耗:42 MB,击败了13.06% 的Java用户
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        int max = 0;
        // dp[i][j][0]代表第i天第j+1次买入最大利润, dp[i][j][1]代表第i天第j+1次卖出最大利润
        int[][][] dp = new int[prices.length][k][2];
        // 初始化第一次买入和卖出
        dp[0][0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0][0] = Math.max(-prices[i], dp[i-1][0][0]);
        }
        dp[0][0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0][1] = Math.max(dp[i-1][0][1], prices[i] + dp[i-1][0][0]);
            max = Math.max(max, dp[i][0][1]);
        }
        for (int c = 1; c < k && prices.length >= 2*(c+1); c++) {
            // 第 c+1 次买入
            dp[2*c][c][0] = dp[2*c-1][c-1][1] - prices[2*c];
            for (int i = 2*c+1; i < prices.length; i++) {
                dp[i][c][0] = Math.max(dp[i-1][c-1][1] - prices[i], dp[i-1][c][0]);
            }
            // 第 c+1 次卖出
            dp[2*c+1][c][1] = prices[2*c+1] + dp[2*c][c][0];
            for (int i = 2*c + 2; i < prices.length; i++) {
                dp[i][c][1] = Math.max(dp[i-1][c][1], prices[i] + dp[i-1][c][0]);
            }
            max = Math.max(max, dp[prices.length-1][c][1]);
        }
        return max;
    }
}
