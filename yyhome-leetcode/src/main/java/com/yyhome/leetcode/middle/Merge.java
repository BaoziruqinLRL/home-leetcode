package com.yyhome.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56 合并区间
 * @author: lirl
 * @date: 2021/4/19
 */
public class Merge {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Merge().merge(new int[][]{{15, 18}, {2, 6}, {1, 3}, {8, 10}})));
        System.out.println(Arrays.deepToString(new Merge().merge(new int[][]{{1, 4}, {0, 4}})));
        System.out.println(Arrays.deepToString(new Merge().merge(new int[][]{{1, 4}, {4, 5}})));
        System.out.println(Arrays.deepToString(new Merge().merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }

    /**
     * 执行耗时:9 ms,击败了34.36% 的Java用户
     * 内存消耗:40.8 MB,击败了94.99% 的Java用户
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        intervals = mergeSort(intervals, 0, intervals.length);
        List<int[]> res =  new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[i-1][1]) {
                intervals[i][0] = intervals[i-1][0];
                intervals[i][1] = Math.max(intervals[i-1][1], intervals[i][1]);
            } else {
                res.add(intervals[i-1]);
            }
        }
        res.add(intervals[intervals.length-1]);
        return res.toArray(new int[res.size()][2]);
    }

    private static int[][] mergeSort(int[][] nums, int s, int e){
        if (e-s < 2){
            return new int[][]{nums[s]};
        }
        int[][] left = mergeSort(nums, s,(s + e) / 2);
        int[][] right = mergeSort(nums, (s + e) / 2, e);
        return merge(left, right);
    }

    private static int[][] merge(int[][] left, int[][] right){
        int[][] res = new int[left.length + right.length][2];
        for (int l = 0, r = 0, reIndex = 0; l < left.length || r < right.length;){
            res[reIndex++] =
                    l == left.length ? right[r++] :
                            r == right.length ? left[l++] :
                                    left[l][0] < right[r][0] ? left[l++] : right[r++];
        }
        return res;
    }
}
