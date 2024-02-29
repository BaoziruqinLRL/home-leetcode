package com.yyhome.leetcode.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Stream;

/**
 * 最小覆盖字串 76
 * @Author: linabell
 * @Date: 2023/2/1 11:34:46
 */
public class MinWindow76 {

    public static void main(String[] args) {
        System.out.println(new MinWindow76().minWindow("aa", "aa"));
        System.out.println(new MinWindow76().minWindow("babb", "baba"));
        System.out.println(new MinWindow76().minWindow("bbaa", "aba"));
        System.out.println(new MinWindow76().minWindow("ab", "a"));
        System.out.println(new MinWindow76().minWindow("bba", "ab"));
        System.out.println(new MinWindow76().minWindow("a", "b"));
        System.out.println(new MinWindow76().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(new MinWindow76().minWindow("a", "a"));
        System.out.println(new MinWindow76().minWindow("a", "aa"));

        System.out.println("------------------------");

        System.out.println(new MinWindow76().minWindow2("aa", "aa"));
        System.out.println(new MinWindow76().minWindow2("babb", "baba"));
        System.out.println(new MinWindow76().minWindow2("bbaa", "aba"));
        System.out.println(new MinWindow76().minWindow2("ab", "a"));
        System.out.println(new MinWindow76().minWindow2("bba", "ab"));
        System.out.println(new MinWindow76().minWindow2("a", "b"));
        System.out.println(new MinWindow76().minWindow2("ADOBECODEBANC", "ABC"));
        System.out.println(new MinWindow76().minWindow2("a", "a"));
        System.out.println(new MinWindow76().minWindow2("a", "aa"));
        System.out.println("------------------------");
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


    /**
     * 执行耗时:93 ms,击败了29.20% 的Java用户
     * 内存消耗:47.3 MB,击败了5.05% 的Java用户
     */
    // 等于0代表已找到结果
    long found = 0;
    public String minWindow2(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        if (s.length() == 1) {
            return s.equals(t) ? s : "";
        }
        if (t.length() == 1) {
            return s.contains(t) ? t : "";
        }
        String minResult = "";
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            Integer orDefault = tMap.getOrDefault(c, 0);
            tMap.put(c, orDefault + 1);
            setFound(c, false);
        }
        int left = -1;
        for (int i = 0; i < s.length(); i++) {
            if (tMap.containsKey(s.charAt(i))) {
                left = i;
                reduce(tMap, s.charAt(i));
                break;
            }
        }
        if (left == -1) {
            return "";
        }
        Queue<Integer> queue = new LinkedBlockingQueue<>();
        for (int right = left + 1; left <= right && right < s.length();) {
            char c = s.charAt(right);
            if (tMap.containsKey(c)) {
                queue.offer(right);
                reduce(tMap, c);
                while (found == 0) {
                    if (minResult.isEmpty() || minResult.length() > (right - left + 1)) {
                        minResult = s.substring(left, right + 1);
                    }
                    // 收缩左边界
                    char c1 = s.charAt(left);
                    increase(tMap, c1);
                    // 取下一个左边界
                    if (!queue.isEmpty()) {
                        left = queue.poll();
                    }
                }
            }
            right++;
        }
        return minResult;
    }

    private void reduce(Map<Character, Integer> tMap, char c) {
        Integer value = tMap.get(c);
        if (value == 1) {
            setFound(c, true);
        }
        tMap.put(c, value - 1);
    }

    private void increase(Map<Character, Integer> tMap, char c) {
        Integer value = tMap.get(c);
        if (value == 0) {
            setFound(c, false);
        }
        tMap.put(c, value + 1);

    }

    /**
     *
     * @param c
     * @param empty 由0->有为true， 由有->0以下为false
     */
    private void setFound(char c, boolean empty) {
        int real;
        if (c <= 'Z') {
            real = (c - 'A');
        } else {
            real = (c - 'a' + 26);
        }
        if (empty) {
            // 置为不存在
            found ^= (1L << real);
        } else {
            // 置为存在
            found |= (1L << real);
        }
    }
}
