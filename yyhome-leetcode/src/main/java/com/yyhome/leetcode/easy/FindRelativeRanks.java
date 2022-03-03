package com.yyhome.leetcode.easy;

import java.util.Arrays;

/**
 * 506 相对名次
 * @author: lirl
 * @date: 2021/3/26
 */
public class FindRelativeRanks {

    public static void main(String[] args){
        System.out.println(Arrays.toString(new FindRelativeRanks().findRelativeRanks(new int[]{1, 2, 3, 4, 5})));
    }

    /**
     * 执行耗时:7 ms,击败了82.31% 的Java用户
     * 内存消耗:39.2 MB,击败了96.10% 的Java用户
     * @param score
     * @return
     */
    public String[] findRelativeRanks(int[] score) {
        int max = score[0];
        for (int s : score){
            max = Math.max(s, max);
        }
        int[] po = new int[max + 1];
        int index = 0;
        for (int s : score){
            po[s] = (index++) + 1;
        }
        String[] res = new String[score.length];
        for (int i = po.length - 1; i >= 0; i--){
            if (po[i] != 0){
                if (index == score.length) {
                    res[po[i] - 1] = "Gold Medal";
                } else if (index == score.length - 1) {
                    res[po[i] - 1] = "Silver Medal";
                } else if (index == score.length - 2) {
                    res[po[i] - 1] = "Bronze Medal";
                } else {
                    res[po[i] - 1] = score.length + 1 - index + "";
                }
                index--;
            }
        }
        return res;
    }
}
