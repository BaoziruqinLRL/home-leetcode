package com.yyhome.leetcode.easy;

import java.util.Arrays;

/**
 * 455 分发饼干
 * @author: lirl
 * @date: 2021/3/25
 */
public class FindContentChildren {

    public static void main(String[] args){
        System.out.println(new FindContentChildren().findContentChildren(new int[]{1,2,3,4,5,6}, new int[]{7,4,3,2}));
        System.out.println(new FindContentChildren().findContentChildren(new int[]{5,6,7,8}, new int[]{1,2,3,9}));
        System.out.println(new FindContentChildren().findContentChildren(new int[]{1,2,3}, new int[]{1,1}));
        System.out.println(new FindContentChildren().findContentChildren(new int[]{1,2}, new int[]{1,2,3}));
    }

    /**
     * 执行耗时:28 ms,击败了7.00% 的Java用户
     * 内存消耗:39 MB,击败了81.09% 的Java用户
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        if (g.length == 0 || s.length == 0){
            return 0;
        }
        Arrays.sort(g);
        Arrays.sort(s);
        if (s[s.length - 1] < g[0]){
            return 0;
        }
        int count = 0;
        for (int gi = 0, si = 0; si < s.length && gi < g.length; si++){
            for (int i = gi; i < g.length; i++){
                if (s[si] >= g[i]){
                    gi = i + 1;
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
