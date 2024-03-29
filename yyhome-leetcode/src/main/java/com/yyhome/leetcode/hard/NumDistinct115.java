package com.yyhome.leetcode.hard;

/**
 * @Author: linabell
 * @Date: 2023/2/6 15:48:11
 */
public class NumDistinct115 {
    public static void main(String[] args) {
        System.out.println(new NumDistinct115().numDistinct("babgbag", "bag"));
        System.out.println(new NumDistinct115().numDistinct("ddd", "dd"));
        System.out.println(new NumDistinct115().numDistinct("adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc", "bcddceeeebecbc"));
        System.out.println(new NumDistinct115().numDistinct("rabbbit", "rabbit"));


        System.out.println(new NumDistinct115().numDistinctDp("babgbag", "bag"));
        System.out.println(new NumDistinct115().numDistinctDp("ddd", "dd"));
        System.out.println(new NumDistinct115().numDistinctDp("adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc", "bcddceeeebecbc"));
        System.out.println(new NumDistinct115().numDistinctDp("rabbbit", "rabbit"));


        System.out.println(new NumDistinct115().numDistinct2("babgbag", "bag"));
        System.out.println(new NumDistinct115().numDistinct2("ddd", "dd"));
        System.out.println(new NumDistinct115().numDistinct2("adbdadeecadeadeccaeaabdabdbcdabddddabcaaadbabaaedeeddeaeebcdeabcaaaeeaeeabcddcebddebeebedaecccbdcbcedbdaeaedcdebeecdaaedaacadbdccabddaddacdddc", "bcddceeeebecbc"));
        System.out.println(new NumDistinct115().numDistinct2("rabbbit", "rabbit"));
    }

    /**
     * 执行耗时:2094 ms,击败了5.74% 的Java用户
     * 内存消耗:48.3 MB,击败了77.65% 的Java用户
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {
        return cycle(s, t, 0, 0, new Integer[s.length()+1][t.length()+1]);
    }

    private int cycle(String s, String t, int sIndex, int tIndex, Integer[][] arr) {
        if (arr[sIndex][tIndex] != null) {
            return arr[sIndex][tIndex];
        }
        if (tIndex == t.length()) {
            return 1;
        }
        int res = 0;
        for (int i = sIndex; i < s.length(); i++) {
            if (s.charAt(i) == t.charAt(tIndex)) {
                res += cycle(s, t, i + 1, tIndex + 1, arr);
            }
        }
        arr[sIndex][tIndex] = res;
        return res;
    }

    /**
     * 执行耗时:14 ms,击败了51.81% 的Java用户
     * 内存消耗:48.2 MB,击败了80.47% 的Java用户
     * @param s
     * @param t
     * @return
     */
    public int numDistinctDp(String s, String t) {
        // dp[i][j]代表s.substring(i)中t.substring(j)的子序列的个数
        int[][] dp = new int[s.length()+1][t.length()+1];
        int i = s.length() - 1;
        // 初始化第t.length()-1列
        for (int c = 0; i >= 0; i--) {
            if (s.charAt(i) == t.charAt(t.length()-1)) {
                dp[i][t.length()-1] = ++c;
            } else {
                dp[i][t.length()-1] = dp[i+1][t.length()-1];
            }
        }
        for (i = s.length() - 1; i >= 0; i--) {
            for (int j = t.length() - 2; j >= 0; j--) {
                // 相等时, 可以选择以j去匹配i或者不匹配, 匹配的话就往后i+1和j+1, 不匹配的话就往后i+1和j
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] = dp[i+1][j] + dp[i+1][j+1];
                } else {
                    dp[i][j] = dp[i+1][j];
                }
            }
        }
        return dp[0][0];
    }


    /**
     * 执行耗时:6 ms,击败了91.09% 的Java用户
     * 内存消耗:54.1 MB,击败了5.06% 的Java用户
     * @param s
     * @param t
     * @return
     */
    public int numDistinct2(String s, String t) {
        if (t.length() > s.length()) {
            return 0;
        }
        // dp[x][y] 代表t字符串中倒数一共x+1个元素在s字符串中从y位置开始的子串个数，
        // 那么dp[x-1][y]就等于(假设t[x-1]=s[y]则返回dp[x][y+1]) + dp[x-1][y+1]
        // 通俗的解释就是t[x-1]在s[y]能匹配上的话，那么其字串数等于t[x]在s[y+1]处的
        // 字串数量加上t[x-1]在s[y+1]处的子串数量，不能匹配上的话就纯等于t[x-1]在s[y+1]处的子串数量
        long[][] dp = new long[t.length()][s.length()];
        dp[0][s.length() - 1] = s.charAt(s.length() - 1) == t.charAt(t.length() - 1) ? 1 : 0;
        char tl = t.charAt(t.length() - 1);
        for (int j = s.length() - 2; j >= t.length() - 1; j--) {
            dp[0][j] = dp[0][j+1] + (s.charAt(j) == tl ? 1 : 0);
        }
        for (int i = 1; i < t.length(); i++) {
            char ti = t.charAt(t.length() - i - 1);
            if (s.charAt(s.length() - i - 1) == ti) {
                dp[i][s.length() - i - 1] = dp[i-1][s.length() - i];
            } else {
                dp[i][s.length() - i - 1] = 0;
            }
            for (int j = s.length() - i - 2; j >= t.length() - i - 1; j--) {
                dp[i][j] = dp[i][j+1];
                if (s.charAt(j) == ti) {
                    dp[i][j] += dp[i-1][j+1];
                }
            }
        }
        return (int) (dp[t.length()-1][0]);
    }
}
