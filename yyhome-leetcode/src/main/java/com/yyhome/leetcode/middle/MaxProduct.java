package com.yyhome.leetcode.middle;

/**
 * 152 乘积最大的子数组
 * @author: lirl
 * @date: 2021/7/23
 */
public class MaxProduct {

    public static void main(String[] args){
        System.out.println(new MaxProduct().maxProduct(new int[]{2,3,-2,4,8,-9,0,50001, -1,0, -2}));
        System.out.println(new MaxProduct().maxProduct(new int[]{2,3,-2,4,8,-9}));
        System.out.println(new MaxProduct().maxProduct(new int[]{2,3,-2,4,8}));
        System.out.println(new MaxProduct().maxProduct(new int[]{3,-1,4}));
        System.out.println(new MaxProduct().maxProduct(new int[]{0,2}));
        System.out.println(new MaxProduct().maxProduct(new int[]{2,3,-2,4}));
        System.out.println(new MaxProduct().maxProduct(new int[]{-2,0,-1}));
    }

    /**
     * 执行耗时:2 ms,击败了87.39% 的Java用户
     * 内存消耗:38.5 MB,击败了5.70% 的Java用户
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = nums[0];
        // dp[i][0]表示i之前的最大值, dp[i][1]表示i之前的最小值, 当遇到nums[i]==0时, 重置dp[i]
        int[][] dp = new int[nums.length][2];
        dp[0][0] = Math.max(nums[0], 1);
        dp[0][1] = Math.min(nums[0], 1);
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            if (nums[i] > 0) {
                dp[i][0] = dp[i-1][0] * nums[i];
                dp[i][1] = dp[i-1][1] * nums[i];
                max = Math.max(max, dp[i][0]);
            } else if (nums[i] < 0) {
                if (dp[i-1][1] < 0) {
                    dp[i][0] = dp[i - 1][1] * nums[i];
                    max = Math.max(max, dp[i][0]);
                } else {
                    dp[i][0] = 1;
                }
                dp[i][1] = dp[i-1][0] * nums[i];
            } else {
                dp[i][0] = 1;
                dp[i][1] = 1;
                max = Math.max(max, 0);
            }
        }
        return max;
    }
}
