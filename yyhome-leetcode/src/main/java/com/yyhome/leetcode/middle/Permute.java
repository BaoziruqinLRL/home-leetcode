package com.yyhome.leetcode.middle;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * 46 全排列
 * @author: lirl
 * @date: 2021/4/13
 */
public class Permute {

    public static void main(String[] args){
        System.out.println(JSON.toJSONString(new Permute().permute(new int[]{1,2,3})));
        System.out.println(JSON.toJSONString(new Permute().permute(new int[]{1,2,3,4,5})));
    }

    /**
     * 执行耗时:2 ms,击败了52.99% 的Java用户
     * 内存消耗:38.8 MB,击败了24.49% 的Java用户
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
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
        for (int num : nums) {
            if (!used.contains(num)) {
                used.add(num);
                array[used.size() - 1] = num;
                back(res, array, nums, used);
                used.remove(num);
            }
        }
    }
}
