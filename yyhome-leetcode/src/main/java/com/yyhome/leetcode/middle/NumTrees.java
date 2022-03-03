package com.yyhome.leetcode.middle;

/**
 * 96 不同的二叉搜索树
 * @author: lirl
 * @date: 2021/5/8
 */
public class NumTrees {

    public static void main(String[] args) {
        System.out.println(new NumTrees().numTrees(3));
        System.out.println(new NumTrees().numTrees(5));
        System.out.println(new NumTrees().numTrees(1));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:35.4 MB,击败了15.78% 的Java用户
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if (n <= 1) {
            return n;
        }
        int[] count = new int[n+1];
        count[0] = 0;
        count[1] = 1;
        for (int i = 2; i <= n ; i++) {
            count[i] += 2 * count[i-1];
            for (int j = 1; j < i - 1; j++) {
                count[i] += count[j] * count[i - 1 - j];
            }
        }
        return count[n];
    }
}
