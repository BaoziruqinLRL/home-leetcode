package com.yyhome.leetcode.easy;

/**
 * 1137 第N个泰波那契数
 * @author: lirl
 * @date: 2021/7/13
 */
public class Tribonacci {

    public static void main(String[] args){
        System.out.println(new Tribonacci().tribonacci(4));
        System.out.println(new Tribonacci().tribonacci(25));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:35.2 MB,击败了47.15% 的Java用户
     * @param n
     * @return
     */
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else {
            int t0 = 0, t1 = 1, t2 = 1, res = 0;
            for (int i = 3; i <= n; i++) {
                res = t0 + t1 + t2;
                t0 = t1;
                t1 = t2;
                t2 = res;
            }
            return res;
        }
    }
}
