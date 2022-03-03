package com.yyhome.leetcode.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * 198 打家劫舍
 * @author: lirl
 * @date: 2021/3/26
 */
public class Rob {

    public static void main(String[] args){
        System.out.println(new Rob().rob(new int[]{1,2,1,1}));
        System.out.println(new Rob().rob(new int[]{1,3,1}));
        System.out.println(new Rob().rob(new int[]{1,2,3,1}));
        System.out.println(new Rob().rob(new int[]{2,7,9,3,1}));

        System.out.println(new Rob().robDPS(new int[]{4,1,2,7}));
        System.out.println(new Rob().robDPS(new int[]{1,2,1,1}));
        System.out.println(new Rob().robDPS(new int[]{1,3,1}));
        System.out.println(new Rob().robDPS(new int[]{1,2,3,1}));
        System.out.println(new Rob().robDPS(new int[]{2,7,9,3,1}));
    }

    /**
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:36.1 MB,击败了5.29% 的Java用户
     * 递归
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        return Math.max(cycle(nums, 0, map), cycle(nums, 1, map));
    }

    public int cycle(int[] nums, int start, Map<Integer, Integer> map){
        if (map.containsKey(start)){
            return map.get(start);
        }
        int v;
        if (start > nums.length - 1){
            v = 0;
        } else if (start == nums.length - 1){
            v = nums[start];
        } else if (start == nums.length - 2){
            v = Math.max(nums[start], nums[start + 1]);
        } else {
            v = nums[start] + Math.max(cycle(nums, start + 2, map), cycle(nums, start + 3, map));
        }
        map.put(start, v);
        return v;
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:35.8 MB,击败了57.10% 的Java用户
     * 动态规划
     * @param nums
     * @return
     */
    public int robDPS(int[] nums) {
        if (nums.length == 0){
            return 0;
        } else if (nums.length == 1){
            return nums[0];
        } else if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        } else {
            int[] map = new int[nums.length];
            map[0] = nums[0];
            map[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < nums.length; i++){
                map[i] = Math.max(map[i - 2] + nums[i], map[i - 1]);
            }
            return map[nums.length - 1];
        }
    }
}
