package com.yyhome.leetcode.middle;

import java.util.Arrays;

/**
 * 80 删除有序数组中的重复项Ⅱ
 * @author lirl
 * @date 2021/4/28 18:13
 */
public class RemoveDuplicates {

    public static void main(String[] args){
        int[] nums = new int[]{1,1,1,2,2,3};
        System.out.println(new RemoveDuplicates().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
        nums = new int[]{0,0,1,1,1,1,2,3,3};
        System.out.println(new RemoveDuplicates().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 执行耗时:1 ms,击败了67.50% 的Java用户
     * 内存消耗:38.8 MB,击败了12.81% 的Java用户
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int count = 0, cur = nums[0], total = 0, curPos = 0;
        for (int n : nums) {
            if (n == cur) {
                count++;
                if (count <= 2) {
                    nums[curPos++] = n;
                }
            } else {
                count = 1;
                cur = n;
                nums[curPos++] = n;
            }
            total += count <= 2 ? 1 : 0;
        }
        return total;
    }
}
