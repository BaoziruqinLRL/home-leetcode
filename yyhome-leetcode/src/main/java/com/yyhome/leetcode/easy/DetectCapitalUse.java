package com.yyhome.leetcode.easy;

/**
 * 520 检测大写字母
 * @author: lirl
 * @date: 2021/3/26
 */
public class DetectCapitalUse {

    public static void main(String[] args){
        System.out.println(new DetectCapitalUse().detectCapitalUse("CHINA"));
        System.out.println(new DetectCapitalUse().detectCapitalUse("Flag"));
        System.out.println(new DetectCapitalUse().detectCapitalUse("leetcode"));
        System.out.println(new DetectCapitalUse().detectCapitalUse("leetCode"));
    }

    /**
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:36.9 MB,击败了39.84% 的Java用户
     * @param word
     * @return
     */
    public boolean detectCapitalUse(String word) {
        if (word.length() == 1){
            return true;
        }
        boolean firstUp = word.charAt(0) >= 'A' && word.charAt(0) <= 'Z';
        if (firstUp) {
            int start, end;
            if (word.charAt(1) >= 'A' && word.charAt(1) <= 'Z'){
                start = 'A';
                end = 'Z';
            } else {
                start = 'a';
                end = 'z';
            }
            for (int i = 1; i < word.length(); i++) {
                if (word.charAt(i) < start || word.charAt(i) > end){
                    return false;
                }
            }
        } else {
            for (int i = 1; i < word.length(); i++) {
                if (word.charAt(i) < 'a' || word.charAt(i) > 'z'){
                    return false;
                }
            }
        }
        return true;
    }
}
