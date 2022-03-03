package com.yyhome.leetcode.easy;

/**
 * 53 最大子序和
 * @author miluo
 * @date 2020-07-09
 */
public class MaxSubArray {

    public static void main(String[] args) {
        System.out.println(new MaxSubArray().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(new MaxSubArray().maxSubArray(new int[]{-50,52,-1,1,2,3}));
    }

    /**
     * 执行耗时:1 ms,击败了95.18% 的Java用户
     * 内存消耗:39.6 MB,击败了40.45% 的Java用户
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int nu : nums){
            if (sum > 0){
                sum += nu;
            }else{
                sum = nu;
            }
            res = res > sum ? res : sum;
        }
        return res;
    }
}
