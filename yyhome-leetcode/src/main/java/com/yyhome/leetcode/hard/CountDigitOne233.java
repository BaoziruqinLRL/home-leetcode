package com.yyhome.leetcode.hard;

/**
 * 233 数字1的个数
 * @Author: linabell
 * @Date: 2023/6/28 11:11:36
 */
public class CountDigitOne233 {

    public static void main(String[] args) {
        System.out.println(new CountDigitOne233().countDigitOne(13));
        System.out.println(new CountDigitOne233().countDigitOne(0));
        System.out.println(new CountDigitOne233().countDigitOne(529));
    }

    static int[] biteNum;
    static {
        biteNum = new int[10];
        biteNum[1] = 1;
        for (int i = 2, pow = 10; i < 10; i++, pow *= 10) {
            biteNum[i] = 10 * biteNum[i-1] + pow;
        }
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.1 MB,击败了64.22% 的Java用户
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        if (n < 10) {
            return n >= 1 ? 1 : 0;
        }
        int length = String.valueOf(n).length();
        int a = n / (int) Math.pow(10, length - 1);
        int total = a * biteNum[length - 1] + (a > 1 ? (int) Math.pow(10, length - 1) : 0);
        int mode = n % (int) Math.pow(10, length - 1);
        if (a == 1) {
            total += mode + 1;
        }
        return total + countDigitOne(mode);
    }
}
