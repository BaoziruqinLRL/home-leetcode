package com.yyhome.leetcode.easy;

import java.util.Arrays;

/**
 * 645 错误的集合
 * @author: lirl
 * @date: 2021/3/31
 */
public class FindErrorNums {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindErrorNums().findErrorNums(new int[]{1,2,2,4})));
        System.out.println(Arrays.toString(new FindErrorNums().findErrorNums(new int[]{1,1})));
        System.out.println(Arrays.toString(new FindErrorNums().findErrorNums(new int[]{1,5,3,2,2,7,6,4,8,9})));
        System.out.println(Arrays.toString(new FindErrorNums().findErrorNums(new int[]{1,4,6,3,3,5})));
        System.out.println(Arrays.toString(new FindErrorNums().findErrorNums(new int[]{3,2,3,4,6,5})));
    }

    /**
     * 执行耗时:13 ms,击败了29.88% 的Java用户
     * 内存消耗:40.1 MB,击败了42.55% 的Java用户
     * @param nums
     * @return
     */
    public int[] findErrorNums(int[] nums) {
        if (nums.length == 2){
            return new int[]{nums[0] == 1 ? 1 : 2, nums[0] == 1 ? 2 : 1};
        }
        Arrays.sort(nums);
        int last = 0;
        int miss = 0;
        int repeat = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] - last == 2){
                miss = nums[i] - 1;
            }
            if (nums[i] - last == 0){
                repeat = nums[i];
            }
            last = nums[i];
        }
        return new int[]{repeat, miss == 0 ? nums.length : miss};
    }
}
