package com.yyhome.leetcode.middle;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: liriling
 * @Date: 2025/3/28 8:47
 */
public class PathWithObstacles0802 {

    public static void main(String[] args) {
        // [[0,0],[0,1],[0,2],[1,2],[2,2]]
        System.out.println(JSON.toJSONString(new PathWithObstacles0802().pathWithObstacles(new int[][]{{0,0,0}, {0,1,0}, {0,0,0}})));
        // [[0,0],[0,1],[0,2],[1,2],[2,2]]
        System.out.println(JSON.toJSONString(new PathWithObstacles0802().pathWithObstacles(new int[][]{{1}})));
    }

    /**
     * 执行耗时:1 ms,击败了98.62% 的Java用户
     * 内存消耗:44.1 MB,击败了26.89% 的Java用户
     * 回溯+dp记录已走过路径
     * @param obstacleGrid
     * @return
     */
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        List<List<Integer>> res = new ArrayList<>();
        if (obstacleGrid[0][0] == 0) {
            cycle(obstacleGrid, res, new int[obstacleGrid.length][obstacleGrid[0].length], 0, 0);
        }
        return res;
    }

    private boolean cycle(int[][] obstacleGrid, List<List<Integer>> res, int[][] dp, int x, int y) {
        if (x == obstacleGrid.length - 1 && y == obstacleGrid[0].length - 1) {
            res.add(Arrays.asList(x, y));
            return true;
        }
        if (dp[x][y] == 1) {
            return false;
        }
        res.add(Arrays.asList(x, y));
        if (y < obstacleGrid[0].length - 1 && obstacleGrid[x][y+1] == 0) {
            if (cycle(obstacleGrid, res, dp, x, y+1)) {
                return true;
            }
        }
        if (x < obstacleGrid.length - 1 && obstacleGrid[x+1][y] == 0) {
            if (cycle(obstacleGrid, res, dp, x + 1, y)) {
                return true;
            }
        }
        res.remove(res.size() - 1);
        dp[x][y] = 1;
        return false;
    }
}
