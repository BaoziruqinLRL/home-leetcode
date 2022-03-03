package com.yyhome.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 368 最大整除子集
 * @author: lirl
 * @date: 2021/8/2
 */
public class LargestDivisibleSubset {

    public static void main(String[] args){
        System.out.println(new LargestDivisibleSubset().largestDivisibleSubset(new int[]{4,8,10,240}));
        System.out.println(new LargestDivisibleSubset().largestDivisibleSubset(new int[]{2,3,8,9,27}));
        System.out.println(new LargestDivisibleSubset().largestDivisibleSubset(new int[]{3,4,16,8}));
        System.out.println(new LargestDivisibleSubset().largestDivisibleSubset(new int[]{1,2,3}));
        System.out.println(new LargestDivisibleSubset().largestDivisibleSubset(new int[]{1,2,4,8}));
    }

    /**
     * 执行耗时:21 ms,击败了43.87% 的Java用户
     * 内存消耗:38.7 MB,击败了26.13% 的Java用户
     * @param nums
     * @return
     */
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        // dpL[i]代表以nums[i]为最后一个元素的子集的长度, dp[i]代表以nums[i]为最后一个元素的子集的前一个元素,比如dp[2] = 0,表示子集至少以(nums[0],nums[2])结尾
        int[] dpL = new int[nums.length], dp = new int[nums.length];
        dpL[0] = 1;
        dp[0] = -1;
        int length = 1, index = 0;
        for (int i = 1; i < nums.length; i++) {
            boolean alone = true;
            for (int j = i -1; j >= 0; j--) {
                if (nums[j] % nums[i] == 0 || nums[i] % nums[j] == 0) {
                    // 避免 3 9 27 这样的序列导致最后结果记录了3 27, 因为 3 9 27的长度大于3 27
                    if (dpL[i] < dpL[j] + 1) {
                        dp[i] = j;
                        dpL[i] = dpL[j] + 1;
                        if (dpL[i] > length) {
                            length = dpL[i];
                            index = i;
                        }
                    }
                    alone = false;
                }
            }
            if (alone) {
                // 跟前面组不成子集,则自己成为头元素
                dpL[i] = 1;
                dp[i] = -1;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (; index >= 0; index = dp[index]) {
            res.add(nums[index]);
        }
        return res;
    }
}
