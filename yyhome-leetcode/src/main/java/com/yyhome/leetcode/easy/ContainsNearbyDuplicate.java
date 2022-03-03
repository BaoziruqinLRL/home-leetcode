package com.yyhome.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 219 存在重复元素Ⅱ
 * @author: lirl
 * @date: 2021/3/11
 */
public class ContainsNearbyDuplicate {

    public static void main(String[] args) {
        System.out.println(new ContainsNearbyDuplicate().containsNearbyDuplicate(new int[]{1,2,3,1},3));
        System.out.println(new ContainsNearbyDuplicate().containsNearbyDuplicate(new int[]{1,0,1,1},1));
        System.out.println(new ContainsNearbyDuplicate().containsNearbyDuplicate(new int[]{1,2,3,1,2,3},2));
    }

    /**
     * 执行耗时:8 ms,击败了94.84% 的Java用户
     * 内存消耗:44.3 MB,击败了12.69% 的Java用户
     * @param nums
     * @param k
     * @return
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++){
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k){
                return true;
            }else{
                map.put(nums[i],i);
            }
        }
        return false;
    }
}
