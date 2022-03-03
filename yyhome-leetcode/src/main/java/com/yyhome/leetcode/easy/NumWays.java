package com.yyhome.leetcode.easy;

/**
 * 面试题10-2 青蛙跳台阶问题
 * @author miluo
 * @date 2020-03-23
 */
public class NumWays {

    public static void main(String[] args){
        // 1 2
        System.out.println(numWays(2));
        // 1111111 111112 11122 1222 111121 11221 2221
        /*
            1111111
            111112 -> 11111  2 -> 111 22
            111121 -> 1111 2 1 -> 11 22  1
            111211 -> 111 2 11 -> 1 22  11
            121111 -> 1 2 1111 -> 1 2 1111
         */
        System.out.println(numWays(7));
    }

    /**
     * f(n) = f(n-1) + f(n-2) 斐波那契数列
     * @param n
     * @return
     */
    private static int numWays(int n){
        int pre = 1, behind = 1, sum = 0;
        for (int i = 0; i < n;i++){
            sum = (pre + behind) % 1000000007;
            pre = behind;
            behind = sum;
        }
        return pre;
    }

}
