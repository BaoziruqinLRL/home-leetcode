package com.yyhome.leetcode.middle;

/**
 * 50 pow(x,n)
 * @author: lirl
 * @date: 2021/4/14
 */
public class MyPow {

    public static void main(String[] args) {
        System.out.println(new MyPow().myPow(2d, -2147483648));
        System.out.println(new MyPow().myPow(0.00001, 2147483647));
        System.out.println(new MyPow().myPow(2d, 10));
        System.out.println(new MyPow().myPow(2.1d, 3));
        System.out.println(new MyPow().myPow(2d, -2));
    }

    /**
     * 执行耗时:1 ms,击败了98.85% 的Java用户
     * 内存消耗:37.9 MB,击败了22.98% 的Java用户
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1d;
        }
        int sign = n < 0 ? -1 : 1;
        double res = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                res *= x;
            }
            x *= x;
            n /= 2;
        }
        return sign < 0 ? 1/res : res;
    }
}
