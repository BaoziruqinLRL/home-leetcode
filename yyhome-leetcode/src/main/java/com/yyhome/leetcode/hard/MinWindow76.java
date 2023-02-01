package com.yyhome.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖字串 76
 * @Author: linabell
 * @Date: 2023/2/1 11:34:46
 */
public class MinWindow76 {

    public static void main(String[] args) {
        System.out.println(new MinWindow76().minWindow("bba", "ab"));
        System.out.println(new MinWindow76().minWindow("a", "b"));
        System.out.println(new MinWindow76().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(new MinWindow76().minWindow("a", "a"));
        System.out.println(new MinWindow76().minWindow("a", "aa"));
    }

    /**
     * 执行耗时:88 ms,击败了33.15% 的Java用户
     * 内存消耗:43.2 MB,击败了5.00% 的Java用户
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        String res = s + ".";
        Map<Integer, Integer> map = new HashMap<>();
        int length = t.length();
        for (char c : t.toCharArray()) {
            Integer orDefault = map.getOrDefault((int) c, 0);
            map.put((int) c, orDefault + 1);
        }
        int left = 0, right;
        while (left < s.length() && !map.containsKey((int) s.charAt(left))) {
            left++;
        }
        right = left;
        while (right < s.length()) {
            if (length != 0) {
                int ch = s.charAt(right);
                if (map.containsKey(ch)) {
                    if (map.get(ch) > 0) {
                        length--;
                    }
                    map.put(ch, map.get(ch) - 1);
                }
            }
            if (length == 0) {
                while (length == 0) {
                    if (right - left + 1 < res.length()) {
                        res = s.substring(left, right + 1);
                    }
                    // 左窗口是满足条件的, 先移除
                    int leftCh = s.charAt(left);
                    Integer i = map.get(leftCh);
                    if (i >= 0) {
                        length++;
                    }
                    map.put(leftCh, map.get(leftCh) + 1);
                    left++;
                    while (left < s.length() && !map.containsKey((int) s.charAt(left))) {
                        left++;
                    }
                }
                right++;
            } else if (right - left + 1 >= res.length()) {
                while (left < s.length() && right - left + 1 >= res.length()) {
                    // 左窗口是满足条件的, 先移除
                    int leftCh = s.charAt(left);
                    Integer i = map.get(leftCh);
                    if (i >= 0) {
                        length++;
                    }
                    map.put(leftCh, map.get(leftCh) + 1);
                    left++;
                    while (left < s.length() && !map.containsKey((int) s.charAt(left))) {
                        left++;
                    }
                }
                right = Math.max(left, right + 1);
            } else {
                right++;
            }
        }
        return res.length() > s.length() ? "" : res;
    }
}
