package com.yyhome.leetcode.hard;

/**
 * 220 存在重复元素Ⅲ
 * @Author: linabell
 * @Date: 2023/6/19 15:48:15
 */
public class ContainsNearbyAlmostDuplicate {

    public static void main(String[] args) {
        System.out.println(new ContainsNearbyAlmostDuplicate().containsNearbyAlmostDuplicate(new int[]{1,14,23,45,56,2,3}, 1, 10));
        System.out.println(new ContainsNearbyAlmostDuplicate().containsNearbyAlmostDuplicate(new int[]{1,2,3,1}, 3, 0));
        System.out.println(new ContainsNearbyAlmostDuplicate().containsNearbyAlmostDuplicate(new int[]{-3, 3}, 2, 4));
        System.out.println(new ContainsNearbyAlmostDuplicate().containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2, 3));
    }

    /**
     * 执行耗时:1284 ms,击败了17.62% 的Java用户
     * 内存消耗:54.4 MB,击败了27.36% 的Java用户
     * @param nums
     * @param indexDiff
     * @param valueDiff
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        int start = 0, end = Math.min(indexDiff, nums.length - 1);
        while (start < end) {
            for (int index = start + 1; index <= end; index++) {
                if (Math.abs(nums[start] - nums[index]) <= valueDiff) {
                    return true;
                }
            }
            start++;
            end = Math.min(end + 1, nums.length - 1);
        }
        return false;
    }
}
