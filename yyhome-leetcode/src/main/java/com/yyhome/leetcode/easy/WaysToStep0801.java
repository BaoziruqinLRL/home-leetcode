package com.yyhome.leetcode.easy;

import com.alibaba.fastjson.JSON;

/**
 * @Author: liriling
 * @Date: 2025/3/27 11:11
 */
public class WaysToStep0801 {

    public static void main(String[] args) {
        // 176653584
        System.out.println(JSON.toJSONString(new WaysToStep0801().waysToStep(76)));
        // 4
        System.out.println(JSON.toJSONString(new WaysToStep0801().waysToStep(3)));
        // 13
        System.out.println(JSON.toJSONString(new WaysToStep0801().waysToStep(5)));
    }

    /**
     * 执行耗时:25 ms,击败了21.41% 的Java用户
     * 内存消耗:48.3 MB,击败了13.89% 的Java用户
     * @param n
     * @return
     */
    public int waysToStep(int n) {
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
            if (i > 2) {
                dp[i] += dp[i-3];
            }
            dp[i] %= 1000000007;
        }
        return (int) dp[n];
    }
}
