package com.yyhome.leetcode.middle;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39 组合总和
 * @author: lirl
 * @date: 2021/4/12
 */
public class CombinationSum {

    public static void main(String[] args){
        System.out.println(JSON.toJSONString(new CombinationSum().combinationSum(new int[]{2,3,6,7}, 7)));
        System.out.println(JSON.toJSONString(new CombinationSum().combinationSum(new int[]{2,3,5}, 8)));
    }

    /**
     * 执行耗时:4 ms,击败了53.20% 的Java用户
     * 内存消耗:38.9 MB,击败了26.63% 的Java用户
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        back(res, candidates, target, 0, new ArrayList<>());
        return res;
    }

    private void back(List<List<Integer>> res, int[] candidates, int target, int index, List<Integer> list) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
        } else if (target > 0){
            for (;index < candidates.length; index++){
                list.add(candidates[index]);
                target -= candidates[index];
                back(res, candidates, target, index, list);
                target += candidates[index];
                list.remove(list.size() - 1);
            }
        }
    }
}
