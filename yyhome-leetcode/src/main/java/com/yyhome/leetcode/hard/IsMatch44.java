package com.yyhome.leetcode.hard;

/**
 * 44通配符匹配
 * @Author: linabell
 * @Date: 2022/10/18 15:42:27
 */
public class IsMatch44 {

    public static void main(String[] args) {
//        System.out.println(new IsMatch44().isMatch("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb", "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));
//        System.out.println(new IsMatch44().isMatch("abcabczzzde", "*abc???de*"));
//        System.out.println(new IsMatch44().isMatch("aa", "a"));
//        System.out.println(new IsMatch44().isMatch("aa", "*"));
//        System.out.println(new IsMatch44().isMatch("cb", "?a"));
//        System.out.println(new IsMatch44().isMatch("adceb", "*a*b"));
//        System.out.println(new IsMatch44().isMatch("acdcb", "a*c?b"));
//        System.out.println(new IsMatch44().isMatch("acdcb", "a**b"));
//        System.out.println(new IsMatch44().isMatch("acdcb", "a**h"));
//        System.out.println(new IsMatch44().isMatch("acdcb", "a*?"));
//        System.out.println(new IsMatch44().isMatch("acdcb", "?????"));
//        System.out.println(new IsMatch44().isMatch("a", "******"));
//        System.out.println(new IsMatch44().isMatch("", "******"));

        System.out.println("split--------------------------");

        System.out.println(new IsMatch44().isMatch2("", ""));
        System.out.println(new IsMatch44().isMatch2("a", ""));
        System.out.println(new IsMatch44().isMatch2("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb", "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"));
        System.out.println(new IsMatch44().isMatch2("abcabczzzde", "*abc???de*"));
        System.out.println(new IsMatch44().isMatch2("aa", "a"));
        System.out.println(new IsMatch44().isMatch2("aa", "*"));
        System.out.println(new IsMatch44().isMatch2("cb", "?a"));
        System.out.println(new IsMatch44().isMatch2("adceb", "*a*b"));
        System.out.println(new IsMatch44().isMatch2("acdcb", "a*c?b"));
        System.out.println(new IsMatch44().isMatch2("acdcb", "a**b"));
        System.out.println(new IsMatch44().isMatch2("acdcb", "a**h"));
        System.out.println(new IsMatch44().isMatch2("acdcb", "a*?"));
        System.out.println(new IsMatch44().isMatch2("acdcb", "?????"));
        System.out.println(new IsMatch44().isMatch2("a", "******"));
        System.out.println(new IsMatch44().isMatch2("", "******"));
    }

    private Boolean[][] result;

    /**
     * 执行耗时:24 ms,击败了64.63% 的Java用户
     * 内存消耗:44.1 MB,击败了5.03% 的Java用户
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch2(String s, String p) {
        if (p.length() == 0 && s.length() > 0) {
            return false;
        }
        result = new Boolean[s.length()][p.length()];
        return dp(0, 0, s, p);
    }

    public boolean dp(int sIndex, int pIndex, String s, String p) {
        if (sIndex < s.length() && pIndex < p.length() && result[sIndex][pIndex] != null) {
            return result[sIndex][pIndex];
        }
        if (pIndex == p.length()) {
            if (sIndex == s.length()) {
                return true;
            } else if (sIndex <= s.length() && p.charAt(pIndex - 1) == '*') {
                return true;
            }
            return false;
        }
        if (sIndex == s.length()) {
            for (;pIndex < p.length(); pIndex++) {
                if (p.charAt(pIndex) != '*') {
                    return false;
                }
            }
            return true;
        }
        boolean thisResult = false;
        if (p.charAt(pIndex) == '?') {
            thisResult = dp(sIndex+1, pIndex+1, s, p);
        } else if (p.charAt(pIndex) == '*') {
            thisResult = dp(sIndex+1,pIndex, s, p) || dp(sIndex, pIndex+1,s, p);
        } else if (s.charAt(sIndex) == p.charAt(pIndex)){
            thisResult = dp(sIndex+1, pIndex+1, s, p);
        }
        result[sIndex][pIndex] = thisResult;
        return thisResult;
    }
}
