package com.yyhome.leetcode.hard;

/**
 * 149 直线上最多的点
 * @Author: linabell
 * @Date: 2023/3/1 9:56:08
 */
public class MaxPoints149 {

    public static void main(String[] args) {
        System.out.println(new MaxPoints149().maxPoints(new int[][]{{-9,-651},{-4,-4},{-8,-582},{9,591},{-3,3}}));
        System.out.println(new MaxPoints149().maxPoints(new int[][]{{2,3}, {1,1}}));
        System.out.println(new MaxPoints149().maxPoints(new int[][]{{0,0}, {2,2}, {-1,-1}}));
        System.out.println(new MaxPoints149().maxPoints(new int[][]{{0,0}, {1,-1}, {1,1}}));
        System.out.println(new MaxPoints149().maxPoints(new int[][]{{1,1}, {2,2}, {3,3}}));
        System.out.println(new MaxPoints149().maxPoints(new int[][]{{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}}));
    }

    /**
     * 执行耗时:29 ms,击败了38.68% 的Java用户
     * 内存消耗:38.6 MB,击败了99.70% 的Java用户
     * @param points
     * @return
     */
    public int maxPoints(int[][] points) {
        if (points.length == 1) {
            return 1;
        }
        int max = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int currentMax = 2;
                double xDiff = points[i][0] - points[j][0];
                double yDiff = points[i][1] - points[j][1];
                for (int q = j + 1; q < points.length; q++) {
                    if (xDiff == 0 || yDiff == 0) {
                        if (xDiff == 0 && points[i][0] - points[q][0] == 0) {
                            currentMax++;
                        } else if (yDiff == 0 && points[i][1] - points[q][1] == 0) {
                            currentMax++;
                        }
                    } else if ((points[i][0] - points[q][0]) / xDiff == (points[i][1] - points[q][1]) / yDiff) {
                        currentMax++;
                    }
                }
                max = Math.max(currentMax, max);
            }
        }
        return max;
    }
}
