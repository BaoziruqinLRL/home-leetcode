package com.yyhome.leetcode.middle;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * 面试题08.08
 * @Author: liriling
 * @Date: 2025/3/26 15:17
 */
public class Permutation0808 {

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new Permutation0808().permutation("Frx")));
        System.out.println(JSON.toJSONString(new Permutation0808().permutation("eqq")));
        System.out.println(JSON.toJSONString(new Permutation0808().permutation("ab")));
    }

    /**
     * 执行耗时:6 ms,击败了32.58% 的Java用户
     * 内存消耗:43.9 MB,击败了39.33% 的Java用户
     * 回溯查找
     * @param S
     * @return
     */
    public String[] permutation(String S) {
        List<String> result = new ArrayList<>();
        char[] charArray = S.toCharArray();
        Arrays.sort(charArray);
        cycle(result, 0, charArray, "", new int[S.length()]);
        return result.toArray(new String[0]);
    }

    private void cycle(List<String> result, int index, char[] ca, String last, int[] taked) {
        if (index == ca.length) {
            result.add(last);
            return;
        }
        char lastChar = '0';
        for (int i = 0; i < ca.length; i++) {
            if (taked[i] == 0 && lastChar != ca[i]) {
                taked[i] = 1;
                lastChar = ca[i];
                cycle(result, index + 1, ca, last + ca[i], taked);
                taked[i] = 0;
            }
        }
    }
}
