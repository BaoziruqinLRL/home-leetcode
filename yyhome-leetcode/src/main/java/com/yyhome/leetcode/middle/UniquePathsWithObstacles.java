package com.yyhome.leetcode.middle;

/**
 * 63 不同路径Ⅱ
 * @author: lirl
 * @date: 2021/4/20
 */
public class UniquePathsWithObstacles {

    public static void main(String[] args) {
        System.out.println(new UniquePathsWithObstacles().uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
        System.out.println(new UniquePathsWithObstacles().uniquePathsWithObstacles(new int[][]{{0,1},{0,0}}));
    }

    /**
     * 执行耗时:1 ms,击败了19.68% 的Java用户
     * 内存消耗:37.7 MB,击败了53.99% 的Java用户
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int[][] res = new int[obstacleGrid.length][obstacleGrid[0].length];
        res[0][0] = 1;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {
                if (i < obstacleGrid.length - 1 && obstacleGrid[i+1][j] != 1) {
                    res[i+1][j] += res[i][j];
                }
                if (j < obstacleGrid[i].length - 1 && obstacleGrid[i][j+1] != 1) {
                    res[i][j+1] += res[i][j];
                }
            }
        }
        return res[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
