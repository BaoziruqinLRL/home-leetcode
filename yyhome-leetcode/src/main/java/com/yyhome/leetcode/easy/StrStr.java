package com.yyhome.leetcode.easy;

/**
 * 28 实现strStr
 * @author miluo
 * @date 2020-07-08
 */
public class StrStr {

    public static void main(String[] args) {
        System.out.println(new StrStr().strStr("hello","ll"));
        System.out.println(new StrStr().strStr("aaaaa","bba"));
        System.out.println(new StrStr().strStr("asidsaojdoasqw","sao"));
        System.out.println(new StrStr().strStr("asdqwq",""));
    }

    /**
     * 执行耗时:783 ms,击败了5.06% 的Java用户
     * 内存消耗:38.7 MB,击败了5.43% 的Java用户
     * 真辣鸡。。
     */
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0){
            return 0;
        }
        int index = 0;
        char[] hay = haystack.toCharArray();
        char[] nee = needle.toCharArray();
        while (index < hay.length){
            if (hay[index] == nee[0]){
                int neeIndex = 0;
                while (neeIndex < nee.length && neeIndex + index < hay.length && hay[index + neeIndex] == nee[neeIndex]){
                    neeIndex++;
                }
                if (neeIndex == nee.length){
                    return index;
                }
            }
            index++;
        }
        return -1;
    }

    /**
     * KMP 实现。。暂时不会
     * @param haystack
     * @param needle
     * @return
     */
    public int strStrKMP(String haystack, String needle) {
        return 0;
    }
}
