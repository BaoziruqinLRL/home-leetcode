package com.yyhome.leetcode.easy;

import java.util.Arrays;

/**
 * 136 只出现一次的数字
 * @author: lirl
 * @date: 2021/3/4
 */
public class SingleNumber {

    public static void main(String[] args) {
        System.out.println(new SingleNumber().singleNumber(new int[]{2,2,1}));
        System.out.println(new SingleNumber().singleNumber(new int[]{4,1,2,1,2}));

        System.out.println(new SingleNumber().singleNumber2(new int[]{2,2,1}));
        System.out.println(new SingleNumber().singleNumber2(new int[]{4,1,2,1,2}));
    }

    /**
     * 执行耗时:7 ms,击败了31.50% 的Java用户
     * 内存消耗:38.9 MB,击败了20.32% 的Java用户
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i+=2){
            if (nums[i] == nums[i + 1]){
                continue;
            }
            if (i > 0 && nums[i - 1] == nums[i]){
                return nums[i + 1];
            }else if (nums[i + 1] == nums[i + 2]){
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    /**
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:38.4 MB,击败了88.25% 的Java用户
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums){
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        return res;
    }
}
