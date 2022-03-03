package com.yyhome.leetcode.middle;

import java.util.Arrays;

/**
 * 1818 绝对差值和
 * @author: lirl
 * @date: 2021/6/29
 */
public class MinAbsoluteSumDiff {

    public static void main(String[] args){
        System.out.println(new MinAbsoluteSumDiff().minAbsoluteSumDiff(new int[]{1,28,21}, new int[]{9,21,20}));
        System.out.println(new MinAbsoluteSumDiff().minAbsoluteSumDiff(new int[]{53,48,14,71,31,55,6,80,28,19,15,40,7,21,69,15,5,42,86,15,11,54,44,62,9,100,2,26,81,87,87,18,45,29,46,100,20,87,49,86,14,74,74,52,52,60,8,25,21,96,7,90,91,42,32,34,55,20,66,36,64,67,44,51,4,46,25,57,84,23,10,84,99,33,51,28,59,88,50,41,59,69,59,65,78,50,78,50,39,91,44,78,90,83,55,5,74,96,77,46},
                new int[]{39,49,64,34,80,26,44,3,92,46,27,88,73,55,66,10,4,72,19,37,40,49,40,58,82,32,36,91,62,21,68,65,66,55,44,24,78,56,12,79,38,53,36,90,40,73,92,14,73,89,28,53,52,46,84,47,51,31,53,22,24,14,83,75,97,87,66,42,45,98,29,82,41,36,57,95,100,2,71,34,43,50,66,52,6,43,94,71,93,61,28,84,7,79,23,48,39,27,48,79}));
        System.out.println(new MinAbsoluteSumDiff().minAbsoluteSumDiff(new int[]{2,4,6,8,10}, new int[]{2,4,6,8,10}));
        System.out.println(new MinAbsoluteSumDiff().minAbsoluteSumDiff(new int[]{1,7,5}, new int[]{2,3,5}));
        System.out.println(new MinAbsoluteSumDiff().minAbsoluteSumDiff(new int[]{1,10,4,4,2,7}, new int[]{9,3,5,1,7,4}));
    }

    /**
     * 执行耗时:86 ms,击败了54.89% 的Java用户
     * 内存消耗:55.9 MB,击败了64.88% 的Java用户
     * @param nums1
     * @param nums2
     * @return
     */
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
       long total = 0;
       int max = 0;
       int[] absArr = new int[nums2.length];
       for (int i = 0; i < nums1.length; i++) {
           int value = Math.abs(nums1[i] - nums2[i]);
           total += value;
           absArr[i] = value;
       }
       Arrays.sort(nums1);
       for (int i = 0; i < nums2.length; i++) {
           int value = search(nums1, nums2[i], absArr[i]);
           max = Math.max(max, value);
       }
       return (int) ((total - max) % (1E9+7));
    }

    /**
     * 找到最大差值，差值=abs-Math.min(cur-nums[k]) (0<=k<nums1.length)，该差值代表了替换后变化的最大值
     * @param nums
     * @param cur
     * @param abs
     * @return
     */
    private int search(int[] nums, int cur, int abs) {
        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int middle = (s + e) / 2;
            if (e - s <= 1) {
                return Math.abs(abs - Math.min(Math.abs(cur - nums[s]), Math.abs(cur - nums[e])));
            } else if (nums[middle] > cur) {
                e = middle;
            } else if (nums[middle] < cur) {
                s = middle;
            } else if (nums[middle] == cur) {
                return abs;
            }
        }
        return 0;
    }
}
