package com.yyhome.leetcode.middle;

/**
 * 162 寻找峰值
 * @Author: lrl
 * @Date: 2023/9/7 15:33:37
 */
public class FindPeakElement162 {

    public static void main(String[] args){
        System.out.println(new FindPeakElement162().findPeakElement(new int[]{1,2,3,1}));
        System.out.println(new FindPeakElement162().findPeakElement(new int[]{1,9,1,3,5,6,4}));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:40 MB,击败了78.34% 的Java用户
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
