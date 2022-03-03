package com.yyhome.leetcode.middle;

/**
 * 357 计算各个位数不同的数字个数
 * @author: lirl
 * @date: 2021/7/30
 */
public class CountNumbersWithUniqueDigits {

    public static void main(String[] args) {
        System.out.println(new CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(2));
        System.out.println(new CountNumbersWithUniqueDigits().countNumbersWithUniqueDigits(3));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:35.1 MB,击败了71.17% 的Java用户
     * @param n
     * @return
     */
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 10;
        } else {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 9;
            int total = dp[1] + dp[0], lastRange = 9;
            for (int i = 2; i <= n; i++) {
                int rangeDown = (int) Math.pow(10, i - 1), rangeUp = ((int) Math.pow(10, i)) - 1;
                dp[i] = (rangeUp - rangeDown + 1) - dp[i - 1] * (i - 1) - (lastRange - dp[i - 1]) * 10;
                lastRange = rangeUp - rangeDown + 1;
                total += dp[i];
            }
            return total;
        }
    }
}
