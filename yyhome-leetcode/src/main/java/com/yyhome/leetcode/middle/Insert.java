package com.yyhome.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 57 插入区间
 * @author: lirl
 * @date: 2021/4/19
 */
public class Insert {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Insert().insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2,5})));
        System.out.println(Arrays.deepToString(new Insert().insert(new int[][]{{1, 2}, {3, 5}, {6,7}, {8, 10}, {12, 18}}, new int[]{4,8})));
    }

    /**
     * 2ms 72%
     * 41MB 14%
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        List<int[]> res = new ArrayList<>();
        boolean added = false;
        for (int[] interval : intervals) {
            if (newInterval[0] > interval[1]) {
                res.add(interval);
            } else if (newInterval[1] < interval[0]) {
                if (!added) {
                    added = true;
                    res.add(newInterval);
                }
                res.add(interval);
            } else {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        if (!added) {
            res.add(newInterval);
        }
        return res.toArray(new int[res.size()][2]);
    }
}
