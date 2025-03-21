package com.yyhome.leetcode.hard;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: liriling
 * @Date: 2025/3/19 11:04
 */
public class PileBox0813 {

    public static void main(String[] args) {
        // 7
        System.out.println(new PileBox0813().pileBox(new int[][]{{2, 7, 4}, {9, 5, 2}, {3, 3, 7}}));
        // 27
        System.out.println(new PileBox0813().pileBox(new int[][]{{9, 9, 10}, {8, 10, 9}, {9, 8, 10}, {9, 8, 10}, {10, 8, 8}, {9, 8, 9}, {9, 8, 8}, {8, 9, 10}, {10, 9, 10}, {8, 8, 10}, {10, 9, 10}, {10, 9, 8}, {8, 9, 9}, {9, 10, 8}, {8, 9, 9}, {10, 10, 9}, {8, 9, 10}, {8, 10, 10}, {8, 9, 10}, {10, 10, 8}, {10, 10, 9}, {9, 10, 10}, {10, 8, 9}, {10, 10, 9}, {8, 9, 10}, {8, 8, 9}, {8, 10, 10}, {9, 9, 10}, {10, 8, 8}, {10, 10, 8}, {8, 9, 9}, {8, 9, 8}, {10, 10, 8}, {8, 10, 8}, {10, 9, 10}, {9, 9, 10}, {9, 9, 9}, {8, 9, 8}, {9, 8, 8}, {8, 9, 10}, {10, 10, 8}, {9, 9, 9}, {10, 10, 10}, {10, 9, 8}, {9, 8, 9}, {8, 8, 10}, {8, 8, 8}, {8, 8, 8}, {8, 9, 10}, {10, 9, 8}, {8, 10, 8}, {8, 10, 10}, {9, 10, 10}, {8, 8, 9}, {9, 9, 9}, {10, 8, 8}, {8, 10, 10}, {9, 10, 9}, {9, 9, 8}, {8, 10, 9}, {9, 8, 8}, {9, 9, 10}, {9, 10, 10}, {8, 8, 10}}));
        // 10
        System.out.println(new PileBox0813().pileBox(new int[][]{{1, 1, 1}, {2, 3, 4}, {2, 6, 7}, {3, 4, 5}}));
        // 6
        System.out.println(new PileBox0813().pileBox(new int[][]{{1, 1, 1}, {2, 2, 2}, {3, 3, 3}}));
    }

    /**
     * 执行耗时:53 ms,击败了11.00% 的Java用户
     * 内存消耗:43.4 MB,击败了98.00% 的Java用户
     * 对宽排序后，剩下二维直接用dp暴力解
     * @param box
     * @return
     */
    public int pileBox(int[][] box) {
        Arrays.sort(box, Comparator.comparingInt(a -> a[0]));
        int[] dp = new int[box.length];
        int max = 0;
        for (int i = 0; i < box.length; i++) {
            dp[i] = box[i][2];
            max = Math.max(dp[i], max);
        }
        for (int i = 1; i < box.length; i++) {
            for (int j = 0; j < i; j++) {
                if (box[i][0] > box[j][0] && box[i][1] > box[j][1] && box[i][2] > box[j][2]) {
                    dp[i] = Math.max(dp[i], dp[j] + box[i][2]);
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }

}
