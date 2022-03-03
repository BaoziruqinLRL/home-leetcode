package com.yyhome.leetcode.middle;

import java.util.Arrays;

/**
 * 1828 统计一个圆中点的数目
 * @author: lirl
 * @date: 2021/6/30
 */
public class CountPoints {

    public static void main(String[] args){
        System.out.println(Arrays.toString(new CountPoints().countPoints(new int[][]{{1, 3}, {3, 3}, {5, 3}, {2, 2}}, new int[][]{{2, 3, 1}, {4, 3, 1}, {1, 1, 2}})));
    }

    /**
     * 执行耗时:25 ms,击败了72.18% 的Java用户
     * 内存消耗:38.6 MB,击败了98.12% 的Java用户
     * @param points
     * @param queries
     * @return
     */
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] answer = new int[queries.length];
        int index = 0;
        for (int[] q : queries) {
            int length = q[2] * q[2];
            for (int[] point : points) {
                int x = point[0] - q[0];
                int y = point[1] - q[1];
                if (length >= (x * x + y * y)) {
                    answer[index]++;
                }
            }
            index++;
        }
        return answer;
    }
}
