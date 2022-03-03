package com.yyhome.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1 两数之和
 * @author miluo
 * @date 2020-03-17
 */
public class TwoSum {

    public static void main(String[] args){
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{-2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSumHash(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSumHash(new int[]{-2, 7, 11, 15}, 9)));
    }

    private static int[] twoSum(int[] nums, int target) {
        for (int index = 0; index < nums.length; index++){
            for (int in = index + 1; in < nums.length; in++){
                if (nums[in] + nums[index] == target){
                    return new int[]{index,in};
                }
            }
        }
        return nums;
    }

    private static int[] twoSumHash(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>(nums.length);
        for (int index = 0; index < nums.length; index++){
            int left = target - nums[index];
            if (map.containsKey(left)){
                return new int[]{map.get(left),index};
            }else{
                map.put(nums[index],index);
            }
        }
        return nums;
    }
}
