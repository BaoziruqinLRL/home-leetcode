package com.yyhome.leetcode.middle;

import java.util.Arrays;
import java.util.List;

/**
 * 120 三角形最小路径和
 * @author: lirl
 * @date: 2021/7/22
 */
public class MinimumTotal {

    public static void main(String[] args){
        System.out.println(new MinimumTotal().minimumTotal(Arrays.asList(Arrays.asList(1),Arrays.asList(2,3))));
        System.out.println(new MinimumTotal().minimumTotal(Arrays.asList(Arrays.asList(2),Arrays.asList(3,4), Arrays.asList(6,5,7), Arrays.asList(4,1,8,3))));
    }

    /**
     * 执行耗时:2 ms,击败了95.64% 的Java用户
     * 内存消耗:38.5 MB,击败了47.63% 的Java用户
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        int[] dp = new int[triangle.size()];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = triangle.get(0).get(0);
        int t1, t2;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < triangle.size(); i++) {
            t1 = dp[0];
            dp[0] = dp[0] + triangle.get(i).get(0);
            for (int j = 1; j <= i; j++){
                t2 = dp[j];
                dp[j] = Math.min(dp[j], t1) + triangle.get(i).get(j);
                t1 = t2;
            }
        }
        for (int d : dp) {
            min = Math.min(min, d);
        }
        return min;
    }
}
