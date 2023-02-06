package com.yyhome.leetcode.hard;

import java.util.*;

/**
 * 87 扰乱字符串
 * @Author: linabell
 * @Date: 2023/2/3 14:48:24
 */
public class IsScramble87 {

    public static void main(String[] args) {
        System.out.println(new IsScramble87().isScramble("eebaacbcbcadaaedceaaacadccd", "eadcaacabaddaceacbceaabeccd"));
        System.out.println(new IsScramble87().isScramble("abcdefghijklmnopq", "efghijklmnopqcadb"));
        System.out.println(new IsScramble87().isScramble("great", "rgeat"));
        System.out.println(new IsScramble87().isScramble("abcde", "caebd"));
        System.out.println(new IsScramble87().isScramble("a", "a"));
    }

    /**
     * 执行耗时:14 ms,击败了14.22% 的Java用户
     * 内存消耗:42.2 MB,击败了17.13% 的Java用户
     * @param s1
     * @param s2
     * @return
     */
    public boolean isScramble(String s1, String s2) {
        return cycle(s1, s2, 0, s1.length(), new HashMap<>());
    }

    public boolean cycle(String ss, String s2, int startInclude, int endExclude, Map<String, Boolean> res) {
        Boolean b = res.get(key(ss, s2, startInclude, endExclude));
        if (b != null) {
            return b;
        }
        b = false;
        if (!valid(ss, s2, startInclude, endExclude)) {
            b = false;
        } else if (ss.length() != endExclude - startInclude) {
            b = false;
        } else if (ss.equals(s2.substring(startInclude, endExclude))) {
            b = true;
        } else {
            for (int i = 1; i < endExclude - startInclude; i++) {
                if (s2.substring(startInclude, endExclude).equals(ss.substring(i) + ss.substring(0, i))) {
                    b = true;
                    break;
                } else {
                    boolean b1 = cycle(ss.substring(0, i), s2, startInclude, startInclude + i, res) && cycle(ss.substring(i), s2, startInclude + i, endExclude, res);
                    if (b1) {
                        b = true;
                        break;
                    }
                    boolean b2 = cycle(ss.substring(0, i), s2, endExclude - i, endExclude, res) && cycle(ss.substring(i), s2, startInclude, endExclude - i, res);
                    if (b2) {
                        b = true;
                        break;
                    }
                }
            }
        }
        res.put(key(ss, s2, startInclude, endExclude), b);
        return b;
    }

    private String key(String ss, String s2, int start, int end) {
        return ss + "_" + s2.substring(start, end);
    }

    private boolean valid(String ss, String s2, int startIndex, int endIndex) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : ss.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (; startIndex < endIndex; startIndex++) {
            char c = s2.charAt(startIndex);
            if (!map.containsKey(c)) {
                return false;
            }
            Integer i = map.get(c);
            if (i == 0) {
                return false;
            }
            map.put(c, i - 1);
        }
        return true;
    }
}
