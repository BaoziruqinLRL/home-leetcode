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
     * 执行耗时:8 ms,击败了29.83% 的Java用户
     * 内存消耗:44.2 MB,击败了25.00% 的Java用户
     * 回溯查找
     * @param S
     * @return
     */
    public String[] permutation(String S) {
        List<String> result = new ArrayList<>();
        cycle(result, 0, S.toCharArray(), "", new int[S.length()]);
        return result.toArray(new String[0]);
    }

    private void cycle(List<String> result, int index, char[] ca, String last, int[] taked) {
        if (index == ca.length) {
            result.add(last);
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < ca.length; i++) {
            if (taked[i] == 0 && !set.contains(ca[i])) {
                taked[i] = 1;
                set.add(ca[i]);
                cycle(result, index + 1, ca, last + ca[i], taked);
                taked[i] = 0;
            }
        }
    }
}
