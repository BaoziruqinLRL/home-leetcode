package com.yyhome.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: linabell
 * @Date: 2023/1/17 9:37:04
 */
public class TotalNQueens52 {

    public static void main(String[] args) {
        System.out.println(new TotalNQueens52().totalNQueens(4));
        System.out.println(new TotalNQueens52().totalNQueens(5));
        System.out.println(new TotalNQueens52().totalNQueens(1));
    }

    int total = 0;

    /**
     * 执行耗时:8 ms,击败了5.51% 的Java用户
     * 内存消耗:40.8 MB,击败了5.06% 的Java用户
     * @param n
     * @return
     */
    public int totalNQueens(int n) {
        List<String> one = new ArrayList<>(n);
        String s = getQString(-1, n);
        for (int k = 0; k < n; k++) {
            one.add(s);
        }
        fill(one, 0, n);
        return total;
    }

    private void fill(List<String> one, int x, int n) {
        if (x >= n) {
            return;
        }
        for (int i = 0; i < n; i++) {
            if (canFill(one, x, i, n)) {
                one.set(x, getQString(i, n));
                if (x == n - 1) {
                    total++;
                } else {
                    fill(one, x + 1, n);
                }
                one.set(x, getQString(-1, n));
            }
        }
    }

    private String getQString(int x, int n) {
        char[] array = new char[n];
        for (int i = 0; i < n; i++) {
            array[i] = '.';
        }
        if (x >= 0) {
            array[x] = 'Q';
        }
        return new String(array);
    }

    private boolean canFill(List<String> one, int x, int y, int n) {
        for (int i = 0; i < n; i++) {
            if (one.get(x).charAt(i) == 'Q') {
                return false;
            }
            if (one.get(i).charAt(y) == 'Q') {
                return false;
            }
        }
        for (int i = 1; i <= Math.min(x, n-y-1); i++) {
            if (one.get(x-i).charAt(y+i) == 'Q') {
                return false;
            }
        }
        for (int i = 1; i <= Math.min(n-x-1, y); i++) {
            if (one.get(y-i).charAt(x+i) == 'Q') {
                return false;
            }
        }
        for (int i = 1; i <= Math.min(x, y); i++) {
            if (one.get(x-i).charAt(y-i) == 'Q') {
                return false;
            }
        }
        for (int i = 1; i < (n-Math.max(x, y)); i++) {
            if (one.get(x+i).charAt(y+i) == 'Q') {
                return false;
            }
        }
        return true;
    }
}
