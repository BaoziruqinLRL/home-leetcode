package com.yyhome.leetcode.middle;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 78 子集
 * 面试题 08.04 幂集
 * @author: lirl
 * @date: 2021/4/20
 */
public class Subsets {

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new Subsets().subsets(new int[]{1,2,3})));
        System.out.println(JSON.toJSONString(new Subsets().subsets(new int[]{0})));
    }

    /**
     * 执行耗时:1 ms,击败了82.46% 的Java用户
     * 内存消耗:38.7 MB,击败了64.19% 的Java用户
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        back(res, new ArrayList<>(), 0, nums);
        return res;
    }

    public void back(List<List<Integer>> res, List<Integer> li, int start, int[] nums) {
        res.add(new ArrayList<>(li));
        for (; start < nums.length; start++) {
            li.add(nums[start]);
            back(res,li,start+1,nums);
            li.remove(li.size() - 1);
        }
    }
}
