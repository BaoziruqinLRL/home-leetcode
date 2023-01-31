package com.yyhome.leetcode.hard;

/**
 * 排列序列 60
 * @Author: linabell
 * @Date: 2023/1/29 15:58:13
 */
public class GetPermutation60 {

    public static void main(String[] args) {
        System.out.println(new GetPermutation60().getPermutation(4, 2));
        System.out.println(new GetPermutation60().getPermutation(4, 1));
        System.out.println(new GetPermutation60().getPermutation(3, 1));
        System.out.println(new GetPermutation60().getPermutation(3, 2));
        System.out.println(new GetPermutation60().getPermutation(4, 19));
        System.out.println(new GetPermutation60().getPermutation(4, 20));
        System.out.println(new GetPermutation60().getPermutation(3, 3));
        System.out.println(new GetPermutation60().getPermutation(4, 9));
        System.out.println(new GetPermutation60().getPermutation(3, 1));
    }

    int[] ch;

    /**
     * 执行耗时:8 ms,击败了39.03% 的Java用户
     * 内存消耗:39.7 MB,击败了20.35% 的Java用户
     * @param n
     * @param k
     * @return
     */
    public String getPermutation(int n, int k) {
        int max = 1;
        ch = new int[n];
        for (int i = 1; i <= n; i++) {
            max *= i;
            ch[i-1] = i;
        }
        return cycle(n, k, max);
    }


    public String cycle(int n, int k, int m) {
        if (n == 1) {
            return "" + findReplace(1);
        }
        int oneMax = m / n;
        int num = (k - 1) / oneMax + 1;
        return findReplace(num) + cycle(n - 1, k - (oneMax * (num - 1)), oneMax);
    }

    private int findReplace(int num) {
        num--;
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == 0) {
                continue;
            }
            if (num == 0) {
                int c = ch[i];
                ch[i] = 0;
                return c;
            }
            num--;
        }
        return 0;
    }
}
