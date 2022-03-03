package com.yyhome.leetcode.middle;

/**
 * 343 整数拆分
 * @author: lirl
 * @date: 2021/7/30
 */
public class IntegerBreak {

    public static void main(String[] args) {
        System.out.println(new IntegerBreak().integerBreak(2));
        System.out.println(new IntegerBreak().integerBreak(10));
    }

    /**
     * 执行耗时:1 ms,击败了67.64% 的Java用户
     * 内存消耗:35.1 MB,击败了56.98% 的Java用户
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        for (int i = 2; i <= n; i++){
            for (int d = 1; d < i; d++) {
                dp[i] = Math.max(dp[i], Math.max(d * (i-d), d * dp[i-d]));
            }
        }
        return dp[n];
    }
}
