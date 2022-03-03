package com.yyhome.leetcode.easy;

import java.util.Arrays;

/**
 * 561 数组拆分Ⅰ
 * @author: lirl
 * @date: 2021/3/29
 */
public class ArrayPairSum {

    public static void main(String[] args){
        System.out.println(new ArrayPairSum().arrayPairSum(new int[]{1,4,3,2}));
        System.out.println(new ArrayPairSum().arrayPairSum(new int[]{6,2,6,5,1,2}));
    }

    /**
     * 执行耗时:13 ms,击败了97.26% 的Java用户
     * 内存消耗:40.3 MB,击败了83.16% 的Java用户
     * @param nums
     * @return
     */
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length; i+=2){
            res += nums[i];
        }
        return res;
    }
}
