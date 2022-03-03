package com.yyhome.leetcode.easy;

/**
 * 766 托普利茨矩阵
 * @author: lirl
 * @date: 2021/4/6
 */
public class IsToeplitzMatrix {

    public static void main(String[] args){
        System.out.println(new IsToeplitzMatrix().isToeplitzMatrix(new int[][]{{1,2,3,4}, {5,1,2,3}, {9,5,1,2}}));
        System.out.println(new IsToeplitzMatrix().isToeplitzMatrix(new int[][]{{1,2}, {2,2}}));
    }

    /**
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:38.7 MB,击败了41.79% 的Java用户
     * @param matrix
     * @return
     */
    public boolean isToeplitzMatrix(int[][] matrix) {
        int x = matrix.length - 1, y = 0;
        for (;x >= 0 && y < matrix[0].length;){
            int num = matrix[x][y];
            for (int i = x, j = y; i < matrix.length && j < matrix[0].length;i++, j++){
                if (matrix[i][j] != num){
                    return false;
                }
            }
            if (x == 0){
                y++;
            } else {
                x--;
            }
        }
        return true;
    }
}
