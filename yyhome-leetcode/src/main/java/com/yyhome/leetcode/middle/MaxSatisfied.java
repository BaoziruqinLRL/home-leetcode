package com.yyhome.leetcode.middle;

/**
 * 1052 爱生气的书店老板
 * @Author: linabell
 * @Date: 2022/3/3 16:43
 */
public class MaxSatisfied {

    public static void main(String[] args){
        System.out.println(new MaxSatisfied().maxSatisfied2(new int[]{8,8}, new int[]{1,0}, 2));
        System.out.println(new MaxSatisfied().maxSatisfied2(new int[]{3}, new int[]{1}, 1));
        System.out.println(new MaxSatisfied().maxSatisfied(new int[]{1,0,1,2,1,1,7,5}, new int[]{0,1,0,1,0,1,0,1}, 3));
        System.out.println(new MaxSatisfied().maxSatisfied(new int[]{1}, new int[]{0}, 1));
        System.out.println(new MaxSatisfied().maxSatisfied2(new int[]{1,0,1,2,1,1,7,5}, new int[]{0,1,0,1,0,1,0,1}, 3));
        System.out.println(new MaxSatisfied().maxSatisfied2(new int[]{1}, new int[]{0}, 1));
    }

    /**
     * 执行耗时:661 ms,击败了5.09% 的Java用户
     * 内存消耗:43.9 MB,击败了29.59% 的Java用户
     * @param customers
     * @param grumpy
     * @param minutes
     * @return
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int total = 0;
        for (int i = 0; i < customers.length; i++) {
            total += grumpy[i] == 1 ? 0 : customers[i];
        }
        int max = total;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] != 0) {
                int bsq = 0;
                for (int j = i; j < i + minutes && j < customers.length; j++) {
                    bsq += grumpy[j] == 1 ? customers[j] : 0;
                }
                max = Math.max(max, total + bsq);
            }
        }
        return max;
    }

    /**
     * 执行耗时:3 ms,击败了55.50% 的Java用户
     * 内存消耗:44.6 MB,击败了5.33% 的Java用户
     * @param customers
     * @param grumpy
     * @param minutes
     * @return
     */
    public int maxSatisfied2(int[] customers, int[] grumpy, int minutes) {
        int total = 0;
        for (int i = 0; i < customers.length; i++) {
            total += grumpy[i] == 1 ? 0 : customers[i];
        }
        int bsq = 0;
        for (int i = 0; i < minutes && i < customers.length; i++) {
            bsq += grumpy[i] == 1 ? customers[i] : 0;
        }
        int max = total + bsq;
        for (int i = minutes; i < customers.length; i++) {
            bsq -= grumpy[i - minutes] == 1 ? customers[i - minutes] : 0;
            if (grumpy[i] == 1) {
                bsq += customers[i];
                max = Math.max(max, total + bsq);
            }
        }
        return max;
    }
}
