package com.yyhome.leetcode.easy;

/**
 * 509 斐波那契数
 * @author: lirl
 * @date: 2021/7/13
 */
public class Fib {

    public static void main(String[] args){
        System.out.println(new Fib().fib(4));
        System.out.println(new Fib().fib(10));
    }

    int last = 0, pre = 1;

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:35.2 MB,击败了36.93% 的Java用户
     * 动态规划做法。还可以递归
     * @param n
     * @return
     */
    public int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int res = 0;
            for (int i = 2; i <= n; i++) {
                res = last + pre;
                last = pre;
                pre = res;
            }
            return res;
        }
    }
}
