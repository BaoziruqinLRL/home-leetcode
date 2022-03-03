package com.yyhome.leetcode.middle;

/**
 * 213 打家劫舍Ⅱ
 * @author: lirl
 * @date: 2021/7/27
 */
public class Rob2 {

    public static void main(String[] args){
        System.out.println(new Rob2().rob(new int[]{4,1,2,7,5,3,1}));
        System.out.println(new Rob2().rob(new int[]{1,1,1,2}));
        System.out.println(new Rob2().rob(new int[]{1,3,4,19}));
        System.out.println(new Rob2().rob(new int[]{2,3,2}));
        System.out.println(new Rob2().rob(new int[]{1,2,3,1}));
        System.out.println(new Rob2().rob(new int[]{0}));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:35.9 MB,击败了28.98% 的Java用户
     * 分别计算1 ~ n-1 和 2 ~ n 的最大值
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else if (nums.length == 3) {
            return Math.max(nums[0], Math.max(nums[1], nums[2]));
        } else {
            int[] dp1 = new int[3], dp2 = new int[3];
            dp1[0] = nums[0];
            dp1[1] = Math.max(nums[0], nums[1]);
            dp2[0] = nums[1];
            dp2[1] = Math.max(nums[1], nums[2]);
            for (int i = 2; i < nums.length - 1; i++) {
                dp1[2] = Math.max(dp1[0] + nums[i], dp1[1]);
                dp1[0] = dp1[1];
                dp1[1] = dp1[2];
            }
            for (int i = 3; i < nums.length; i++) {
                dp2[2] = Math.max(dp2[0] + nums[i], dp2[1]);
                dp2[0] = dp2[1];
                dp2[1] = dp2[2];
            }
            return Math.max(dp1[2], dp2[2]);
        }
    }

}
