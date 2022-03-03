package com.yyhome.leetcode.easy;

/**
 * 598 范围求和Ⅱ
 * @author: lirl
 * @date: 2021/3/30
 */
public class MaxCount {

    public static void main(String[] args){
        System.out.println(new MaxCount().maxCount(3,3,new int[][]{{2,2},{3,3}}));
        System.out.println(new MaxCount().maxCount(3,3,new int[][]{}));
    }

    /**
     * 执行耗时:1 ms,击败了74.92% 的Java用户
     * 内存消耗:38.2 MB,击败了77.99% 的Java用户
     * @param m
     * @param n
     * @param ops
     * @return
     */
    public int maxCount(int m, int n, int[][] ops) {
        if (ops == null || ops.length == 0){
            return m*n;
        }
        int mi = Integer.MAX_VALUE;
        int mj = Integer.MAX_VALUE;
        for (int i = 0; i < ops.length; i++){
            mi = Math.min(mi, ops[i][0]);
            mj = Math.min(mj, ops[i][1]);
        }
        return mi * mj;
    }
}
