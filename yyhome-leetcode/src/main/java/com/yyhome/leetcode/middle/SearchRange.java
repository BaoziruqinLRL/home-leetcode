package com.yyhome.leetcode.middle;

import java.util.Arrays;

/**
 * 34 在排序数组中查找元素的第一个和最后一个位置
 * @author: lirl
 * @date: 2021/4/12
 */
public class SearchRange {

    public static void main(String[] args){
        System.out.println(Arrays.toString(new SearchRange().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(new SearchRange().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(new SearchRange().searchRange(new int[]{1}, 1)));
        System.out.println(Arrays.toString(new SearchRange().searchRange(new int[]{1,2}, 2)));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:42 MB,击败了6.19% 的Java用户
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                int i = middle;
                while (i >= 0 && nums[i] == target) {
                    i--;
                }
                int j = middle;
                while (j < nums.length && nums[j] == target) {
                    j++;
                }
                return new int[]{i + 1, j - 1};
            }
        }
        return new int[]{-1,-1};
    }
}
