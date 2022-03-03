package com.yyhome.leetcode.middle;

import java.util.Arrays;

/**
 * 31 下一个排列
 * @author: lirl
 * @date: 2021/4/12
 */
public class NextPermutation {

    public static void main(String[] args){
        int[] nums = new int[]{1,2,3};
        new NextPermutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{3,2,1};
        new NextPermutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{1,2,3,5,4};
        new NextPermutation().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 执行耗时:1 ms,击败了98.33% 的Java用户
     * 内存消耗:38.2 MB,击败了99.02% 的Java用户
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        boolean b = true;
        for (int i = nums.length - 1; i >= 0; i--){
            int minIndex = -1;
            for (int j = i + 1; j < nums.length; j++){
                if (nums[j] > nums[i]) {
                    if (minIndex == -1 || nums[j] < nums[minIndex]) {
                        minIndex = j;
                    }
                }
            }
            if (minIndex != -1){
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
                Arrays.sort(nums,i + 1, nums.length);
                b = false;
                break;
            }
        }
        if (b) {
            Arrays.sort(nums);
        }
    }
}
