package com.yyhome.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * 217 存在重复元素
 * @author: lirl
 * @date: 2021/3/11
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        System.out.println(new ContainsDuplicate().containsDuplicate(new int[]{1,2,3,1}));
        System.out.println(new ContainsDuplicate().containsDuplicate(new int[]{1,2,3,4,5,6,7,8,9,10,11}));
        System.out.println(new ContainsDuplicate().containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }

    /**
     * 执行耗时:8 ms,击败了46.92% 的Java用户
     * 内存消耗:42.5 MB,击败了64.12% 的Java用户
     * @param nums
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            set.add(nums[i]);
            if (set.size() < i + 1){
                return true;
            }
        }
        return false;
    }
}
