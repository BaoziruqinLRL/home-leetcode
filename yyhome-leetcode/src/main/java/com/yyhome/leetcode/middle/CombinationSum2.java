package com.yyhome.leetcode.middle;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40 组合总和Ⅱ
 * @author: lirl
 * @date: 2021/4/12
 */
public class CombinationSum2 {

    public static void main(String[] args){
        System.out.println(JSON.toJSONString(new CombinationSum2().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8)));
        System.out.println(JSON.toJSONString(new CombinationSum2().combinationSum2(new int[]{2,5,2,1,2}, 5)));
    }

    /**
     * 执行耗时:5 ms,击败了41.67% 的Java用户
     * 内存消耗:38.4 MB,击败了96.44% 的Java用户
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        back(res, candidates, target, 0, new ArrayList<>());
        return res;
    }

    private void back(List<List<Integer>> res, int[] candidates, int target, int index, List<Integer> list) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
        } else if (target > 0){
            for (;index < candidates.length;){
                list.add(candidates[index]);
                target -= candidates[index];
                back(res, candidates, target, index + 1, list);
                target += candidates[index];
                list.remove(list.size() - 1);
                int cur = candidates[index];
                while (index < candidates.length && candidates[index] == cur) {
                    index++;
                }
            }
        }
    }
}
