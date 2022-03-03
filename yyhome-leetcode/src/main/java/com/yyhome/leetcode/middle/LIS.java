package com.yyhome.leetcode.middle;

import java.util.Arrays;

/**
 * 最小上升子序列 TODO
 * @author miluo
 * @date 2020-03-02
 */
public class LIS {

    public static void main(String[] args){
        System.out.println(lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }

    /**
     * O(n²)
     * @param nums
     * @return
     */
    private static int lengthOfLIS(int[] nums) {
        int[] lengthArr = new int[nums.length];
        Arrays.fill(lengthArr,1);
        for (int fi = 0; fi < nums.length; fi++){
            for (int se = 0; se < fi; se++){
                if (nums[fi] > nums[se]){
                    lengthArr[fi] = Math.max(lengthArr[fi],lengthArr[se] + 1);
                }
            }
        }
        int res = 0;
        for (int length : lengthArr){
            if (length > res){
                res = length;
            }
        }
        return res;
    }

    /**
     * O(NlogN)
     * @param nums
     * @return
     */
    private static int lengthOfLIS2(int[] nums) {
        int res = 0;

        return res;
    }
}
