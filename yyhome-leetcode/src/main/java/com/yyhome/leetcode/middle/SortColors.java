package com.yyhome.leetcode.middle;

import java.util.Arrays;

/**
 * 75 颜色分类
 * @author: lirl
 * @date: 2021/4/20
 */
public class SortColors {

    public static void main(String[] args) {
        int[] colors = new int[]{2,0,2,1,1,0};
        new SortColors().sortColors(colors);
        System.out.println(Arrays.toString(colors));
        colors = new int[]{2,0,1};
        new SortColors().sortColors(colors);
        System.out.println(Arrays.toString(colors));
        colors = new int[]{2,0,2,1,1,0,1,2,0,0,0,1,2,2,2,0};
        new SortColors().sortColors(colors);
        System.out.println(Arrays.toString(colors));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:37.2 MB,击败了16.35% 的Java用户
     * @param nums
     */
    public void sortColors(int[] nums) {
        int last = nums.length - 1, z = -1, o = -1, s = -1;
        while (s != nums.length - 1) {
            if (nums[last] == 0) {
                nums[last] = nums[s+1];
                nums[z+1] = 0;
                if (z != o) {
                    nums[o+1] = 1;
                }
                if (o != s) {
                    nums[s+1] = 2;
                }
                z++;
                o++;
                s++;
            } else if (nums[last] == 1) {
                nums[last] = nums[s+1];
                nums[o+1] = 1;
                if (o != s) {
                    nums[s+1] = 2;
                }
                o++;
                s++;
            } else {
                nums[last] = nums[s+1];
                nums[s+1] = 2;
                s++;
            }
        }
    }
}
