package com.yyhome.leetcode.middle;

import java.util.Arrays;

/**
 * 59 螺旋矩阵Ⅱ
 * @Author: linabell
 * @Date: 2022/7/21 16:55:19
 */
public class GenerateMatrix59 {

    public static void main(String[] args){
        System.out.println(Arrays.deepToString(new GenerateMatrix59().generateMatrix(2)));
        System.out.println(Arrays.deepToString(new GenerateMatrix59().generateMatrix(3)));
        System.out.println(Arrays.deepToString(new GenerateMatrix59().generateMatrix(1)));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:39.4 MB,击败了53.61% 的Java用户
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        Bound bound = new Bound(n);
        int startNum = 1;
        int middle = n / 2;
        while (!((bound.up == middle && bound.left == middle && bound.down == middle && bound.right == middle) || startNum > n * n)) {
            startNum = fillRight(res, startNum, bound);
            startNum = fillDown(res, startNum, bound);
            startNum = fillLeft(res, startNum, bound);
            startNum = fillUp(res, startNum, bound);
        }
        if (n % 2 != 0) {
            res[middle][middle] = n * n;
        }
        return res;
    }

    private int fillLeft(int[][] res, int startNum, Bound bound) {
        for (int i = bound.right; i >= bound.left; i--) {
            res[bound.down][i] = startNum++;
        }
        bound.down = bound.down - 1;
        return startNum;
    }

    private int fillRight(int[][] res, int startNum, Bound bound) {
        for (int i = bound.left; i <= bound.right; i++) {
            res[bound.up][i] = startNum++;
        }
        bound.up = bound.up + 1;
        return startNum;
    }

    private int fillUp(int[][] res, int startNum, Bound bound) {
        for (int i = bound.down; i >= bound.up; i--) {
            res[i][bound.left] = startNum++;
        }
        bound.left = bound.left + 1;
        return startNum;
    }

    private int fillDown(int[][] res, int startNum, Bound bound) {
        for (int i = bound.up; i <= bound.down; i++) {
            res[i][bound.right] = startNum++;
        }
        bound.right = bound.right - 1;
        return startNum;
    }

    public static class Bound {
        public Bound(int n) {
            this.right = n - 1;
            this.down = n - 1;
        }
        int left;
        int right;
        int up;
        int down;
    }
}
