package com.yyhome.leetcode.easy;

/**
 * 1646 获取生成数组中的最大值
 * @author: lirl
 * @date: 2021/7/14
 */
public class GetMaximumGenerated {

    public static void main(String[] args){
        System.out.println(new GetMaximumGenerated().getMaximumGenerated(7));
        System.out.println(new GetMaximumGenerated().getMaximumGenerated(2));
        System.out.println(new GetMaximumGenerated().getMaximumGenerated(3));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:35.1 MB,击败了75.74% 的Java用户
     * @param n
     * @return
     */
    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        int max = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i/2];
            } else {
                dp[i] = dp[i/2] + dp[i/2+1];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
