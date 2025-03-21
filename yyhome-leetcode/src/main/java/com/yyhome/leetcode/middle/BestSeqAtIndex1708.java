package com.yyhome.leetcode.middle;

import java.util.Arrays;

/**
 * @Author: liriling
 * @Date: 2025/3/19 16:38
 */
public class BestSeqAtIndex1708 {

    public static void main(String[] args) {
        // 3
        System.out.println(new BestSeqAtIndex1708().bestSeqAtIndex(new int[]{7993,4630,2152,7609,6012,5878,4325,3955,4326,1883}, new int[]{3793,8079,8452,1378,4102,3204,6633,4417,1374,7015}));
        // 6
        System.out.println(new BestSeqAtIndex1708().bestSeqAtIndex(new int[]{65,70,56,75,60,68}, new int[]{100,150,90,190,95,110}));
    }

    /**
     * 执行耗时:57 ms,击败了36.46% 的Java用户
     * 内存消耗:45.1 MB,击败了44.79% 的Java用户
     * 根据height进行正序排序，height相同者进行反序排序，之后根据weight查找最长上升子序列
     * 通过二分查找
     * @param height
     * @param weight
     * @return
     */
    public int bestSeqAtIndex(int[] height, int[] weight) {
        Integer[] sort = new Integer[height.length];
        for (int i = 0; i < height.length; i++) {
            sort[i] = i;
        }
        Arrays.sort(sort, (o1, o2) -> height[o1] == height[o2] ? weight[o2] - weight[o1] : height[o1] - height[o2]);
        int[] tail = new int[height.length];
        tail[0] = weight[sort[0]];
        int index = 0;
        for (Integer integer : sort) {
            if (weight[integer] > tail[index]) {
                tail[++index] = weight[integer];
            } else {
                secondInsert(tail, weight[integer], index);
            }
        }
        return index + 1;
    }

    private void secondInsert(int[] tail, int value, int index) {
        int start = 0, end = index + 1;
        int middle = (start + end) / 2;
        while (middle < end) {
            if (tail[middle] < value) {
                if (middle == end - 1) {
                    middle++;
                    break;
                }
                start = middle;
            } else if (tail[middle] > value){
                end = middle;
            } else {
                break;
            }
            middle = (start + end) / 2;
        }
        tail[middle] = value;
    }
}
