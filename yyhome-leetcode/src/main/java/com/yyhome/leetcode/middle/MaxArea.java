package com.yyhome.leetcode.middle;

/**
 * 11 盛最多水的容器
 * @author: lirl
 * @date: 2021/4/8
 */
public class MaxArea {

    public static void main(String[] args){
        System.out.println(new MaxArea().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(new MaxArea().maxArea(new int[]{4,3,2,1,4}));
        System.out.println(new MaxArea().maxArea(new int[]{1,1}));
        System.out.println(new MaxArea().maxArea(new int[]{1,2,1}));
    }

    /**
     * 执行耗时:5 ms,击败了42.99% 的Java用户
     * 内存消耗:51.9 MB,击败了21.38% 的Java用户
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        for (;left < right;){
            max = Math.max(max, Math.min(height[left], height[right]) * (right - left));
            if (height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
