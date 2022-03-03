package com.yyhome.leetcode.easy;

/**
 * 674 最长连续递增序咧
 * @author: lirl
 * @date: 2021/3/31
 */
public class FindLengthOfLCIS {

    public static void main(String[] args){
        System.out.println(new FindLengthOfLCIS().findLengthOfLCIS(new int[]{1,3,5,4,7}));
        System.out.println(new FindLengthOfLCIS().findLengthOfLCIS(new int[]{2,2,2,2,2}));
    }

    /**
     * 执行耗时:1 ms,击败了99.93% 的Java用户
     * 内存消耗:39.3 MB,击败了58.11% 的Java用户
     * @param nums
     * @return
     */
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length <= 1){
            return nums.length;
        }
        int start = 0;
        int end = 1;
        int max = 1;
        while (end < nums.length){
            if (nums[end] <= nums[end - 1]){
                max = Math.max(max, end - start);
                start = end;
            }
            end++;
        }
        return Math.max(max, end - start);
    }
}
