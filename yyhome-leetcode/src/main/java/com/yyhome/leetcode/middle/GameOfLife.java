package com.yyhome.leetcode.middle;

import java.util.Arrays;

/**
 * 289 生命游戏
 * @author miluo
 * @date 2020-04-02
 */
public class GameOfLife {

    public static void main(String[] args){
        int[][] arr = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(arr);
        print(arr);
    }

    private static void gameOfLife(int[][] board) {
        int line = board.length;
        int column = board[0].length;
        int[][] newBoard = new int[line][column];
        for (int i = 0; i < line; i++){
            for (int j = 0; j < column; j++){
                if (board[i][j] == 0){
                    // 死细胞 复活条件
                    newBoard[i][j] = deathToLive(board,i,j,line,column) ? 1 : 0;
                }else{
                    // 活细胞 死亡条件
                    newBoard[i][j] = liveToDeath(board,i,j,line,column);
                }
            }
        }
        System.arraycopy(newBoard, 0, board, 0, line);
    }

    private static boolean deathToLive(int[][] board, int i, int j, int line, int column){
        int count = 0;
        for (int ii = i - 1, num = 0; num < 3;ii++,num++){
            for (int jj = j - 1, numm = 0; numm < 3;jj++,numm++){
                if (ii == i && jj == j){
                    continue;
                }else{
                    count += (ii >= 0 && ii < line && jj >= 0 && jj < column) ? board[ii][jj] : 0;
                }
            }
        }
        return count == 3;
    }

    private static int liveToDeath(int[][] board, int i, int j, int line, int column){
        int count = 0;
        for (int ii = i - 1, num = 0; num < 3;ii++,num++){
            for (int jj = j - 1, numm = 0; numm < 3;jj++,numm++){
                if (ii == i && jj == j){
                    continue;
                }else{
                    count += (ii >= 0 && ii < line && jj >= 0 && jj < column) ? board[ii][jj] : 0;
                }
            }
        }
        return (count >= 2 && count <= 3) ? 1 : 0;
    }

    private static void print(int[][] board){
        for (int[] b : board){
            System.out.println(Arrays.toString(b));
        }
    }
}
