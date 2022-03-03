package com.yyhome.leetcode.easy;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 387 第一个唯一字符
 * @author: lirl
 * @date: 2021/3/23
 */
public class FirstUniqChar {

    public static void main(String[] args){
        System.out.println(new FirstUniqChar().firstUniqChar("leetcode"));
        System.out.println(new FirstUniqChar().firstUniqChar("loveleetcode"));

        System.out.println(new FirstUniqChar().firstUniqChar2("leetcode"));
        System.out.println(new FirstUniqChar().firstUniqChar2("loveleetcode"));
    }

    /**
     * 执行耗时:35 ms,击败了27.59% 的Java用户
     * 内存消耗:39.2 MB,击败了14.45% 的Java用户
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        int[] po = new int[26];
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            int v = map.getOrDefault(c, 0);
            map.put(c, v + 1);
            if (po[c - 'a'] == 0 && i > 0){
                po[c - 'a'] = i;
            }
        }
        for (Map.Entry<Character, Integer> en : map.entrySet()){
            if (en.getValue() == 1){
                return po[en.getKey() - 'a'];
            }
        }
        return -1;
    }

    /**
     * 执行耗时:31 ms,击败了46.87% 的Java用户
     * 内存消耗:39 MB,击败了61.64% 的Java用户
     * @param s
     * @return
     */
    public int firstUniqChar2(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()){
            int v = map.getOrDefault(c, 0);
            map.put(c, v + 1);
        }
        for (int i = 0; i< s.length(); i++){
            if (map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}
