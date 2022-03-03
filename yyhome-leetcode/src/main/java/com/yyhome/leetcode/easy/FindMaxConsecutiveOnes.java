package com.yyhome.leetcode.easy;

/**
 * 485 最大连续1的个数
 * @author: lirl
 * @date: 2021/3/25
 */
public class FindMaxConsecutiveOnes {

    public static void main(String[] args){
        System.out.println(new FindMaxConsecutiveOnes().findMaxConsecutiveOnes(new int[]{1,1,0,1,1,1}));
    }

    /**
     * 执行耗时:2 ms,击败了89.22% 的Java用户
     * 内存消耗:40.3 MB,击败了5.34% 的Java用户
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        boolean start = false;
        int cu = 0;
        for (int n : nums){
            if (n == 1){
                start = true;
                cu++;
            }else if (n == 0 && start){
                start = false;
                max = Math.max(max, cu);
                cu = 0;
            }
        }
        return Math.max(max, cu);
    }
}
