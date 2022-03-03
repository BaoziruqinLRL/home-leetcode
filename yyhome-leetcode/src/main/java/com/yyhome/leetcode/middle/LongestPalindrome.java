package com.yyhome.leetcode.middle;

/**
 * 5 最长回文子串
 * @author: lirl
 * @date: 2021/4/7
 */
public class LongestPalindrome {

    public static void main(String[] args){
        System.out.println(new LongestPalindrome().longestPalindrome("babad"));
        System.out.println(new LongestPalindrome().longestPalindrome("abcde"));
    }

    /**
     * 执行耗时:384 ms,击败了16.06% 的Java用户
     * 内存消耗:44.5 MB,击败了11.07% 的Java用户
     * 动态规划，从长度为1的字符串开始计算，长度为n的字符串是否是回文取决于字符串首尾字符是否一样以及中间字符串是否回文，
     * 例如 ABCBA是否回文取决于A=A以及BCB是回文，则ABCBA是回文字符串。
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        // 记录从i->j的字符串是否是回文字符串
        boolean[][] isPal = new boolean[s.length()][s.length()];
        String res = "";
        for (int length = 0; length < s.length(); length++){
            for (int i = 0; i < s.length() - length; i++){
                if (length == 0) {
                    // 若此时字符串长度为1（length - 1），则单字符必然回文
                    isPal[i][i + length] = true;
                } else if (length == 1){
                    // 若此时字符串长度为2，则字符相等则回文
                    isPal[i][i + length] = (s.charAt(i) == s.charAt(i + length));
                } else {
                    // 字符串长度大于2，回文取决于字符串首尾字符是否一样以及中间字符串是否回文
                    isPal[i][i + length] = (s.charAt(i) == s.charAt(i + length)) && isPal[i + 1][i + length - 1];
                }
                // 若回文且长度大于res，则更新res
                if (isPal[i][i + length] && length + 1 > res.length()){
                    res = s.substring(i, i + length + 1);
                }
            }
        }
        return res;
    }
}
