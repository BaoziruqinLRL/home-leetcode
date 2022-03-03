package com.yyhome.leetcode.middle;

/**
 * 309 最佳买卖股票时机含冷冻期
 * @author: lirl
 * @date: 2021/7/29
 */
public class MaxProfit {

    public static void main(String[] args){
        System.out.println(new MaxProfit().maxProfit(new int[]{2,4,1}));
        System.out.println(new MaxProfit().maxProfit(new int[]{3,3}));
        System.out.println(new MaxProfit().maxProfit(new int[]{1,2,3,0,2}));
        System.out.println(new MaxProfit().maxProfit(new int[]{1,2,3,2,2}));
        System.out.println(new MaxProfit().maxProfit(new int[]{1,2,5,6,6}));
        System.out.println(new MaxProfit().maxProfit(new int[]{1,2,5,6,6,0,7,7,7,6,2}));
    }

    /**
     * 执行耗时:1 ms,击败了98.39% 的Java用户
     * 内存消耗:37.8 MB,击败了35.37% 的Java用户
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        // 0表示卖出，1表示买入，2表示冻结期  dp[i][x]表示第i天在x状态下的最大利润
        int[][] dp = new int[prices.length][3];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][0]);
            dp[i][1] = Math.max(dp[i - 1][2] - prices[i], dp[i - 1][1]);
            dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][2]);
        }
        return Math.max(dp[prices.length - 1][0], Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]));
    }
}
