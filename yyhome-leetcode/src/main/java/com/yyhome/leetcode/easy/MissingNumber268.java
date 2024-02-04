package com.yyhome.leetcode.easy;

import com.alibaba.fastjson.JSON;
import com.yyhome.leetcode.data.TreeNode;

/**
 * @Author: lrl
 * @Date: 2024/2/4 10:52:07
 */
public class MissingNumber268 {

    public static void main(String[] args){
        System.out.println(new MissingNumber268().missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
        System.out.println(new MissingNumber268().missingNumber(new int[]{3,0,1}));
        System.out.println(new MissingNumber268().missingNumber(new int[]{0,1}));
        System.out.println(new MissingNumber268().missingNumber(new int[]{0}));
    }

    /**
     * 执行耗时:1 ms,击败了51.10% 的Java用户
     * 内存消耗:44.3 MB,击败了5.45% 的Java用户
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
         int n = nums.length;
         int bigger = 10001;
         for (int i = 0; i < n; i++) {
             if (nums[i] >= n) {
                 bigger = nums[i];
             } else {
                 if (nums[i] != i) {
                     int temp = nums[i];
                     nums[i] = nums[temp];
                     nums[temp] = temp;
                 }
                 if (nums[i] != i) {
                     i--;
                 }
             }
         }
         if (bigger == n) {
             for (int i = 0; i < n; i++) {
                if (nums[i] != i) {
                    return i;
                }
             }
         } else {
             return n;
         }
         return 0;
    }
}
