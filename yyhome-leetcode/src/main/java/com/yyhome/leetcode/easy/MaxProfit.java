package com.yyhome.leetcode.easy;

/**
 * 121 买卖股票的最佳时机
 * @author: lirl
 * @date: 2021/3/9
 */
public class MaxProfit {

    public static void main(String[] args) {
        System.out.println(new MaxProfit().maxProfit(new int[]{7,14,1,5,3,6,4}));
        System.out.println(new MaxProfit().maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(new MaxProfit().maxProfit(new int[]{7,6,4,3,1}));
    }

    /**
     * 执行耗时:4 ms,击败了27.65% 的Java用户
     * 内存消耗:51.3 MB,击败了38.50% 的Java用户
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length <= 1){
            return 0;
        }
        int max = 0;
        int lowestBuy = prices[0];
        for (int i = 1; i < prices.length; i++){
            max = Math.max(max, prices[i] - lowestBuy);
            lowestBuy = Math.min(lowestBuy, prices[i]);
        }
        return max;
    }
}
