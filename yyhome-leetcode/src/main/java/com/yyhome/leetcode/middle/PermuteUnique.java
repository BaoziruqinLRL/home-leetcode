package com.yyhome.leetcode.middle;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 47 全排列Ⅱ
 * @author: lirl
 * @date: 2021/4/13
 */
public class PermuteUnique {

    public static void main(String[] args){
        System.out.println(JSON.toJSONString(new PermuteUnique().permuteUnique(new int[]{3,3,0,3})));
        System.out.println(JSON.toJSONString(new PermuteUnique().permuteUnique(new int[]{1,1,2})));
        System.out.println(JSON.toJSONString(new PermuteUnique().permuteUnique(new int[]{1,2,3})));
    }

    /**
     * 执行耗时:5 ms,击败了19.03% 的Java用户
     * 内存消耗:39.3 MB,击败了25.80% 的Java用户
     * @param nums
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        back(res, new int[nums.length], nums, new HashSet<>());
        return res;
    }

    public void back(List<List<Integer>> res, int[] array, int[] nums, Set<Integer> used){
        if (used.size() == nums.length) {
            List<Integer> li = new ArrayList<>(array.length);
            for (int a : array){
                li.add(a);
            }
            res.add(li);
        }
        Set<Integer> preSet = new HashSet<>();
        for (int i = 0; i < nums.length;) {
            if (!used.contains(i)) {
                preSet.add(nums[i]);
                used.add(i);
                array[used.size() - 1] = nums[i];
                back(res, array, nums, used);
                used.remove(i);
            }
            while (i < nums.length && (preSet.contains(nums[i]) || used.contains(i))){
                i++;
            }
        }
    }
}
