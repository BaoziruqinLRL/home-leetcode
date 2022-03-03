package com.yyhome.leetcode.easy;

import java.util.Arrays;

/**
 * 338 比特位计数
 * @author: lirl
 * @date: 2021/7/12
 */
public class CountBits {

    public static void main(String[] args){
        System.out.println(Arrays.toString(new CountBits().countBits(2)));
        System.out.println(Arrays.toString(new CountBits().countBits(5)));
    }

    /**
     * 执行耗时:2 ms,击败了63.20% 的Java用户
     * 内存消耗:42.6 MB,击败了43.86% 的Java用户
     * @param n
     * @return
     */
    public int[] countBits(int n) {
        if (n == 0) {
            return new int[]{0};
        }
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        int maxSize = 2;
        int size = 2;
        for (int i = 2; i <= n; i++) {
            if (size == 0) {
                maxSize = i;
                size = maxSize;
            }
            dp[i] = 1 + dp[i - maxSize];
            size--;
        }
        return dp;
    }
}
