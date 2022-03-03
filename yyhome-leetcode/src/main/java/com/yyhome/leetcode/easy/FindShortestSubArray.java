package com.yyhome.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 697 数组的度
 * @author: lirl
 * @date: 2021/4/1
 */
public class FindShortestSubArray {

    public static void main(String[] args){
        System.out.println(new FindShortestSubArray().findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
        System.out.println(new FindShortestSubArray().findShortestSubArray(new int[]{1,2,2,3,1,4,2}));

        System.out.println(new FindShortestSubArray().findShortestSubArray2(new int[]{1, 2, 2, 3, 1}));
        System.out.println(new FindShortestSubArray().findShortestSubArray2(new int[]{1,2,2,3,1,4,2}));

    }

    /**
     * 执行耗时:228 ms,击败了5.01% 的Java用户
     * 内存消耗:43.7 MB,击败了16.17% 的Java用户
     * @param nums
     * @return
     */
    public int findShortestSubArray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int n : nums){
            int v = map.getOrDefault(n,0) + 1;
            map.put(n, v);
            max = Math.max(max, v);
        }
        for (Map.Entry<Integer,Integer> e : map.entrySet()){
            if (e.getValue() == max){
                int head = 0, tail = nums.length - 1;
                while (nums[head] != e.getKey()) {
                    head++;
                }
                while (nums[tail] != e.getKey()){
                    tail--;
                }
                min = Math.min(min, tail - head + 1);
            }
        }
        return min;
    }

    /**
     * 执行耗时:28 ms,击败了29.37% 的Java用户
     * 内存消耗:42.7 MB,击败了66.08% 的Java用户
     * @param nums
     * @return
     */
    public int findShortestSubArray2(int[] nums) {
        Map<Integer, Integer> startMap = new HashMap<>();
        Map<Integer, Integer> lastMap = new HashMap<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++){
            if (!startMap.containsKey(nums[i])){
                startMap.put(nums[i], i);
            }
            lastMap.put(nums[i], i);
            int v = countMap.getOrDefault(nums[i], 0) + 1;
            countMap.put(nums[i], v);
            max = Math.max(max, v);
        }
        for (Map.Entry<Integer, Integer> e : countMap.entrySet()){
            if (e.getValue() == max){
                min = Math.min(min, lastMap.get(e.getKey()) - startMap.get(e.getKey()));
            }
        }
        return min + 1;
    }
}
