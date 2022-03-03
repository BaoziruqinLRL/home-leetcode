package com.yyhome.leetcode.middle;

/**
 * 97 交错字符串
 * @author: lirl
 * @date: 2021/5/10
 */
public class IsInterleave {

    public static void main(String[] args){
        System.out.println(new IsInterleave().isInterleave("a", "", "a"));
        System.out.println(new IsInterleave().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(new IsInterleave().isInterleave("aabcc", "dbbca", "aadbbbaccc"));
        System.out.println(new IsInterleave().isInterleave("", "", ""));
    }

    /**
     * 执行耗时:10 ms,击败了12.38% 的Java用户
     * 内存消耗:36.7 MB,击败了56.27% 的Java用户
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        if (s3.length() == 0) {
            return true;
        }
        boolean[][] dp = new boolean[s1.length()+1][s2.length()+1];
        dp[0][0] = true;
        for (int s3Index = 0; s3Index < s3.length(); s3Index++) {
            for (int s1Length = 0, length = s3Index + 1; s1Length <= length && s1Length <= s1.length(); s1Length++) {
                if (length - s1Length <= s2.length()) {
                    int s1Index = s1Length - 1;
                    int s2Length = length - s1Length;
                    int s2Index = s2Length - 1;
                    dp[s1Length][s2Length] = (s1Index >= 0 && s3.charAt(s3Index) == s1.charAt(s1Index) && dp[s1Index][s2Length])
                            || dp[s1Length][s2Length];
                    dp[s1Length][s2Length] = (s2Index >= 0 && s3.charAt(s3Index) == s2.charAt(s2Index) && dp[s1Length][s2Index])
                            || dp[s1Length][s2Length];
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
