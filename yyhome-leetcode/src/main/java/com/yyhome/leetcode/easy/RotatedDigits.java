package com.yyhome.leetcode.easy;

/**
 * 788 旋转数字
 * @author: lirl
 * @date: 2021/7/12
 */
public class RotatedDigits {

    public static void main(String[] args){
        System.out.println(new RotatedDigits().rotatedDigits(2));
        System.out.println(new RotatedDigits().rotatedDigits(857));
        System.out.println(new RotatedDigits().rotatedDigits(10));
        System.out.println(new RotatedDigits().rotatedDigits(20));
        System.out.println(new RotatedDigits().rotatedDigits(30));
        System.out.println(new RotatedDigits().rotatedDigits(40));
        System.out.println(new RotatedDigits().rotatedDigits(100));
    }

    int[] temp = new int[]{0, 0, 1, -1, -1, 1, 1, -1, 0, 1};

    /**
     * 执行耗时:3 ms,击败了92.37% 的Java用户
     * 内存消耗:35.6 MB,击败了39.52% 的Java用户
     * @param n
     * @return
     */
    public int rotatedDigits(int n) {
        int count = 0;
        int[] dp = new int[n+1];
        for (int i = 0; i <= Math.min(n, 9); i++) {
            dp[i] = temp[i];
            if (temp[i] == 1) {
                count++;
            }
        }
        int max = 99, min = 10;
        int unit = 10;
        for (int i = 10; i <= n; i++) {
            if (max < min) {
                unit *= 10;
                max = unit * 10 - 1;
                min = unit;
            }
            int t = i / unit, p = i % unit;
            dp[i] = (dp[t] < 0 || dp[p] < 0) ? -1 : (dp[t] > 0 || dp[p] > 0) ? 1 : 0;
            max--;
            if (dp[i] > 0) {
                count++;
            }
        }
        return count;
    }
}
