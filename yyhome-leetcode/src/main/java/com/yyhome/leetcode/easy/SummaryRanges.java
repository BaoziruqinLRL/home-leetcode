package com.yyhome.leetcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 228 汇总区域
 * @author: lirl
 * @date: 2021/3/11
 */
public class SummaryRanges {

    public static void main(String[] args) {
        System.out.println(new SummaryRanges().summaryRanges(new int[]{0,1,2,4,5,7}));
        System.out.println(new SummaryRanges().summaryRanges(new int[]{0,2,3,4,6,8,9}));
        System.out.println(new SummaryRanges().summaryRanges(new int[0]));
        System.out.println(new SummaryRanges().summaryRanges(new int[]{-1}));
        System.out.println(new SummaryRanges().summaryRanges(new int[]{-2147483648,-2147483647,2147483647}));
    }

    /**
     * 执行耗时:7 ms,击败了56.10% 的Java用户
     * 内存消耗:37 MB,击败了12.88% 的Java用户
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0){
            return new ArrayList<>();
        }
        if (nums.length == 1){
            return Collections.singletonList(String.valueOf(nums[0]));
        }
        List<String> range = new ArrayList<>();
        int start = nums[0];
        int pre = nums[0];
        for (int i = 1; i < nums.length; i++){
            if ((long)nums[i] - (long)pre > 1L){
                if (pre == start){
                    range.add(String.valueOf(pre));
                }else {
                    range.add(start + "->" + pre);
                }
                start = nums[i];
            }
            pre = nums[i];
        }
        if (pre == start){
            range.add(String.valueOf(pre));
        }else {
            range.add(start + "->" + pre);
        }
        return range;
    }
}
