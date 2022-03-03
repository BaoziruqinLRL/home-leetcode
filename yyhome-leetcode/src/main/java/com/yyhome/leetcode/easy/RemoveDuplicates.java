package com.yyhome.leetcode.easy;

/**
 * 26 删除排序数组中的重复
 * @author miluo
 * @date 2020-07-08
 */
public class RemoveDuplicates {

    public static void main(String[] args){
        System.out.println(new RemoveDuplicates().removeDuplicates(new int[]{1,1,2}));
        System.out.println(new RemoveDuplicates().removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }

    /**
     * 执行耗时:1 ms,击败了97.99% 的Java用户
     * 内存消耗:41.5 MB,击败了5.74% 的Java用户
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int newPoint = 0;
        int index = 0;
        while (index < nums.length){
            nums[newPoint++] = nums[index];
            int temp = nums[index];
            while (++index < nums.length && nums[index] == temp){
                continue;
            }
        }
        return newPoint;
    }
}
