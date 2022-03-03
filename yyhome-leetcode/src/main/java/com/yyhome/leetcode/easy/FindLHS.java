package com.yyhome.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 594 最长和谐子序列
 * @author: lirl
 * @date: 2021/3/30
 */
public class FindLHS {

    public static void main(String[] args){
        System.out.println(new FindLHS().findLHS(new int[]{1,3,2,2,5,2,3,7}));
        System.out.println(new FindLHS().findLHS(new int[]{1,2,3,4}));
        System.out.println(new FindLHS().findLHS(new int[]{1,1,1,1}));
    }

    /**
     * 22ms 52%
     * 40.3mb 57%
     * @param nums
     * @return
     */
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int n : nums){
            min = Math.min(min, n);
            max = Math.max(max, n);
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int maxCount = 0;
        for (int k : map.keySet()){
            if (map.containsKey(k - 1)){
                maxCount = Math.max(maxCount, map.get(k) + map.get(k - 1));
            }
            if (map.containsKey(k + 1)){
                maxCount = Math.max(maxCount, map.get(k) + map.get(k + 1));
            }
        }
        return maxCount;
    }
}
