package com.yyhome.leetcode.middle;

/**
 * 面试题 08.05
 * @author: lirl
 * @date: 2021/5/17
 */
public class Multiply {

    public static void main(String[] main) {
        System.out.println(new Multiply().multiply(3, 4));
        System.out.println(new Multiply().multiply(1, 10));
        System.out.println(new Multiply().multiply(10, 13));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:34.9 MB,击败了93.70% 的Java用户
     * @param A
     * @param B
     * @return
     */
    public int multiply(int A, int B) {
        return cycle(A, B);
    }

    private int cycle(int a, int b) {
        if (b == 1) {
            return a;
        }
        int cycleRes = cycle(a, b/2);
        if (b % 2 == 0) {
            return cycleRes + cycleRes;
        } else {
            return cycleRes + cycleRes + a;
        }
    }
}
