package com.yyhome.leetcode.middle;

/**
 * 62 不同路径
 * @author: lirl
 * @date: 2021/4/19
 */
public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(19,13));
        System.out.println(new UniquePaths().uniquePaths(7,3));
        System.out.println(new UniquePaths().uniquePaths(3,7));
        System.out.println(new UniquePaths().uniquePaths(3,2));
        System.out.println(new UniquePaths().uniquePaths(3,3));
    }

    /**
     * 执行耗时:1 ms,击败了8.09% 的Java用户
     * 内存消耗:35.3 MB,击败了53.72% 的Java用户
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] res = new int[m][n];
        res[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i < m - 1) {
                    res[i+1][j] += res[i][j];
                }
                if (j < n - 1) {
                    res[i][j+1] += res[i][j];
                }
            }
        }
        return res[m-1][n-1];
    }
}
