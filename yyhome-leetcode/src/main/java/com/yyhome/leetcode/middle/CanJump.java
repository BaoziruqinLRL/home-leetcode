package com.yyhome.leetcode.middle;

/**
 * 55 跳跃游戏
 * @author: lirl
 * @date: 2021/7/19
 */
public class CanJump {

    public static void main(String[] args){
        System.out.println(new CanJump().canJump(new int[]{0,1}));
        System.out.println(new CanJump().canJump(new int[]{2,3,1,1,4}));
        System.out.println(new CanJump().canJump(new int[]{3,2,1,0,4}));
        System.out.println(new CanJump().canJump(new int[]{3,2,2,0,4}));
    }

    /**
     * 执行耗时:2 ms,击败了92.93% 的Java用户
     * 内存消耗:39.9 MB,击败了51.10% 的Java用户
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i <= max && max < nums.length; i++) {
            max = Math.max(max, i + nums[i]);
        }
        return max >= nums.length - 1;
    }
}
