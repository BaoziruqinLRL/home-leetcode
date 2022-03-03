package com.yyhome.leetcode.easy;

/**
 * 461 汉明距离
 * @author: lirl
 * @date: 2021/3/25
 */
public class HammingDistance {

    public static void main(String[] args){
        System.out.println(new HammingDistance().hammingDistance(1,4));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:35.2 MB,击败了70.16% 的Java用户
     * @param x
     * @param y
     * @return
     */
    public int hammingDistance(int x, int y) {
        int r = x ^ y;
        int count = 0;
        for (int i = 0; i < 32; i++){
            count += (r >> i) & 1;
        }
        return count;
    }
}
