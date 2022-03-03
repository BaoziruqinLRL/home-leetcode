package com.yyhome.leetcode.middle;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 18 四数之和
 * @author: lirl
 * @date: 2021/4/9
 */
public class FourSum {

    public static void main(String[] args){
        System.out.println(JSON.toJSONString(new FourSum().fourSum(new int[]{1,0,-1,0,-2,2}, 0)));
        System.out.println(JSON.toJSONString(new FourSum().fourSum(new int[0], 0)));
        // -2 -1 -1 1 1 2 2
        System.out.println(JSON.toJSONString(new FourSum().fourSum(new int[]{-2,-1,-1,1,1,2,2}, 0)));
    }

    /**
     * 执行耗时:34 ms,击败了10.64% 的Java用户
     * 内存消耗:39.3 MB,击败了8.64% 的Java用户
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums.length == 0){
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int temp;
        for (int a = 0; a < nums.length;){
            for (int b = a + 1; b < nums.length;){
                for (int c = b + 1, d = nums.length - 1; c < d;){
                    if (nums[a] + nums[b] + nums[c] + nums[d] < target){
                        temp = c;
                        while (c < d && nums[c] == nums[temp]){
                            c++;
                        }
                    } else if (nums[a] + nums[b] + nums[c] + nums[d] > target) {
                        temp = d;
                        while (c < d && nums[d] == nums[temp]){
                            d--;
                        }
                    } else {
                        res.add(Arrays.asList(nums[a], nums[b], nums[c], nums[d]));
                        temp = c;
                        while (c < d && nums[c] == nums[temp]){
                            c++;
                        }
                        temp = d;
                        while (c < d && nums[d] == nums[temp]){
                            d--;
                        }
                    }
                }
                // 跳过重复的元素
                temp = b;
                while (b < nums.length && nums[b] == nums[temp]){
                    b++;
                }
            }
            temp = a;
            while (a < nums.length && nums[a] == nums[temp]){
                a++;
            }
        }
        return res;
    }
}
