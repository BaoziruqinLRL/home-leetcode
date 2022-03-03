package com.yyhome.leetcode.middle;

import com.yyhome.leetcode.data.TreeNode;

/**
 * 64 最小路径和
 * @author: lirl
 * @date: 2021/4/20
 */
public class MinPathSum {

    public static void main(String[] args) {
        System.out.println(new MinPathSum().minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
        System.out.println(new MinPathSum().minPathSum(new int[][]{{1,2,3},{4,5,6}}));
    }

    /**
     * 执行耗时:5 ms,击败了16.61% 的Java用户
     * 内存消耗:41 MB,击败了82.79% 的Java用户
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int[][] res = new int[grid.length][grid[0].length];
        res[0][0] = grid[0][0];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i < grid.length - 1) {
                    res[i+1][j] = res[i][j] + grid[i+1][j];
                }
                if (j < grid[i].length - 1) {
                    if (res[i][j+1] == 0) {
                        res[i][j+1] = res[i][j] + grid[i][j+1];
                    } else {
                        res[i][j+1] = Math.min(res[i][j+1], res[i][j]+grid[i][j+1]);
                    }
                }
            }
        }
        return res[grid.length-1][grid[0].length-1];
    }
}
