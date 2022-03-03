package com.yyhome.leetcode.middle;

import java.util.*;

/**
 * 1817 查找用户活跃分钟数
 * @author: lirl
 * @date: 2021/6/29
 */
public class FindingUsersActiveMinutes {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindingUsersActiveMinutes().findingUsersActiveMinutes(new int[][]{{0,5},{1,2},{0,2},{0,5},{1,3}}, 5)));
        System.out.println(Arrays.toString(new FindingUsersActiveMinutes().findingUsersActiveMinutes(new int[][]{{1,1},{2,2},{2,3}}, 4)));
    }

    /**
     * 执行耗时:22 ms,击败了61.07% 的Java用户
     * 内存消耗:48.3 MB,击败了85.19% 的Java用户
     * @param logs
     * @param k
     * @return
     */
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] log : logs) {
            Set<Integer> orDefault = map.getOrDefault(log[0], new HashSet<>());
            orDefault.add(log[1]);
            map.put(log[0], orDefault);
        }
        int[] res = new int[k];
        for (Map.Entry<Integer, Set<Integer>> e : map.entrySet()) {
            res[e.getValue().size()-1]++;
        }
        return res;
    }
}
