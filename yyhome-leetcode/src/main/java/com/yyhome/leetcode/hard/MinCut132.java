package com.yyhome.leetcode.hard;

/**
 * 132 分割回文串Ⅱ
 * @Author: linabell
 * @Date: 2023/2/22 9:05:50
 */
public class MinCut132 {

    public static void main(String[] args) {
        System.out.println(new MinCut132().minCut("cbbbcc"));
        System.out.println(new MinCut132().minCut("aabcdefffe"));
        System.out.println(new MinCut132().minCut("aab"));
        System.out.println(new MinCut132().minCut("a"));
        System.out.println(new MinCut132().minCut("ab"));
    }

    /**
     * 中心扩展寻找回文字串
     * 执行耗时:3 ms,击败了98.67% 的Java用户
     * 内存消耗:39.5 MB,击败了94.13% 的Java用户
     * @param s
     * @return
     */
    public int minCut(String s) {
        // dp[i]为长度为i+1的字符串分割所需的最小次数
        int[] dp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            dp(dp, s, i, i);
            if (i < s.length() -1 && s.charAt(i) == s.charAt(i+1)) {
                dp(dp, s, i, i+1);
            }
        }
        return dp[s.length()-1];
    }

    private void dp(int[] dp, String s, int left, int right) {
        // 中心扩展, left, right为字符串中心, 奇数长度是初始left=right, 偶数时初始left=right-1
        for (; left >= 0 && right < s.length(); left--, right++) {
            if (s.charAt(left) == s.charAt(right)) {
                // [left, right] 回文, 则dp[right]等于自身以及dp[left-1]+1之中的最小值(以dp[left-1]为分割,
                // [left, right]为回文不需要分割,则只需要在dp[left-1]的基础上加一次分割把[left,right]作为最后一个字串即可
                dp[right] = Math.min(dp[right], left >= 1 ? dp[left - 1] + 1 : 0);
            } else {
                // 非回文,则要么取自身最小值, 要么取dp[right-1]的最小值在加上一次分割把自身作为最后一个字串
                dp[right] = Math.min(dp[right], dp[right - 1] + 1);
                break;
            }
        }
    }
}
