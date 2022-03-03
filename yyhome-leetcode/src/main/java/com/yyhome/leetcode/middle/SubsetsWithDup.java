package com.yyhome.leetcode.middle;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 90 子集Ⅱ
 * @author: lirl
 * @date: 2021/5/7
 */
public class SubsetsWithDup {

    public static void main(String[] args){
        System.out.println(JSON.toJSONString(new SubsetsWithDup().subsetsWithDup(new int[]{1,2,2})));
        System.out.println(JSON.toJSONString(new SubsetsWithDup().subsetsWithDup(new int[]{0})));
    }

    /**
     * 执行耗时:1 ms,击败了99.97% 的Java用户
     * 内存消耗:38.6 MB,击败了85.33% 的Java用户
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        back(res, new ArrayList<>(), nums, 0);
        return res;
    }

    public void back(List<List<Integer>> res, List<Integer> li, int[] nums, int start) {
        res.add(new ArrayList<>(li));
        int cur = Integer.MIN_VALUE;
        for (; start < nums.length; start++) {
            if (nums[start] != cur) {
                cur = nums[start];
                li.add(nums[start]);
                back(res, li, nums, start+1);
                li.remove(li.size() - 1);
            }
        }
    }
}
