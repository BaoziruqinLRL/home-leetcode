package com.yyhome.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 290 单词规律
 * @author: lirl
 * @date: 2021/3/23
 */
public class WordPattern {

    public static void main(String[] args) {
        System.out.println(new WordPattern().wordPattern("abba","dog cat cat dog"));
        System.out.println(new WordPattern().wordPattern("abba","dog cat cat fish"));
        System.out.println(new WordPattern().wordPattern("aaaa","dog cat cat dog"));
        System.out.println(new WordPattern().wordPattern("abba","dog dog dog dog"));
    }

    /**
     * 执行耗时:1 ms,击败了98.78% 的Java用户
     * 内存消耗:36.4 MB,击败了65.59% 的Java用户
     * @param pattern
     * @param s
     * @return
     */
    public boolean wordPattern(String pattern, String s) {
        String[] sArray = s.split(" ");
        if (pattern.length() != sArray.length){
            return false;
        }
        Map<Object, Integer> map = new HashMap<>();
        for (Integer i = 0; i < pattern.length(); i++){
            if (map.put(pattern.charAt(i),i) != map.put(sArray[i], i)){
                return false;
            }
        }
        return true;
    }
}
