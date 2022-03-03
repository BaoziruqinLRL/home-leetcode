package com.yyhome.leetcode.easy;

import java.util.Arrays;

/**
 * 283 移动零
 * @author: lirl
 * @date: 2021/3/23
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] array = new int[]{0,1,0,3,12};
        new MoveZeroes().moveZeroes(array);
        System.out.println(Arrays.toString(array));

        array = new int[]{1,3,12,0,0};
        new MoveZeroes().moveZeroes(array);
        System.out.println(Arrays.toString(array));

    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.6 MB,击败了75.94% 的Java用户
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int current = 0;
        for (int index = 0; index < nums.length;){
            if (nums[index] == 0){
                index++;
            } else {
                nums[current++] = nums[index++];
            }
        }
        for (; current < nums.length; current++){
            nums[current] = 0;
        }
    }
}
