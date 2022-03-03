package com.yyhome.leetcode.middle;

/**
 * 74 搜索二维矩阵
 * @author: lirl
 * @date: 2021/4/20
 */
public class SearchMatrix {

    public static void main(String[] args) {
        System.out.println(new SearchMatrix().searchMatrix(new int[][]{{1}}, 2));
        System.out.println(new SearchMatrix().searchMatrix(new int[][]{{1}}, 1));
        System.out.println(new SearchMatrix().searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3));
        System.out.println(new SearchMatrix().searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 13));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:37.8 MB,击败了79.12% 的Java用户
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0, end = matrix.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (matrix[middle][0] <= target && target <= matrix[middle][matrix[middle].length - 1]) {
                return search(matrix[middle], target);
            } else if (matrix[middle][0] > target) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return false;
    }

    private boolean search(int[] matrix, int target) {
        int start = 0, end = matrix.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (matrix[middle] == target) {
                return true;
            } else if (matrix[middle] < target) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return false;
    }
}
