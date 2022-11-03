package com.yyhome.leetcode.hard;

/**
 * 10 正则表达式匹配
 * @Author: linabell
 * @Date: 2022/11/2 15:55:57
 */
public class IsMatch10 {

    public static void main(String[] args) {
        System.out.println(new IsMatch10().isMatch("aabcbcbcaccbcaabc", ".*a*aa*.*b*.c*.*a*"));
        System.out.println(new IsMatch10().isMatch("aa", "a*"));
        System.out.println(new IsMatch10().isMatch("ab", ".*"));
        System.out.println(new IsMatch10().isMatch("aab", "c*a*b"));
        System.out.println(new IsMatch10().isMatch("aa", "a"));
    }

    private Boolean[][] result;

    /**
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:39.9 MB,击败了72.49% 的Java用户
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        result = new Boolean[s.length()][p.length()];
        return dp(s, p, 0, 0);
    }

    public boolean dp(String s, String p, int sIndex, int pIndex) {
        if (sIndex >= s.length()) {
            if (pIndex >= p.length()) {
                return true;
            } else {
                if ((p.length() - pIndex) % 2 == 0) {
                    for (int i = pIndex + 1; i < p.length(); i += 2) {
                        if (p.charAt(i) != '*') {
                            return false;
                        }
                    }
                    return true;
                } else {
                    return false;
                }
            }
        }
        if (pIndex >= p.length()) {
            return false;
        }
        Boolean thisResult = result[sIndex][pIndex];
        if (thisResult != null) {
            return thisResult;
        }
        thisResult = false;
        boolean nextMatchAny = pIndex < p.length() - 1 && p.charAt(pIndex + 1) == '*';
        if (p.charAt(pIndex) == '.' || p.charAt(pIndex) == s.charAt(sIndex)) {
            if (nextMatchAny) {
                thisResult = dp(s, p, sIndex+1, pIndex) || dp(s, p, sIndex, pIndex+2);
            } else {
                thisResult = dp(s, p, sIndex+1, pIndex+1);
            }
        } else if (p.charAt(pIndex) != s.charAt(sIndex)) {
            if (nextMatchAny) {
                thisResult = dp(s, p, sIndex, pIndex+2);
            }
        }
        result[sIndex][pIndex] = thisResult;
        return thisResult;
    }
}
