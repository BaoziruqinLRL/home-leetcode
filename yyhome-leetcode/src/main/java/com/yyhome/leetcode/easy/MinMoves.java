package com.yyhome.leetcode.easy;

/**
 * 453 最小操作次数使数组元素相等
 * @author: lirl
 * @date: 2021/3/25
 */
public class MinMoves {

    public static void main(String[] args){
        System.out.println(new MinMoves().minMoves(new int[]{1,2,3}));
    }

    /**
     * 执行耗时:2 ms,击败了79.36% 的Java用户
     * 内存消耗:39 MB,击败了33.84% 的Java用户
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        if (nums.length <= 1){
            return 0;
        }
        int min = nums[0];
        for (int n : nums){
            min = Math.min(n, min);
        }
        int count = 0;
        for (int n : nums){
            count += n > min ? n - min : 0;
        }
        return count;
    }
}
