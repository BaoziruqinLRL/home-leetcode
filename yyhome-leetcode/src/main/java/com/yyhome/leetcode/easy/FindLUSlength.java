package com.yyhome.leetcode.easy;

/**
 * 521 最长特殊序列Ⅰ
 * @author: lirl
 * @date: 2021/3/29
 */
public class FindLUSlength {

    public static void main(String[] args) {
        System.out.println(new FindLUSlength().findLUSlength("aaa", "bbb"));
        System.out.println(new FindLUSlength().findLUSlength("", ""));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:36.5 MB,击败了13.76% 的Java用户
     * @param a
     * @param b
     * @return
     */
    public int findLUSlength(String a, String b) {
        if (a.equals(b)){
            return -1;
        }
        return Math.max(a.length(), b.length());
    }
}
