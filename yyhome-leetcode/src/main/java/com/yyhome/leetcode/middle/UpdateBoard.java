package com.yyhome.leetcode.middle;

import java.util.Arrays;

/**
 * 529 扫雷游戏
 * @author: lirl
 * @date: 2021/6/3
 */
public class UpdateBoard {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new UpdateBoard().updateBoard(new char[][]{{'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'M', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}, {'E', 'E', 'E', 'E', 'E'}}, new int[]{3, 0})));
        System.out.println(Arrays.deepToString(new UpdateBoard().updateBoard(new char[][]{{'B', '1', 'E', '1', 'B'}, {'B', '1', 'M', '1', 'B'}, {'B', '1', '1', '1', 'B'}, {'B', 'B', 'B', 'B', 'B'}}, new int[]{1, 2})));
    }

    private static final int[][] POSITION = new int[][]{{0,1},{0,-1},{1,0},{1,-1},{1,1},{-1,0},{-1,-1},{-1,1}};

    /**
     * 执行耗时:1 ms,击败了67.50% 的Java用户
     * 内存消耗:38.9 MB,击败了48.75% 的Java用户
     * @param board
     * @param click
     * @return
     */
    public char[][] updateBoard(char[][] board, int[] click) {
        dfs(board, click[0], click[1]);
        return board;
    }

    private void dfs(char[][] board, int x, int y) {
        if (board[x][y] == 'M'){
            board[x][y] = 'X';
        } else if (board[x][y] == 'E'){
            int aroundNum = aroundNum(board, x, y);
            if (aroundNum == 0) {
                board[x][y] = 'B';
                for (int[] ints : POSITION) {
                    if (x+ints[0] < board.length && x+ints[0] >= 0 && y+ints[1] < board[0].length && y+ints[1] >= 0) {
                        dfs(board, x + ints[0], y + ints[1]);
                    }
                }
            } else {
                board[x][y] = (char) (aroundNum + '0');
            }
        }
    }

    private int aroundNum(char[][] board, int x, int y) {
        int num = 0;
        for (int[] ints : POSITION) {
            if (x+ints[0] < board.length && x+ints[0] >= 0 && y+ints[1] < board[0].length && y+ints[1] >= 0) {
                if (board[x + ints[0]][y + ints[1]] == 'M') {
                    num++;
                }
            }
        }
        return num;
    }
}
