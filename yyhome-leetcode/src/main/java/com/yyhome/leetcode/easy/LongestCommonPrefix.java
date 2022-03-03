package com.yyhome.leetcode.easy;

import lombok.var;

/**
 * 14 最长公共前缀
 * @author miluo
 * @date 2020-07-07
 */
public class LongestCommonPrefix {

    public static void main(String[] args){
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        StringBuilder longestPrefix = new StringBuilder();
        String shortest = strs[0];
        for (var str : strs){
            if (str.length() < shortest.length()){
                shortest = str;
            }
        }
        if (shortest.length() == 0){
            return longestPrefix.toString();
        }
        for (int index = 0; index < shortest.length(); index++){
            char temp = shortest.charAt(index);
            for (var s : strs){
                if (s.charAt(index) != temp){
                    return longestPrefix.toString();
                }
            }
            longestPrefix.append(temp);
        }
        return longestPrefix.toString();
    }
}
