package com.yyhome.leetcode.hard;

/**
 * 214 最短回文串
 * @Author: linabell
 * @Date: 2023/3/20 16:18:05
 */
public class ShortestPalindrome214 {

    public static void main(String[] args){
        System.out.println(new ShortestPalindrome214().shortestPalindrome("babbbabbaba"));
        System.out.println(new ShortestPalindrome214().shortestPalindrome("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"));
        System.out.println(new ShortestPalindrome214().shortestPalindrome("aacecaaa"));
        System.out.println(new ShortestPalindrome214().shortestPalindrome("abcddcba"));
        System.out.println(new ShortestPalindrome214().shortestPalindrome("abcd"));
    }

    /**
     * 执行耗时:1148 ms,击败了7.42% 的Java用户
     * 内存消耗:41.7 MB,击败了39.08% 的Java用户
     * @param s
     * @return
     */
    public String shortestPalindrome(String s) {
        if (s.length() < 1) {
            return "";
        }
        int p = 26;
        int pow = 1;
        int hashLeft = 0, hashRight = 0;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++, pow = pow * p) {
            hashLeft = hashLeft * p + (s.charAt(i) - 'a' + 1);
            hashRight = hashRight + (s.charAt(i) - 'a' + 1) * pow;
            if (hashLeft == hashRight && s.substring(0, i+1).equals(new StringBuilder(s.substring(0, i+1)).reverse().toString())) {
                maxLength = i;
            }
        }
        return new StringBuilder(s.substring(maxLength + 1)).reverse() + s;
    }
}
