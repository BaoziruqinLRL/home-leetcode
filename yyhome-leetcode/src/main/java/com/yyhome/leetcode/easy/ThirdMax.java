package com.yyhome.leetcode.easy;

/**
 * 414 第三大的数
 * @author: lirl
 * @date: 2021/3/24
 */
public class ThirdMax {

    public static void main(String[] args){
        System.out.println(new ThirdMax().thirdMax(new int[]{3, 2, 1}));
        System.out.println(new ThirdMax().thirdMax(new int[]{1, 2}));
        System.out.println(new ThirdMax().thirdMax(new int[]{2, 2, 3, 1}));
    }

    /**
     * 执行耗时:2 ms,击败了46.31% 的Java用户
     * 内存消耗:38.1 MB,击败了82.12% 的Java用户
     * @param nums
     * @return
     */
    public int thirdMax(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }
        // 最大 -> 第二大 -> 第三大
        Integer[] top = new Integer[3];
        for (int num : nums) {
            if (top[0] == null) {
                top[0] = num;
            } else if (top[1] == null) {
                if (num != top[0]) {
                    top[1] = Math.min(num, top[0]);
                    top[0] = Math.max(num, top[0]);
                }
            } else if (top[2] == null) {
                if (num < top[1]) {
                    top[2] = num;
                } else if (num > top[0]) {
                    top[2] = top[1];
                    top[1] = top[0];
                    top[0] = num;
                } else if (top[0] > num && num > top[1]) {
                    top[2] = top[1];
                    top[1] = num;
                }
            } else {
                if (num > top[0]) {
                    top[2] = top[1];
                    top[1] = top[0];
                    top[0] = num;
                } else if (num > top[1] && num < top[0]) {
                    top[2] = top[1];
                    top[1] = num;
                } else if (num < top[1] && num > top[2]) {
                    top[2] = num;
                }
            }
        }
        return top[2] == null ? top[0] : top[2];
    }
}
