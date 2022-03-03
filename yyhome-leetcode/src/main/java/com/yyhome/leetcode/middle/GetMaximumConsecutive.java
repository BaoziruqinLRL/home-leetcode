package com.yyhome.leetcode.middle;

import java.util.Arrays;

/**
 * 1798 构造连续值的最大数目
 * @author: lirl
 * @date: 2021/6/30
 */
public class GetMaximumConsecutive {

    public static void main(String[] args){
        System.out.println(new GetMaximumConsecutive().getMaximumConsecutive(new int[]{1,4,10,3,1}));
        System.out.println(new GetMaximumConsecutive().getMaximumConsecutive(new int[]{1,1,1,4}));
        System.out.println(new GetMaximumConsecutive().getMaximumConsecutive(new int[]{1,3}));
    }

    /**
     * 执行耗时:23 ms,击败了9.20% 的Java用户
     * 内存消耗:46.1 MB,击败了40.65% 的Java用户
     * @param coins
     * @return
     */
    public int getMaximumConsecutive(int[] coins) {
        Arrays.sort(coins);
        int count = 0;
        for (int c : coins) {
            if (c <= count + 1) {
                count += c;
            } else {
                break;
            }
        }
        return count + 1;
    }
}
