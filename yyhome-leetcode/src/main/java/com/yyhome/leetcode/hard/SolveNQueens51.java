package com.yyhome.leetcode.hard;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * N皇后 51
 * @Author: linabell
 * @Date: 2023/1/16 16:45:25
 */
public class SolveNQueens51 {

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new SolveNQueens51().solveNQueens(4)));
        System.out.println(JSON.toJSONString(new SolveNQueens51().solveNQueens(5)));
        System.out.println(JSON.toJSONString(new SolveNQueens51().solveNQueens(1)));
    }

    /**
     * 执行耗时:8 ms,击败了12.04% 的Java用户
     * 内存消耗:42.2 MB,击败了18.78% 的Java用户
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        List<String> one = new ArrayList<>(n);
        String s = getQString(-1, n);
        for (int k = 0; k < n; k++) {
            one.add(s);
        }
        fill(res, one, 0, n);
        return res;
    }

    private void fill(List<List<String>> res, List<String> one, int x, int n) {
        if (x >= n) {
            return;
        }
        for (int i = 0; i < n; i++) {
            if (canFill(one, x, i, n)) {
                one.set(x, getQString(i, n));
                if (x == n - 1) {
                    res.add(new ArrayList<>(one));
                } else {
                    fill(res, one, x + 1, n);
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
