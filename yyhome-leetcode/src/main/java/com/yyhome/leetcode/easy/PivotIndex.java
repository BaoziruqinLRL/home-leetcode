package com.yyhome.leetcode.easy;

/**
 * 724 寻找数组的中心下标
 * @author: lirl
 * @date: 2021/4/1
 */
public class PivotIndex {

    public static void main(String[] args){
        System.out.println(new PivotIndex().pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
        System.out.println(new PivotIndex().pivotIndex(new int[]{1, 2, 3}));
        System.out.println(new PivotIndex().pivotIndex(new int[]{2, 1, -1}));

    }

    /**
     * 执行耗时:2 ms,击败了69.79% 的Java用户
     * 内存消耗:38.9 MB,击败了88.40% 的Java用户
     * @param nums
     * @return
     */
    public int pivotIndex(int[] nums) {
        int[] leftSum = new int[nums.length];
        int[] rightSum = new int[nums.length];
        leftSum[0] = 0;
        rightSum[nums.length - 1] = 0;
        for (int i = 1; i < nums.length; i++){
            leftSum[i] = leftSum[i - 1] + nums[i - 1];
            rightSum[nums.length - 1 - i] = rightSum[nums.length - i] + nums[nums.length - i];
        }
        for (int i = 0; i< leftSum.length; i++){
            if (leftSum[i] == rightSum[i]){
                return i;
            }
        }
        return -1;
    }
}
