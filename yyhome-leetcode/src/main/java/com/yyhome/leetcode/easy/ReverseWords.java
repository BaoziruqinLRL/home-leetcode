package com.yyhome.leetcode.easy;

/**
 * 557 反转字符串中的单词 Ⅲ
 * @author: lirl
 * @date: 2021/3/29
 */
public class ReverseWords {

    public static void main(String[] args){
        System.out.println(new ReverseWords().reverseWords("Let's take LeetCode contest"));
    }

    /**
     * 执行耗时:11 ms,击败了28.66% 的Java用户
     * 内存消耗:39 MB,击败了68.52% 的Java用户
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        if (s.length() == 1){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int last = 0;
        int j;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == ' '){
                j = i - 1;
                while (j >= last){
                    sb.append(s.charAt(j--));
                }
                sb.append(' ');
                last = i + 1;
            }
        }
        j = s.length() - 1;
        while (j >= last){
            sb.append(s.charAt(j--));
        }
        return sb.toString();
    }
}
