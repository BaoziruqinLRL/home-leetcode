package com.yyhome.leetcode.easy;

/**
 * 643 子数组的最大平均数Ⅰ
 * @author: lirl
 * @date: 2021/3/31
 */
public class FindMaxAverage {

    public static void main(String[] args) {
        System.out.println(new FindMaxAverage().findMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
        System.out.println(new FindMaxAverage().findMaxAverage(new int[]{3,3,4,3,0}, 3));
    }

    /**
     * 执行耗时:2 ms,击败了100.00% 的Java用户
     * 内存消耗:42.7 MB,击败了60.11% 的Java用户
     * @param nums
     * @param k
     * @return
     */
    public double findMaxAverage(int[] nums, int k) {
        long total = 0;
        for (int i = 0; i < k; i++){
            total += nums[i];
        }
        if (nums.length == k){
            return (double) total / k;
        }
        long current = total;
        for (int i = k; i < nums.length; i++){
            current = current + nums[i] - nums[i - k];
            total = Math.max(total, current);
        }
        return (double) total / k;
    }
}
