package com.yyhome.leetcode.middle;

import java.util.Arrays;

/**
 * 48 旋转图像
 * @author: lirl
 * @date: 2021/4/13
 */
public class Rotate {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        new Rotate().rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
        matrix = new int[][]{{5,1,9,11}, {2,4,8,10}, {13,3,6,7},{15,14,12,16}};
        new Rotate().rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.6 MB,击败了45.23% 的Java用户
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = i; j < matrix[i].length - i - 1; j++) {
                int x = i, y = j;
                int cur = matrix[x][y], nextCur;
                for (int count = 0; count < 4; count++) {
                    nextCur = matrix[y][matrix.length - 1 - x];
                    matrix[y][matrix.length - 1 - x] = cur;
                    cur = nextCur;
                    // 此时复用nextCur当临时变量
                    nextCur = y;
                    y = matrix.length - 1 - x;
                    x = nextCur;
                }
            }
        }
    }
}
