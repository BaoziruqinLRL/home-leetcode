package com.yyhome.leetcode.easy;

/**
 * 680 验证回文字符串Ⅱ
 * @author: lirl
 * @date: 2021/3/31
 */
public class ValidPalindrome {

    public static void main(String[] args){
        System.out.println(new ValidPalindrome().validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
        System.out.println(new ValidPalindrome().validPalindrome("aba"));
        System.out.println(new ValidPalindrome().validPalindrome("abca"));
        System.out.println(new ValidPalindrome().validPalindrome("adcbfbdca"));
    }

    /**
     * 执行耗时:8 ms,击败了76.98% 的Java用户
     * 内存消耗:39.2 MB,击败了15.62% 的Java用户
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        int head = 0;
        int tail = s.length() - 1;
        int co = 0;
        while (head <= tail && co <= 1){
            if (s.charAt(head) == s.charAt(tail)){
                head++;
                tail--;
            } else if (s.charAt(head + 1) == s.charAt(tail) && (head + 2 > tail - 1 || s.charAt(head + 2) == s.charAt(tail - 1))){
                head += 3;
                tail -= 2;
                co++;
            } else if (s.charAt(head) == s.charAt(tail - 1) && (head + 1 > tail - 2 || s.charAt(head + 1) == s.charAt(tail - 2))){
                head += 2;
                tail -= 3;
                co++;
            } else {
                return false;
            }
        }
        return co <= 1;
    }
}
