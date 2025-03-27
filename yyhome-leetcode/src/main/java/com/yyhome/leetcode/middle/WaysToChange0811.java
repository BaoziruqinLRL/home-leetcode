package com.yyhome.leetcode.middle;

import com.alibaba.fastjson.JSON;

/**
 * @Author: liriling
 * @Date: 2025/3/27 13:43
 */
public class WaysToChange0811 {

    public static void main(String[] args) {
        // 2
        // 5=5 5=1+1+1+1+1
        // 1 2
        System.out.println(JSON.toJSONString(new WaysToChange0811().waysToChange(5)));
        // 4
        // 10=10 10=5+5 10=5+1+1+1+1+1 10=1+1+1+1+1+1+1+1+1+1
        // 1 3
        System.out.println(JSON.toJSONString(new WaysToChange0811().waysToChange(10)));
        // 6
        // 15=10+5 15=10+1... 15=5+5+5 15=5+5+1... 15=5+1... 15=1+1...
        System.out.println(JSON.toJSONString(new WaysToChange0811().waysToChange(15)));
    }

    /**
     * 执行耗时:30 ms,击败了27.42% 的Java用户
     * 内存消耗:43.1 MB,击败了32.80% 的Java用户
     * 以硬币类型进行递归
     * 先只用1面值进行排列
     * 后用1，5面值进行排列
     * 那么第n次递归中，dp[i]=dp[i] + dp[i-面值], 因为此次递归多了一个面值coin，可以认为此次的排列数为以取coin为结尾的排列数，而coin结尾为固定，
     * 那么排列数等于上一次递归的排列数加上以取i-coin为结尾的排列数
     * @param n
     * @return
     */
    public int waysToChange(int n) {
        int[] coins = new int[]{1, 5, 10, 25};
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i <= n; i++) {
                if (i - coin >= 0) {
                    dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
                }
            }
        }
        return dp[n];
    }
}
