package com.yyhome.leetcode.easy;

/**
 * 665 非递减数列
 * @author: lirl
 * @date: 2021/3/31
 */
public class CheckPossibility {

    public static void main(String[] args) {
        System.out.println(new CheckPossibility().checkPossibility(new int[]{3,4,2,3}));
        System.out.println(new CheckPossibility().checkPossibility(new int[]{4,2,3}));
        System.out.println(new CheckPossibility().checkPossibility(new int[]{4,2,1}));
    }

    /**
     * 执行耗时:1 ms,击败了99.98% 的Java用户
     * 内存消耗:39.5 MB,击败了94.76% 的Java用户
     * @param nums
     * @return
     */
    public boolean checkPossibility(int[] nums) {
        int jump = 0;
        for (int i = 0; i < nums.length - 1 && jump <= 1; i++){
            if (nums[i] > nums[i + 1]){
                if ((i <= nums.length - 3 && nums[i] > nums[i + 2]) && (i >= 1 && nums[i - 1] > nums[i + 1])){
                    return false;
                }
                jump++;
            }
        }
        return jump <= 1;
    }
}
