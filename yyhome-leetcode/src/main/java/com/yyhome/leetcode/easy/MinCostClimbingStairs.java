package com.yyhome.leetcode.easy;

import com.yyhome.leetcode.data.ListNode;

/**
 * 746 最小花费爬楼梯
 */
public class MinCostClimbingStairs {

    public static void main(String[] args){
        System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(new int[]{10,15,20}));
        System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
        System.out.println(new MinCostClimbingStairs().minCostClimbingStairs(new int[]{1,1,1,1,1}));
    }

    public int minCostClimbingStairs(int[] cost) {
        return to(cost,0);
    }

    private int to(int[] cost, int index) {
        if (index == cost.length) {
            return Math.min(cost[index - 1], cost[index - 2]);
        } else if (index > 1){
            cost[index] = Math.min(cost[index - 2], cost[index - 1]) + cost[index];
        }
        return to(cost,index + 1);
    }
}
