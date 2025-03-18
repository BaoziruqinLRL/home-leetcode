package com.yyhome.leetcode.hard;

import java.util.Arrays;

/**
 * @Author: liriling
 * @Date: 2025/3/18 10:11
 */
public class LeastInterval621 {

    public static void main(String[] args) {
        System.out.println(new LeastInterval621().leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
        System.out.println(new LeastInterval621().leastInterval(new char[]{'A','C','A','B','D','B'}, 1));
        System.out.println(new LeastInterval621().leastInterval(new char[]{'A','A','A','B','B','B'}, 3));
        System.out.println(new LeastInterval621().leastInterval(new char[]{'A','A','A','B','C','D'}, 1));
    }

    /**
     * 执行耗时:2 ms,击败了80.96% 的Java用户
     * 内存消耗:45 MB,击败了39.82% 的Java用户
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }
        int[] count = new int[26];
        for (char c : tasks) {
            count[c - 'A']++;
        }
        Arrays.sort(count);
        int blank = (count[25] - 1) * n;
        int max = count[25] + blank;
        for (int i = 24; i >= 0; i--) {
            if (blank <= 0) {
                max += count[i];
            } else {
                int maxUse = Math.min(count[25] - 1, blank);
                int use = Math.min(count[i], maxUse);
                max += Math.max(0, count[i] - maxUse);
                blank -= use;
            }
        }
        return max;
    }
}
