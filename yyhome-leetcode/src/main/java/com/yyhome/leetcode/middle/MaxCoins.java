package com.yyhome.leetcode.middle;

import java.util.Arrays;

/**
 * @Author: linabell
 * @Date: 2022/3/2 18:16
 */
public class MaxCoins {

    public static void main(String[] args){
        System.out.println(new MaxCoins().maxCoins(new int[]{2,4,1,2,7,8}));
        System.out.println(new MaxCoins().maxCoins(new int[]{2,4,5}));
        System.out.println(new MaxCoins().maxCoins(new int[]{9,8,7,6,5,1,2,3,4}));
    }

    /**
     * 执行耗时:29 ms,击败了82.72% 的Java用户
     * 内存消耗:50 MB,击败了19.93% 的Java用户
     * @param piles
     * @return
     */
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int total = 0;
        for (int i = 0; i < piles.length / 3; i++) {
            total += piles[(piles.length - 1) - (i * 2) - 1];
        }
        return total;
    }
}
