package com.yyhome.leetcode.easy;

import java.util.Arrays;

/**
 * 628 三个数的最大乘积
 * @author: lirl
 * @date: 2021/3/30
 */
public class MaximumProduct {

    public static void main(String[] args){
        System.out.println(new MaximumProduct().maximumProduct(new int[]{1,2,3}));
        System.out.println(new MaximumProduct().maximumProduct(new int[]{1,2,3,4}));
        System.out.println(new MaximumProduct().maximumProduct(new int[]{-1,-2,-3}));
        System.out.println(new MaximumProduct().maximumProduct(new int[]{-90,-10,-5,0,1,2,10,12}));
    }

    /**
     * 执行耗时:12 ms,击败了73.31% 的Java用户
     * 内存消耗:39.8 MB,击败了82.20% 的Java用户
     * @param nums
     * @return
     */
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        return Math.max(nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3],
                nums[0] * nums[1] * nums[nums.length - 1]);
    }
}
