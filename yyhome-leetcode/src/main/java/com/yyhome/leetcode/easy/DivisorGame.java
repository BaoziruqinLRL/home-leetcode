package com.yyhome.leetcode.easy;

/**
 * 1025 除数博弈
 * @author: lirl
 * @date: 2021/7/13
 */
public class DivisorGame {

    public static void main(String[] args) {
        System.out.println(new DivisorGame().divisorGame(4));
        System.out.println(new DivisorGame().divisorGame(5));
        System.out.println(new DivisorGame().divisorGame(2));
        System.out.println(new DivisorGame().divisorGame(3));
    }

    /**
     * 执行耗时:3 ms,击败了36.18% 的Java用户
     * 内存消耗:35.1 MB,击败了75.03% 的Java用户
     * @param n
     * @return
     */
    public boolean divisorGame(int n) {
        // dp[i]表示n=i时，alice先手是否能获胜，初始条件很容易确定，n逐渐变大时则根据前面能否获胜推的之后能否获胜
        boolean[] dp = new boolean[n+1];
        dp[0] = false;
        dp[1] = false;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (i % j == 0 && !dp[i-j]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
