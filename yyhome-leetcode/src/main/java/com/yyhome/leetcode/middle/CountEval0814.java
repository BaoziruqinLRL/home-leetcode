package com.yyhome.leetcode.middle;

import com.alibaba.fastjson.JSON;

/**
 * @Author: liriling
 * @Date: 2025/3/28 11:14
 */
public class CountEval0814 {

    public static void main(String[] args) {
        // 10
        System.out.println(JSON.toJSONString(new CountEval0814().countEval("0&0&0&1^1|0", 1)));
        // 2
        System.out.println(JSON.toJSONString(new CountEval0814().countEval("1^0|0|1", 0)));
    }

    /**
     * 执行耗时:2 ms,击败了49.61% 的Java用户
     * 内存消耗:41.6 MB,击败了29.13% 的Java用户
     * 设置dp[i][j][k]为从i->j中k出现的次数，长为length的字符串中，出现结果result的次数为：
     * 以位置为index（1 <= index <= length-1）的符号左右计算出结果为result的次数总和。
     * 例如1^0|0|1以index=1计算，左边结算出1的方式为1次，右边计算出1的方式为2【(0|0)|1或0|(0|1)】，那么index=1时计算出result=0的次数为1.
     * 之后index+=2,把所有index遍历的结果加起来的和则为字符串出现result的次数
     * @param s
     * @param result
     * @return
     */
    public int countEval(String s, int result) {
        int[][][] dp = new int[s.length()][s.length()][2];
        search(dp, 0, s.length(), s);
        return dp[0][s.length()-1][result];
    }

    private void search(int[][][] dp, int start, int end, String s) {
        if (start == end - 1) {
            dp[start][end-1][0] = s.charAt(start) == '0' ? 1 : 0;
            dp[start][end-1][1] = dp[start][end-1][0] ^ 1;
        }
        if (dp[start][end-1][0] > 0 || dp[start][end-1][1] > 0) {
            return;
        }
        for (int i = start + 1; i < end; i+=2) {
            search(dp, start, i, s);
            search(dp, i+1, end, s);
            char character = s.charAt(i);
            dp[start][end-1][calculate(character, 0, 0)] += dp[start][i-1][0] * dp[i+1][end-1][0];
            dp[start][end-1][calculate(character, 0, 1)] += dp[start][i-1][0] * dp[i+1][end-1][1];
            dp[start][end-1][calculate(character, 1, 0)] += dp[start][i-1][1] * dp[i+1][end-1][0];
            dp[start][end-1][calculate(character, 1, 1)] += dp[start][i-1][1] * dp[i+1][end-1][1];
        }
    }

    private int calculate(char character, int left, int right) {
        if (character == '&') {
            return left & right;
        } else if (character == '|') {
            return left | right;
        } else if (character == '^') {
            return left ^ right;
        }
        return 0;
    }
}
