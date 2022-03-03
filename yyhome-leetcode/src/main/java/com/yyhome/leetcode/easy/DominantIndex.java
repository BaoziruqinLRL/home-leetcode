package com.yyhome.leetcode.easy;

/**
 * 747 至少是其它数字两倍的最大数
 * @author: lirl
 * @date: 2021/4/6
 */
public class DominantIndex {

    public static void main(String[] args){
        System.out.println(new DominantIndex().dominantIndex(new int[]{1,0}));
        System.out.println(new DominantIndex().dominantIndex(new int[]{3, 6, 1, 0}));
        System.out.println(new DominantIndex().dominantIndex(new int[]{1, 2, 3, 4}));
    }

    /**
     * 执行耗时:1 ms,击败了50.26% 的Java用户
     * 内存消耗:36.6 MB,击败了8.22% 的Java用户
     * @param nums
     * @return
     */
    public int dominantIndex(int[] nums) {
        if (nums.length == 1){
            return 0;
        }
        int[] po = new int[2];
        po[1] = nums[1] > nums[0] ? 1 : 0;
        po[1] = nums[1] > nums[0] ? 0 : 1;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > nums[po[1]]){
                po[0] = po[1];
                po[1] = i;
            } else if (nums[i] > nums[po[0]]){
                po[0] = i;
            }
        }
        return nums[po[1]] >= 2 * nums[po[0]] ? po[1] : -1;
    }
}
