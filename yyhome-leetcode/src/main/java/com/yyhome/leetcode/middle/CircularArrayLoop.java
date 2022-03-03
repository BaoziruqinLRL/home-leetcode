package com.yyhome.leetcode.middle;

import java.util.HashSet;

/**
 * 环形数组 , 效率不高 457
 * @author miluo
 * @date 2019-10-31
 */
public class CircularArrayLoop {

    public static void main(String[] args){
        System.out.println(circularArrayLoop(new int[]{2, -1, 1, 2, 2}));
        System.out.println(circularArrayLoop(new int[]{-1,2}));
        System.out.println(circularArrayLoop(new int[]{-2,1,-1,-2,-2}));
        System.out.println(circularArrayLoop(new int[]{1,2,3,4,5}));
        System.out.println(circularArrayLoop(new int[]{-2,-3,-9}));
        System.out.println(circularArrayLoop(new int[]{3,1,2}));
        System.out.println(circularArrayLoop(new int[]{1,1}));
    }

    private static boolean circularArrayLoop(int[] nums) {
        if (nums.length < 2){
            return false;
        }
        for (int index = 0; index < nums.length; index++){
            if (isCircle(index,nums)){
                return true;
            }
        }
        return false;
    }

    private static boolean isCircle(int index, int[] nums){
        HashSet<Integer> indexSet = new HashSet<>();
        int currentIndex = index;
        int currentVal = nums[index];
        int pathLength = -1;
        while (!indexSet.contains(currentIndex)){
            if (nums[currentIndex] * currentVal < 0){
                return false;
            }else{
                pathLength++;
                indexSet.add(currentIndex);
                currentIndex = currentIndex + nums[currentIndex];
                if (currentIndex >= nums.length){
                    currentIndex = currentIndex % nums.length;
                }else if (currentIndex < 0){
                    currentIndex = nums.length - (nums.length - currentIndex) % nums.length;
                }
            }
        }
        return currentIndex == index && pathLength > 0;
    }
}
