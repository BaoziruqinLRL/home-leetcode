package com.yyhome.leetcode.easy;

/**
 * 191 位1的个数
 * @author: lirl
 * @date: 2021/3/3
 */
public class HammingWeight {

    public static void main(String[] args){
        System.out.println(new HammingWeight().hammingWeight(1));
        System.out.println(new HammingWeight().hammingWeight(10));
        System.out.println(new HammingWeight().hammingWeight(Integer.MAX_VALUE));
    }

    /**
     * 执行耗时:1 ms,击败了95.56% 的Java用户
     * 内存消耗:35.5 MB,击败了30.10% 的Java用户
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int i = 0;
        int count = 0;
        do {
            count += (n & 1) == 0 ? 0 : 1;
            i++;
            n = n >> 1;
        } while (i < 32);
        return count;
    }
}
