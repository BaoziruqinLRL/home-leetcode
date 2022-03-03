package com.yyhome.leetcode.easy;

/**
 * LCS 01 下载插件
 * @author: lirl
 * @date: 2021/7/16
 */
public class LeastMinutes {

    public static void main(String[] args) {
        System.out.println(new LeastMinutes().leastMinutes(2));
        System.out.println(new LeastMinutes().leastMinutes(9));
        System.out.println(new LeastMinutes().leastMinutes(4));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:35.1 MB,击败了72.99% 的Java用户
     * @param n
     * @return
     */
    public int leastMinutes(int n) {
        double log = Math.log(n) / Math.log(2);
        return (int) Math.ceil(log) + 1;
    }
}
