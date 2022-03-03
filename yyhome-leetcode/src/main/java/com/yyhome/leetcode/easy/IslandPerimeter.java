package com.yyhome.leetcode.easy;

/**
 * 463 岛屿的周长
 * @author: lirl
 * @date: 2021/3/25
 */
public class IslandPerimeter {

    public static void main(String[] args){
        System.out.println(new IslandPerimeter().islandPerimeter(new int[][]{{0,1,0,0}, {1,1,1,0},{0,1,0,0},{1,1,0,0}}));
        System.out.println(new IslandPerimeter().islandPerimeter2(new int[][]{{0,1,0,0}, {1,1,1,0},{0,1,0,0},{1,1,0,0}}));
    }

    /**
     * 执行耗时:8 ms,击败了80.13% 的Java用户
     * 内存消耗:39.7 MB,击败了59.29% 的Java用户
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        int size = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                if (grid[i][j] == 1) {
                    if (i == 0 || grid[i - 1][j] == 0) {
                        size++;
                    }
                    if (i == grid.length - 1 || grid[i + 1][j] == 0) {
                        size++;
                    }
                    if (j == 0 || grid[i][j - 1] == 0) {
                        size++;
                    }
                    if (j == grid[i].length - 1 || grid[i][j + 1] == 0) {
                        size++;
                    }
                }
            }
        }
        return size;
    }

    /**
     * 执行耗时:7 ms,击败了98.19% 的Java用户
     * 内存消耗:39.8 MB,击败了43.29% 的Java用户
     * @param grid
     * @return
     */
    public int islandPerimeter2(int[][] grid) {
        int size = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                if (grid[i][j] == 1) {
                    size+=4;
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) {
                        size-=2;
                    }
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) {
                        size-=2;
                    }
                }
            }
        }
        return size;
    }

}
