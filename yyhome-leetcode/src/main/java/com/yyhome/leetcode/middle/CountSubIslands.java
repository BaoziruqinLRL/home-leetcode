package com.yyhome.leetcode.middle;

/**
 * 1905 统计子岛屿
 * @author: lirl
 * @date: 2021/6/28
 */
public class CountSubIslands {

    public static void main(String[] args){
        System.out.println(new CountSubIslands().countSubIslands(new int[][]{{1,1,1,0,0},{0,1,1,1,1},{0,0,0,0,0},{1,0,0,0,0},{1,1,0,1,1}},
                new int[][]{{1,1,1,0,0},{0,0,1,1,1},{0,1,0,0,0},{1,0,1,1,0},{0,1,0,1,0}}));
        System.out.println(new CountSubIslands().countSubIslands(new int[][]{{1,0,1,0,1},{1,1,1,1,1},{0,0,0,0,0},{1,1,1,1,1},{1,0,1,0,1}},
                new int[][]{{0,0,0,0,0},{1,1,1,1,1},{0,1,0,1,0},{0,1,0,1,0},{1,0,0,0,1}}));
    }

    boolean [][] visited;
    int count = 0;
    boolean isSon = true;

    /**
     * 执行耗时:29 ms,击败了67.05% 的Java用户
     * 内存消耗:87.4 MB,击败了23.55% 的Java用户
     * @param grid1
     * @param grid2
     * @return
     */
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        visited = new boolean[grid2.length][grid2[0].length];
        for (int x = 0; x < grid2.length; x++) {
            for (int y = 0; y < grid2[x].length; y++) {
                if (!visited[x][y] && grid2[x][y] == 1) {
                    dfs(grid1, grid2, x, y);
                    count += isSon ? 1 : 0;
                    isSon = true;
                }
            }
        }
        return count;
    }

    private void dfs(int[][] grid1, int[][] grid2, int x, int y) {
        if (x < 0 || y < 0 || x >= grid2.length || y >= grid2[x].length || visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        if (grid2[x][y] == 1) {
            if (grid1[x][y] == 0){
                isSon = false;
            }
            dfs(grid1, grid2, x, y - 1);
            dfs(grid1, grid2, x, y + 1);
            dfs(grid1, grid2, x - 1, y);
            dfs(grid1, grid2, x + 1, y);
        }
    }
}
