package com.yyhome.leetcode.hard;

/**
 * @Author: linabell
 * @Date: 2023/3/2 16:18:16
 */
public class FindMin154 {

    public static void main(String[] args) {
        System.out.println(new FindMin154().findMin(new int[]{1}));
        System.out.println(new FindMin154().findMin(new int[]{3,3,1,3}));
        System.out.println(new FindMin154().findMin(new int[]{10,1,10,10,10}));
        System.out.println(new FindMin154().findMin(new int[]{2,2,2,0,1}));
        System.out.println(new FindMin154().findMin(new int[]{3,1,1}));
        System.out.println(new FindMin154().findMin(new int[]{4,5,6,7,0,1,4}));
        System.out.println(new FindMin154().findMin(new int[]{0,1,4,4,5,6,7}));
        System.out.println(new FindMin154().findMin(new int[]{1,3,5}));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.3 MB,击败了52.23% 的Java用户
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        return find(nums, 0, nums.length - 1);
    }

    public int find(int[] nums, int left, int right) {
        int leftMin = nums[left], rightMax = nums[right], middle = (left + right) / 2;
        if (leftMin < rightMax) {
            return leftMin;
        } else if (left >= right - 1) {
            return Math.min(nums[left], nums[right]);
        } else{
            while (left <= right) {
                middle = (left + right) / 2;
                if (nums[middle] > leftMin) {
                    leftMin = nums[middle];
                    left = middle + 1;
                } else if (nums[middle] < rightMax) {
                    // 最小值肯定在右半边, 那么middle处于右半的时候它自身也是有可能是最小值,
                    // 因此这个分支中right=middle, 而不是通常二分法中的right=middle-1
                    rightMax = nums[middle];
                    right = middle;
                } else if (leftMin == rightMax) {
                    return Math.min(find(nums, left, middle), find(nums, middle, right));
                } else if (nums[middle] == rightMax) {
                    if (right == middle) {
                        return Math.min(nums[left], nums[right]);
                    }
                    right = middle;
                } else if (nums[middle] == leftMin) {
                    if (left == middle) {
                        return Math.min(nums[left], nums[right]);
                    }
                    left = middle;
                }
            }
            return nums[middle];
        }
    }
}
