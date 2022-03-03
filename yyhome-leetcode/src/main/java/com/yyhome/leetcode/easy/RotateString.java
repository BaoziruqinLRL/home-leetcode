package com.yyhome.leetcode.easy;

/**
 * 796 旋转字符串
 * @author: lirl
 * @date: 2021/4/7
 */
public class RotateString {

    public static void main(String[] args){
        System.out.println(new RotateString().rotateString("abcde", "cdeab"));
        System.out.println(new RotateString().rotateString("abcde", "abced"));
        System.out.println(new RotateString().rotateString("kifcqeiqoh", "ayyrddojpq"));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:36.3 MB,击败了64.61% 的Java用户
     * @param A
     * @param B
     * @return
     */
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()){
            return false;
        }
        return (A + A).contains(B);
    }
}
