package com.yyhome.leetcode.middle;

/**
 * LCS 03 主题空间
 * @author: lirl
 * @date: 2021/6/29
 */
public class LargestArea {

    public static void main(String[] args){
        System.out.println(new LargestArea().largestArea(new String[]{"110","231","221"}));
        System.out.println(new LargestArea().largestArea(new String[]{"11111100000","21243101111","21224101221","11111101111"}));
    }

    boolean[][] visited;
    boolean neighborAisle;

    /**
     * 执行耗时:123 ms,击败了78.80% 的Java用户
     * 内存消耗:38.1 MB,击败了100.00% 的Java用户
     * @param grid
     * @return
     */
    public int largestArea(String[] grid) {
        visited = new boolean[grid.length][grid[0].length()];
        int max = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length(); y++) {
                if (!visited[x][y] && grid[x].charAt(y) != '0') {
                    max = Math.max(max, dfs(grid, grid[x].charAt(y), x, y, 0));
                    neighborAisle = false;
                }
            }
        }
        return max;
    }

    private int dfs(String[] grid, char c, int x, int y, int size){
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length() || visited[x][y]) {
            return size;
        }
        char cur = grid[x].charAt(y);
        if (cur == c || cur == '0') {
            // 只有相等或cur是走廊的情况下，才需要判断c是否临近走廊；
            // 否则的话cur和c不是同一空间，那么cur不管临近不临近走廊都不影响c的neighborAisle状态，因为每步dfs实际上是在计算c的周边
            neighborAisle = isNeighbor(grid, x, y);
            visited[x][y] = true;
            if (cur == c) {
                size++;
                size = dfs(grid, cur, x, y - 1, size);
                size = dfs(grid, cur, x, y + 1, size);
                size = dfs(grid, cur, x - 1, y, size);
                size = dfs(grid, cur, x + 1, y, size);
            }
        }
        return neighborAisle ? -1 : size;
    }

    private boolean isNeighbor(String[] grid, int x, int y) {
        return neighborAisle ||
                x == 0 ||
                y == 0 ||
                x == grid.length - 1 ||
                y == grid[0].length() - 1 ||
                grid[x].charAt(y) == '0' ||
                grid[x].charAt(y - 1) == '0' ||
                grid[x].charAt(y + 1) == '0' ||
                grid[x - 1].charAt(y) == '0' ||
                grid[x + 1].charAt(y) == '0';
    }
}
