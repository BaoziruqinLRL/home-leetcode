package com.yyhome.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: linabell
 * @Date: 2022/9/30 10:00:36
 */
public class SolveSudoku37 {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        new SolveSudoku37().solveSudoku(board);
        System.out.println(Arrays.toString(board));
    }

    /**
     * 执行耗时:3 ms,击败了64.37% 的Java用户
     * 内存消耗:40.9 MB,击败了8.00% 的Java用户
     * @param board
     */
    public void solveSudoku(char[][] board) {
        int[][] record = new int[3][9];
        // 初始化record
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    fillToRecord(record, i, j, board[i][j] - '0');
                }
            }
        }
        cycle(board, record, 0, 0);
    }

    public boolean cycle(char[][] board, int[][] record, int i, int j) {
        if (i > 8) {
            return true;
        }
        if (board[i][j] == '.') {
            List<Integer> canFill = findCanFill(record, i, j);
            if (canFill.size() == 0) {
                return false;
            }
            for (Integer num : canFill) {
                board[i][j] = (char) (num + '0');
                fillToRecord(record, i, j, num);
                boolean cycle = cycle(board, record, j == 8 ? i + 1 : i, j == 8 ? 0 : j + 1);
                if (!cycle) {
                    removeRecord(record, i, j, num);
                    board[i][j] = '.';
                } else {
                    return true;
                }
            }
            return false;
        } else {
            return cycle(board, record, j == 8 ? i + 1 : i, j == 8 ? 0 : j + 1);
        }
    }

    /**
     * 查找某个位置可填充的数字列表
     * @param record
     * @param i
     * @param j
     * @return
     */
    private List<Integer> findCanFill(int[][] record, int i, int j) {
        // 查找横排, 用i查找
        int iValue = record[0][i];
        // 查找竖排, 用j查找
        int jValue = record[1][j];
        // 查找九宫格, 用3*(i/3) + j/3查找
        int nineValue = record[2][3*(i/3) + j/3];
        int remainValue = iValue | jValue | nineValue;
        List<Integer> result = new ArrayList<>();
        for (int x = 1, andValue = 1; x <= 9; x++) {
            int v = remainValue & andValue;
            if (v == 0) {
                result.add(x);
            }
            remainValue >>= 1;
        }
        return result;
    }

    /**
     * 填充记录
     * @param record
     * @param i
     * @param j
     * @param num
     */
    private void fillToRecord(int[][] record, int i, int j, int num) {
        int v = 1 << (num - 1);
        record[0][i] |= v;
        record[1][j] |= v;
        record[2][3*(i/3) + j/3] |= v;
    }

    /**
     * 移除记录
     * @param record
     * @param i
     * @param j
     * @param num
     */
    private void removeRecord(int[][] record, int i, int j, int num) {
        int v = 1 << (num - 1);
        record[0][i] ^= v;
        record[1][j] ^= v;
        record[2][3*(i/3) + j/3] ^= v;
    }
}
