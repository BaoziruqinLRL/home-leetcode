package com.yyhome.leetcode.easy;

/**
 * 459 重复的子字符串
 * @author: lirl
 * @date: 2021/3/4
 */
public class RepeatedSubstringPattern {

    public static void main(String[] args){
        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern("abab"));
        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern("aba"));
        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern("abcabcabcabc"));
    }

    public boolean repeatedSubstringPattern(String s) {
        int limit = s.length() / 2 + 1;
        for (int i = 1; i < limit; i++){
            if (s.length() % i != 0){
                continue;
            }
            String part = s.substring(0, i);
            int index = i;
            while (index < s.length() && part.equals(s.substring(index,index + i))){
                index += i;
            }
            if (index == s.length()){
                return true;
            }
        }
        return false;
    }
}
