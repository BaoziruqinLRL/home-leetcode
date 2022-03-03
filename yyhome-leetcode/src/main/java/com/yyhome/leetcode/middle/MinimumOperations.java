package com.yyhome.leetcode.middle;

/**
 * LCP 19 秋叶收藏集
 * @author: lirl
 * @date: 2021/7/16
 */
public class MinimumOperations {

    public static void main(String[] args){
        System.out.println(new MinimumOperations().minimumOperations("rrryyyrryyyrr"));
        System.out.println(new MinimumOperations().minimumOperations("ryr"));
    }

    /**
     * 执行耗时:60 ms,击败了58.55% 的Java用户
     * 内存消耗:47.5 MB,击败了28.29% 的Java用户
     * @param leaves
     * @return
     */
    public int minimumOperations(String leaves) {
        // dp表示第i个叶子处于第j种状态时的变换次数，j=0红  j=1红->黄  j=2红->黄->红
        int[][] dp = new int[leaves.length()+1][3];
        dp[1][0] = leaves.charAt(0) == 'r' ? 0 : 1;
        dp[1][1] = dp[1][2] = dp[2][2] = Integer.MAX_VALUE;
        for (int i = 2; i <= leaves.length(); i++) {
            dp[i][0] = dp[i-1][0] + (leaves.charAt(i-1) == 'r' ? 0 : 1);
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][1]) + (leaves.charAt(i-1) == 'r' ? 1 : 0);
            if (i >= 3) {
                dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][2]) + (leaves.charAt(i - 1) == 'r' ? 0 : 1);
            }
        }
        return dp[leaves.length()][2];
    }
}
