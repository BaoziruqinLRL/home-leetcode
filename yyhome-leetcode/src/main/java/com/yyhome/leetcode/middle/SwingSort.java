package com.yyhome.leetcode.middle;

import java.util.Arrays;

/**
 * 摆动排序 324
 * @author miluo
 * @date 2019-10-12
 */
public class SwingSort {

    public static void main(String[] args){
        int[] nums = new int[]{4,5,5,6};
        swingSort(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{1,2,1,2,1,2,1,2,1,2,1,2};
        swingSort(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{5,3,1,2,6,7,8,5,5};
        swingSort(nums);
        System.out.println(Arrays.toString(nums));
        swingSort(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{4,5,5,5,5,6,6,6};
        swingSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void swingSort(int[] nums){
        Arrays.sort(nums);
        int middle = (nums.length + 1) / 2;
        int[] newArr = new int[nums.length];
        int[] tempArr;
        System.arraycopy(nums, 0, newArr, 0, middle);
        int currentInsertIndex = 1;
        int initLength = middle;
        for (; currentInsertIndex < nums.length && initLength != nums.length; currentInsertIndex = currentInsertIndex + 2){
            tempArr = newArr;
            System.arraycopy(tempArr, currentInsertIndex, newArr, currentInsertIndex + 1, initLength - currentInsertIndex);
            newArr[currentInsertIndex] = nums[initLength];
            initLength += 1;
        }

        // 正序不满足,倒序
        boolean correct = true;
        for (int i =0; i < newArr.length - 1;i ++){
            if (i % 2 == 1){
                if (!(newArr[i] > newArr[i-1] && newArr[i] > newArr[i+1])){
                    correct = false;
                    break;
                }
            }
        }

        if (!correct) {
            for (int i = 0; i < nums.length / 2; i++) {
                int temp = nums[i];
                nums[i] = nums[nums.length - i - 1];
                nums[nums.length - i - 1] = temp;
            }
            newArr = new int[nums.length];
            System.arraycopy(nums, 0, newArr, 0, middle);
            currentInsertIndex = 0;
            initLength = middle;
            for (; currentInsertIndex < nums.length && initLength != nums.length; currentInsertIndex = currentInsertIndex + 2) {
                tempArr = newArr;
                System.arraycopy(tempArr, currentInsertIndex, newArr, currentInsertIndex + 1, initLength - currentInsertIndex);
                newArr[currentInsertIndex] = nums[initLength];
                initLength += 1;
            }
        }
        System.arraycopy(newArr, 0, nums, 0, nums.length);
    }
}
