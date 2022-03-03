package com.yyhome.leetcode.easy;

/**
 * 125 验证回文串
 * @author: lirl
 * @date: 2021/3/8
 */
public class IsPalindromeString {

    public static void main(String[] args){
        System.out.println(new IsPalindromeString().isPalindrome("ab"));
        System.out.println(new IsPalindromeString().isPalindrome("a A"));
        System.out.println(new IsPalindromeString().isPalindrome("."));
        System.out.println(new IsPalindromeString().isPalindrome(" H"));
        System.out.println(new IsPalindromeString().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new IsPalindromeString().isPalindrome("race a car"));
    }

    /**
     * 执行耗时:3 ms,击败了92.93% 的Java用户
     * 内存消耗:38.4 MB,击败了73.42% 的Java用户
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        char[] sc = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        for (;start <= end; start++, end--){
            start = findNext(sc, start, true);
            end = findNext(sc, end, false);
            if (start < sc.length && end >= 0 && start <= end){
                if (sc[start] != sc[end]){
                    return false;
                }
            }
        }
        return true;
    }

    public int findNext(char[] sc, int index, boolean forward){
        if (forward){
            while (index < sc.length && !(
                    ('A' <= sc[index] && sc[index] <= 'Z') ||
                    ('0' <= sc[index] && sc[index] <= '9') ||
                    ('a' <= sc[index] && sc[index] <= 'z')
            )){
                index++;
            }
            if (index < sc.length && 'A' <= sc[index] && sc[index] <= 'Z'){
                sc[index] = (char) (sc[index] + 'a' - 'A');
            }
        }else{
            while (index >= 0 && !(
                    ('A' <= sc[index] && sc[index] <= 'Z') ||
                    ('0' <= sc[index] && sc[index] <= '9') ||
                    ('a' <= sc[index] && sc[index] <= 'z')
            )){
                index--;
            }
            if (index >= 0 && 'A' <= sc[index] && sc[index] <= 'Z'){
                sc[index] = (char) (sc[index] + 'a' - 'A');
            }
        }
        return index;
    }
}
