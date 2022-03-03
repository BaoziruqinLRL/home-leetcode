package com.yyhome.leetcode.easy;

/**
 * 392 判断子序列
 * @author: lirl
 * @date: 2021/3/24
 */
public class IsSubsequence {

    public static void main(String[] args){
        System.out.println(new IsSubsequence().isSubsequence("b","abc"));
        System.out.println(new IsSubsequence().isSubsequence("abc","ahbgdc"));
        System.out.println(new IsSubsequence().isSubsequence("axc","ahbgdc"));
        System.out.println(new IsSubsequence().isSubsequence("","ahbgdc"));
    }

    /**
     * 执行耗时:3 ms,击败了16.25% 的Java用户
     * 内存消耗:36.3 MB,击败了64.17% 的Java用户
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()){
            return false;
        }
        if (s.length() == 0){
            return true;
        }
        int si = 0;
        for (int ti = 0; ti < t.length() && si < s.length();ti++){
            if (s.charAt(si) == t.charAt(ti)){
                si++;
            }
        }
        return si == s.length();
    }
}
