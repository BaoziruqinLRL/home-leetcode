package com.yyhome.leetcode.middle;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 131 分割回文串
 * @author: lirl
 * @date: 2021/7/22
 */
public class PartitionString {

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new PartitionString().partition("efe")));
        System.out.println(JSON.toJSONString(new PartitionString().partition("aab")));
        System.out.println(JSON.toJSONString(new PartitionString().partition("aa")));
    }

    List<List<String>> res = new ArrayList<>();

    /**
     * 执行耗时:14 ms,击败了22.79% 的Java用户
     * 内存消耗:53.1 MB,击败了15.74% 的Java用户
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        int[][] dp = new int[s.length()][s.length()];
        back(s, 0, dp, new ArrayList<>());
        return res;
    }

    private void back(String s, int end, int[][] dp, List<String> li) {
        if (end == s.length()) {
            res.add(Arrays.asList(li.toArray(new String[0])));
        } else {
            StringBuilder sb = new StringBuilder();
            for (int start = end; end < s.length(); end++) {
                sb.append(s.charAt(end));
                dp[start][end] = dp[start][end] == 0 ? isReSt(start, end, s) : dp[start][end];
                if (dp[start][end] == 1) {
                    li.add(sb.toString());
                    back(s, end + 1, dp, li);
                    li.remove(li.size() - 1);
                }
            }
        }
    }

    private int isReSt(int start, int end, String s) {
        if (start == end) {
            return 1;
        }
        for (; start <= end; start++, end--) {
            if (s.charAt(start) != s.charAt(end)) {
                return -1;
            }
        }
        return 1;
    }
}
