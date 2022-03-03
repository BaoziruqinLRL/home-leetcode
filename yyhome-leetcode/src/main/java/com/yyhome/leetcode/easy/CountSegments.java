package com.yyhome.leetcode.easy;

/**
 * 434 字符串中的单词数
 * @author: lirl
 * @date: 2021/3/24
 */
public class CountSegments {

    public static void main(String[] args){
        System.out.println(new CountSegments().countSegments("Hello, my name is John"));
        System.out.println(new CountSegments().countSegments(", , , ,        a, eaefa"));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:36.5 MB,击败了20.00% 的Java用户
     * @param s
     * @return
     */
    public int countSegments(String s) {
        int count = 0;
        boolean begin = false;
        for (char c : s.toCharArray()){
            if (c != ' ' && !begin){
                begin = true;
                count++;
            } else if (c == ' ' && begin){
                begin = false;
            }
        }
        return count;
    }
}
