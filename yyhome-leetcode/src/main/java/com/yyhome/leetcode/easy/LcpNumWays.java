package com.yyhome.leetcode.easy;

/**
 * LCP 07 传递信息
 * @author: lirl
 * @date: 2021/7/16
 */
public class LcpNumWays {

    public static void main(String[] args) {
        System.out.println(new LcpNumWays().numWays(5, new int[][]{{0,2},{2,1},{3,4},{2,3},{1,4},{2,0},{0,4}}, 3));
        System.out.println(new LcpNumWays().numWays(3, new int[][]{{0,2},{2,1}}, 2));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:35.9 MB,击败了65.18% 的Java用户
     * @param n
     * @param relation
     * @param k
     * @return
     */
    public int numWays(int n, int[][] relation, int k) {
        // 走了k步到n-1的方案数
        int[][] dp = new int[k+1][n];
        dp[0][0] = 1;
        for (int i = 1; i <= k; i++) {
            for (int[] r : relation) {
                // 这里表示dp[i][r[1]] 的方案数为 dp[i-1][r[0]]的总和, r[0]为起始点，r[1]为终点，
                // 当走到了dp[i-1][r[0]]，下一步就可以到dp[i][r[1]]了，所以其方案数可以相加
                dp[i][r[1]] += dp[i-1][r[0]];
            }
        }
        return dp[k][n-1];
    }
}
