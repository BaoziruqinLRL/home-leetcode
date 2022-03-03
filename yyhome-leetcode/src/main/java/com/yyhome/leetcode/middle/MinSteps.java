package com.yyhome.leetcode.middle;

/**
 * 650 只有两个键的键盘
 * @Author: linabell
 * @Date: 2022/3/3 13:52
 */
public class MinSteps {

    public static void main(String[] args){
        System.out.println(new MinSteps().minSteps(9));
        System.out.println(new MinSteps().minSteps(8));
        System.out.println(new MinSteps().minSteps(7));
        System.out.println(new MinSteps().minSteps(6));
        System.out.println(new MinSteps().minSteps(5));
        System.out.println(new MinSteps().minSteps(4));
        System.out.println(new MinSteps().minSteps(3));
        System.out.println(new MinSteps().minSteps(1));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.2 MB,击败了32.05% 的Java用户
     * @param n
     * @return
     */
    public int minSteps(int n) {
        if (n == 3) {
            return 3;
        } else if (n == 2) {
            return 2;
        } else if (n == 1) {
            return 0;
        }
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0) {
                return minSteps(n / i) + i;
            }
        }
        return n;
    }
}
