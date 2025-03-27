package com.yyhome.leetcode.middle;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: liriling
 * @Date: 2025/3/27 9:16
 */
public class Respace1713 {

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new Respace1713().respace(new String[]{"sssjjs","hschjf","hhh","fhjchfcfshhfjhs","sfh","jsf","cjschjfscscscsfjcjfcfcfh","hccccjjfchcffjjshccsjscsc","chcfjcsshjj","jh","h","f","s","jcshs","jfjssjhsscfc"}, "sssjjssfshscfjjshsjjsjchffffs")));
        System.out.println(JSON.toJSONString(new Respace1713().respace(new String[]{"looked","just","like","her","brother"}, "jesslookedjustliketimherbrother")));
        System.out.println(JSON.toJSONString(new Respace1713().respace(new String[]{"looked","just","like","her","jesslooked","brother"}, "jesslookedjustliketimherbrother")));
    }

    /**
     * 执行耗时:727 ms,击败了6.17% 的Java用户
     * 内存消耗:44.9 MB,击败了75.34% 的Java用户
     * @param dictionary
     * @param sentence
     * @return
     */
    public int respace(String[] dictionary, String sentence) {
        if (sentence.length() == 0) {
            return 0;
        }
        Set<String> dict = new HashSet<>(Arrays.asList(dictionary));
        int[] dp = new int[sentence.length() + 1];
        Arrays.fill(dp, sentence.length());
        dp[0] = 0;
        if (dict.contains(sentence.substring(0, 1))) {
            dp[1] = 0;
        } else {
            dp[1] = 1;
        }
        for (int i = 2; i <= sentence.length(); i++) {
            for (int j = 1; j <= i; j++) {
                if (dict.contains(sentence.substring(j - 1, i))) {
                    dp[i] = Math.min(dp[i], dp[j-1]);
                } else {
                    dp[i] = Math.min(dp[i], dp[j-1] + i - j + 1);
                }
            }
        }
        return dp[sentence.length()];
    }

    /**
     *
     * 执行耗时:65 ms,击败了40.41% 的Java用户
     * 内存消耗:44.4 MB,击败了97.95% 的Java用户
     *
     * 题解做法
     * 每次遍历字典所有字符串查看是否匹配
     * @param dictionary
     * @param sentence
     * @return
     */
    public int respace2(String[] dictionary, String sentence) {
        int n = sentence.length();
        int m = dictionary.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i-1];
            for (int j = 0; j < m ; j++) {
                if (i < dictionary[j].length()) continue;
                if (sentence.substring(i - dictionary[j].length(), i).equals(dictionary[j])) {
                    dp[i] = Math.max(dp[i - dictionary[j].length()] + dictionary[j].length(), dp[i]);
                }
            }
        }
        return n - dp[n];
    }
}
