package com.yyhome.leetcode.easy;

import java.util.Arrays;

/**
 * mst 29 顺时针打印矩阵
 * @author miluo
 * @date 2020-03-20
 */
public class SpiralOrder {

    public static void main(String[] args){
        System.out.println(Arrays.toString(spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}})));
        System.out.println(Arrays.toString(spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}})));
        System.out.println(Arrays.toString(spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}})));
        System.out.println(Arrays.toString(spiralOrder(new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}})));
    }

    private static int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0){
            return new int[0];
        }
        int count = matrix.length * matrix[0].length;
        int[] res = new int[count];

        int row = 0;
        int line = 0;
        // 0 → 1 ↓  2 ← 3 ↑
        int flag = 0;
        int[] rowLimit = new int[]{0,matrix[0].length - 1};
        int[] lineLimit = new int[]{0,matrix.length - 1};
        int num = 0;
        while (num < count){
            res[num++] = matrix[line][row];
            if (flag == 0){
                if (row < rowLimit[1]){
                    row++;
                }else if (row == rowLimit[1]){
                    flag = 1;
                    line++;
                    rowLimit[1]--;
                    lineLimit[0]++;
                }
            }else if (flag == 1){
                if (line < lineLimit[1]){
                    line++;
                }else if (line == lineLimit[1]){
                    flag = 2;
                    row--;
                    lineLimit[1]--;
                }
            }else if (flag == 2){
                if (row > rowLimit[0]){
                    row--;
                }else if (row == rowLimit[0]){
                    flag = 3;
                    line--;
                    rowLimit[0]++;
                }
            }else if (flag == 3){
                if (line > lineLimit[0]){
                    line--;
                }else if (line == lineLimit[0]){
                    flag = 0;
                    row++;
                }
            }
        }
        return res;
    }
}
