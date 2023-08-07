package com.yyhome.leetcode.hard;

/**
 * 42 接雨水
 * @Author: lrl
 * @Date: 2023/8/1 16:34:06
 */
public class Trap42 {

    public static void main(String[] args) {
        System.out.println(new Trap42().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(new Trap42().trap(new int[]{4,2,0,3,2,5}));
    }

    /**
     * 找出最大值, 按照最大值分割成两块分别统计即可, 另一边不停搜索并且重置另一边最大值即可
     * 执行耗时:1 ms,击败了78.95% 的Java用户
     * 内存消耗:43.1 MB,击败了48.72% 的Java用户
     * @param height
     * @return
     */
    public int trap(int[] height) {
        // 找出最大值所在索引
        int rightMaxIndex = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i] >= height[rightMaxIndex]) {
                rightMaxIndex = i;
            }
        }
        return calculate(height, rightMaxIndex) + calculateReverse(height, rightMaxIndex);
    }

    public int calculate(int[] height, int end) {
        int result = 0;
        int rightMax = height[end], leftMax = height[0];
        for (int i = 1; i < end; i++) {
            if (height[i] < leftMax) {
                result += (Math.min(rightMax, leftMax) - height[i]);
            } else {
                leftMax = height[i];
            }
        }
        return result;
    }

    public int calculateReverse(int[] height, int end) {
        int result = 0;
        int rightMax = height[height.length - 1], leftMax = height[end];
        for (int i = height.length - 1; i > end; i--) {
            if (height[i] < rightMax) {
                result += (Math.min(rightMax, leftMax) - height[i]);
            } else {
                rightMax = height[i];
            }
        }
        return result;
    }
}
