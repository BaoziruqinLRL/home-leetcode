package com.yyhome.leetcode.easy;

import java.util.Arrays;

/**
 * 566 重塑矩阵
 * @author: lirl
 * @date: 2021/3/29
 */
public class MatrixReshape {


    public static void main(String[] args){
        System.out.println(Arrays.deepToString(new MatrixReshape().matrixReshape(new int[][]{{1,2},{3,4}}, 1, 4)));
        System.out.println(Arrays.deepToString(new MatrixReshape().matrixReshape(new int[][]{{1,2},{3,4}}, 4, 1)));
        System.out.println(Arrays.deepToString(new MatrixReshape().matrixReshape(new int[][]{{1,2},{3,4}}, 2, 4)));
    }

    /**
     * 执行耗时:2 ms,击败了42.71% 的Java用户
     * 内存消耗:39.8 MB,击败了21.53% 的Java用户
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length * nums[0].length != r*c){
            return nums;
        }
        int ni = 0, nj = 0;
        int[][] res = new int[r][c];
        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                res[i][j] = nums[ni][nj++];
                if (nj == nums[ni].length){
                    ni++;
                    nj = 0;
                }
            }
        }
        return res;
    }
}
