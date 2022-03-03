package com.yyhome.leetcode.middle;

/**
 * 1035 不相交的线
 * @author: lirl
 * @date: 2021/7/5
 */
public class MaxUncrossedLines {

    public static void main(String[] args){
        System.out.println(new MaxUncrossedLines().maxUncrossedLines(new int[]{1,4,2}, new int[]{1,2,4}));
        System.out.println(new MaxUncrossedLines().maxUncrossedLines(new int[]{2,5,1,2,5}, new int[]{10,5,2,1,5,2}));
        System.out.println(new MaxUncrossedLines().maxUncrossedLines(new int[]{1,3,7,1,7,5}, new int[]{1,9,2,5,1}));
    }

    /**
     * 执行耗时:6 ms,击败了57.07% 的Java用户
     * 内存消耗:38 MB,击败了52.73% 的Java用户
     * @param nums1
     * @param nums2
     * @return
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length+1][nums2.length+1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[nums1.length][nums2.length];
    }
}
