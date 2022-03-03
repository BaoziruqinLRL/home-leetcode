package com.yyhome.leetcode.easy;

/**
 * 190 颠倒的二进制位
 * @author: lirl
 * @date: 2021/3/4
 */
public class ReverseBits {

    public static void main(String[] args){
        System.out.println(new ReverseBits().reverseBits(1));
        System.out.println(new ReverseBits().reverseBits(43261596));
        System.out.println(new ReverseBits().reverseBits(-3));
        System.out.println(new ReverseBits().reverseBits(Integer.MAX_VALUE));
        System.out.println(new ReverseBits().reverseBits(0b11111111111111111111111111111101));
    }

    /**
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:38.2 MB,击败了37.40% 的Java用户
     * @param n
     * @return
     */
    public int reverseBits(int n) {
        int res = 0;
        int i = 0;
        do {
            res = (res | (n & 1)) << 1;
            n = n >> 1;
            i++;
        } while (i < 31);
        res = res | (n & 1);
        return res;
    }
}
