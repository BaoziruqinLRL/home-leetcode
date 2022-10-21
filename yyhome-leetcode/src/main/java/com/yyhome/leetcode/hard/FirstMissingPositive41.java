package com.yyhome.leetcode.hard;

/**
 * 41 缺失的第一个正数
 * @Author: linabell
 * @Date: 2022/10/21 10:52:11
 */
public class FirstMissingPositive41 {

    public static void main(String[] args) {
        System.out.println(new FirstMissingPositive41().firstMissingPositive(new int[]{2,1}));
        System.out.println(new FirstMissingPositive41().firstMissingPositive(new int[]{1,1}));
        System.out.println(new FirstMissingPositive41().firstMissingPositive(new int[]{1}));
        System.out.println(new FirstMissingPositive41().firstMissingPositive(new int[]{1,2,3}));
        System.out.println(new FirstMissingPositive41().firstMissingPositive(new int[]{1,2,0}));
        System.out.println(new FirstMissingPositive41().firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(new FirstMissingPositive41().firstMissingPositive(new int[]{7,8,9,11,12}));
    }

    /**
     * 遍历一次数组把大于等于1的和小于数组大小的值放到原数组对应位置，然后再遍历一次数组查当前下标是否和值对应，如果不对应那这个下标就是答案，否则遍历完都没出现那么答案就是数组长度加1。
     * 执行耗时:1 ms,击败了96.86% 的Java用户
     * 内存消耗:49.2 MB,击败了87.79% 的Java用户
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && nums[i] <= nums.length && nums[i] != i+1) {
                int temp = nums[i];
                int num = nums[temp - 1];
                if (temp != num) {
                    nums[i] = num;
                    nums[temp-1] = temp;
                    i--;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) {
                return i+1;
            }
        }
        return nums.length+1;
    }
}
