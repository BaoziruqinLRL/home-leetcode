package com.yyhome.leetcode.hard;

/**
 * 编辑距离 72
 * @Author: linabell
 * @Date: 2023/1/31 16:04:54
 */
public class MinDistance72 {

    public static void main(String[] args) {
        System.out.println(new MinDistance72().minDistance("park", "spake"));
        System.out.println(new MinDistance72().minDistance("horse", "ros"));
        System.out.println(new MinDistance72().minDistance("intention", "execution"));
    }

    int[][] array;

    /**
     * 执行耗时:5 ms,击败了45.43% 的Java用户
     * 内存消耗:43.1 MB,击败了5.05% 的Java用户
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        if (word1.equals(word2)) {
            return 0;
        }
        array = new int[word1.length()+1][word2.length()+1];
        return cycle(word1, word2, 0, 0);
    }

    public int cycle(String word1, String word2, int index1, int index2) {
        if (array[index1][index2] != 0) {
            return array[index1][index2];
        }
        int min;
        if (index2 == word2.length()) {
            // word2匹配完了, 剩下的全部截掉
            min = word1.length() - index1;
        } else if (index1 == word1.length()) {
            // word1匹配完了, 剩下的插入
            min = word2.length() - index2;
        } else if (word1.substring(index1).equals(word2.substring(index2))) {
            min = 0;
        } else if (word1.charAt(index1) == word2.charAt(index2)) {
            // 无动作
            min = cycle(word1, word2, index1 + 1, index2 + 1);
        } else {
            // 插入替换和删除
            int replace = cycle(word1, word2, index1 + 1, index2 + 1);
            int insert = cycle(word1, word2, index1, index2 + 1);
            int delete = cycle(word1, word2, index1 + 1, index2);
            min = 1 + Math.min(replace, Math.min(insert, delete));
        }
        array[index1][index2] = min;
        return min;
    }
}
