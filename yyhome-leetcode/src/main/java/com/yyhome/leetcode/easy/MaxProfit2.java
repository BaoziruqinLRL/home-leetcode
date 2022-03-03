package com.yyhome.leetcode.easy;

/**
 * 122 买卖股票的最佳时机Ⅰ
 * @author: lirl
 * @date: 2021/3/9
 */
public class MaxProfit2 {

    public static void main(String[] args) {
        System.out.println(new MaxProfit2().maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(new MaxProfit2().maxProfit(new int[]{1,2,3,4,5}));
        System.out.println(new MaxProfit2().maxProfit(new int[]{7,6,4,3,1}));
    }

    /**
     * 执行耗时:1 ms,击败了99.57% 的Java用户
     * 内存消耗:38.2 MB,击败了65.38% 的Java用户
     * 贪心算法，局部最优解
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (prices.length <= 1){
            return 0;
        }
        int max = 0;
        for (int i = 1; i < prices.length; i++){
            if (prices[i - 1] < prices[i]){
                max += prices[i] - prices[i - 1];
            }
        }
        return max;
    }
}
