package com.yyhome.leetcode.easy;

import lombok.var;

/**
 * 409 最长回文串
 * @author miluo
 * @date 2020-03-19
 */
public class LongestPalindrome {

    public static void main(String[] args){
        System.out.println(longestPalindrome("abccccdd"));
    }

    private static int longestPalindrome(String s) {
        var arr = s.toCharArray();
        int[] charNum = new int[128];
        for (char c : arr) {
            charNum[c]++;
        }
        int length = 0;
        int existSingle = 0;
        for (int num : charNum){
            length += (num - num % 2);
            existSingle = existSingle == 0 ? num % 2 : existSingle;
        }
        return length + existSingle;
    }
}
