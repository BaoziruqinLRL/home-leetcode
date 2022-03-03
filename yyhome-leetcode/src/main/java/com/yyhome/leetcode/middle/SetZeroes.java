package com.yyhome.leetcode.middle;

import java.util.Arrays;

/**
 * 面试题 01.08 零矩阵
 * @author: lirl
 * @date: 2021/4/14
 */
public class SetZeroes {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,1,1}, {1,0,1}, {1,1,1}};
        new SetZeroes().setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
        matrix = new int[][]{{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};
        new SetZeroes().setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    /**
     * 执行耗时:2 ms,击败了43.26% 的Java用户
     * 内存消耗:40.3 MB,击败了8.33% 的Java用户
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int[] row = new int[matrix.length];
        int[] line = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    line[j] = 1;
                }
            }
        }
        for (int i = 0; i < row.length; i++) {
            if (row[i] == 1) {
                Arrays.fill(matrix[i], 0);
            }
        }
        for (int i = 0; i < line.length; i++) {
            if (line[i] == 1) {
                for (int ii = 0; ii < matrix.length; ii++) {
                    matrix[ii][i] = 0;
                }
            }
        }
    }
}
