package com.yyhome.leetcode.easy;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 448 找到数组中消失的数字
 * @author: lirl
 * @date: 2021/3/25
 */
public class FindDisappearedNumbers {

    public static void main(String[] args){
        System.out.println(JSON.toJSONString(new FindDisappearedNumbers().findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1})));
    }

    /**
     * 执行耗时:9 ms,击败了17.15% 的Java用户
     * 内存消耗:47.4 MB,击败了43.40% 的Java用户
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            nums[Math.abs(nums[i]) - 1] = -Math.abs(nums[Math.abs(nums[i]) - 1]);
        }
        List<Integer> li = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            if (nums[i] >= 0){
                li.add(i + 1);
            }
        }
        return li;
    }
}
