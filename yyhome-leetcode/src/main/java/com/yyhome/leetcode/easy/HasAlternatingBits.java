package com.yyhome.leetcode.easy;

/**
 * 693 交替位二进制数
 * @author: lirl
 * @date: 2021/4/1
 */
public class HasAlternatingBits {

    public static void main(String[] args){
        System.out.println(new HasAlternatingBits().hasAlternatingBits(2));
        System.out.println(new HasAlternatingBits().hasAlternatingBits(4));
        System.out.println(new HasAlternatingBits().hasAlternatingBits(5));
        System.out.println(new HasAlternatingBits().hasAlternatingBits(7));
        System.out.println(new HasAlternatingBits().hasAlternatingBits(11));
        System.out.println(new HasAlternatingBits().hasAlternatingBits(10));
        System.out.println(new HasAlternatingBits().hasAlternatingBits(3));
        System.out.println(new HasAlternatingBits().hasAlternatingBits(15));
    }

    /**
     * 0 ms 100%
     * 35.5 MB 11%
     * @param n
     * @return
     */
    public boolean hasAlternatingBits(int n) {
        int r = (n & 1) ^ 1;
        n = n >> 1;
        int v = 0;
        for (int i = 0; i < 31 - 1 && n >= 1; i++){
            if (((n & 1) ^ v) != r){
                return false;
            }
            n = n >> 1;
            v = v ^ 0b1;
        }
        return true;
    }
}
