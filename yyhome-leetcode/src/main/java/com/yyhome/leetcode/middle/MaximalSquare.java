package com.yyhome.leetcode.middle;

/**
 * 221 最大正方形
 * @author: lirl
 * @date: 2021/7/27
 */
public class MaximalSquare {

    public static void main(String[] args){
        /**
         *  1 0 1 0 0
         *  1 0 1 1 1
         *  1 1 1 1 1
         *  1 0 0 1 0
         */
        System.out.println(new MaximalSquare().maximalSquare(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
        System.out.println(new MaximalSquare().maximalSquare(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','1','1','1'}}));
        System.out.println(new MaximalSquare().maximalSquare(new char[][]{{'0','1'},{'1','0'}}));
        System.out.println(new MaximalSquare().maximalSquare(new char[][]{{'1'},{'0'},{'0'},{'0'}}));
        System.out.println(new MaximalSquare().maximalSquare(new char[][]{{'0'},{'0'},{'0'},{'0'}}));
    }

    /**
     * 执行耗时:7 ms,击败了38.14% 的Java用户
     * 内存消耗:41.5 MB,击败了69.36% 的Java用户
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        // dp[i][j] 表示以(i,j)为右下角所能构成最大的正方形的边长
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    if (i > 0 && j > 0) {
                        // 若要构成正方形,则由左边、上边和做上边的最小值+1构成新得正方形
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    } else {
                        dp[i][j] = 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }

}
