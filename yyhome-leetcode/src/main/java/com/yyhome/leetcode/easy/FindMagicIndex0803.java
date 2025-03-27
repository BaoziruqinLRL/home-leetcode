package com.yyhome.leetcode.easy;

import com.alibaba.fastjson.JSON;

/**
 * @Author: liriling
 * @Date: 2025/3/27 15:54
 */
public class FindMagicIndex0803 {

    public static void main(String[] args) {
        // 2
        System.out.println(JSON.toJSONString(new FindMagicIndex0803().findMagicIndex(new int[]{0, 2, 3, 4, 5})));
        System.out.println(JSON.toJSONString(new FindMagicIndex0803().findMagicIndex(new int[]{1, 1, 1})));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 	内存消耗:44.1 MB,击败了32.89% 的Java用户
     * @param nums
     * @return
     */
    public int findMagicIndex(int[] nums) {
        for (int i = 0; i < nums.length;) {
            if (nums[i] == i) {
                return i;
            }
            if (nums[i] > i) {
                i = nums[i];
            } else {
                i++;
            }
        }
        return -1;
    }
}
