package com.yyhome.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 762 二进制表示中质数个计算置位
 * @author: lirl
 * @date: 2021/4/6
 */
public class CountPrimeSetBits {

    public static void main(String[] args){
        System.out.println(new CountPrimeSetBits().countPrimeSetBits(6,10));
        System.out.println(new CountPrimeSetBits().countPrimeSetBits(10,15));
    }

    Set<Integer> zs = new HashSet<Integer>(){{
        add(2);
        add(3);
        add(5);
        add(7);
        add(11);
        add(13);
        add(17);
        add(19);
        add(23);
        add(29);
        add(31);
    }};

    /**
     * 执行耗时:16 ms,击败了33.55% 的Java用户
     * 内存消耗:35.1 MB,击败了90.07% 的Java用户
     * @param L
     * @param R
     * @return
     */
    public int countPrimeSetBits(int L, int R) {
        int res = 0;
        for (int i = L; i <= R; i++){
            int n = i, count = 0;
            while (n > 0){
                count += (n & 1);
                n >>= 1;
            }
            if (zs.contains(count)){
                res++;
            }
        }
        return res;
    }
}
