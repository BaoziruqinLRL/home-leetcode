package com.yyhome.leetcode.middle;

/**
 * 有效的井字游戏 794
 * @author miluo
 * @date 2019-11-01
 */
public class ValidTicTacToe {

    public static void main(String[] args){
        System.out.println(validTicTacToe(new String[]{"O  ", "   ", "   "}));
        System.out.println(validTicTacToe(new String[]{"XOX", " X ", "   "}));
        System.out.println(validTicTacToe(new String[]{"XXX", "   ", "OOO"}));
        System.out.println(validTicTacToe(new String[]{"XOX", "O O", "XOX"}));
        System.out.println(validTicTacToe(new String[]{"XXX", "OOX", "OOX"}));
        System.out.println(validTicTacToe(new String[]{"XXX", "XOO", "OO "}));
        System.out.println(validTicTacToe(new String[]{"XOX", "OXO", "OXX"}));
        System.out.println(validTicTacToe(new String[]{"XXO", "XOX", "OXO"}));
    }

    private static boolean validTicTacToe(String[] board) {
        int[][] intBoard = new int[3][3];
        int oNum = 0;
        int xNum = 0;
        int row = 0;
        int col = 0;
        for (String s : board){
            for (char c : s.toCharArray()){
                if (c == 'O'){
                    intBoard[row][col++] = -1;
                    oNum++;
                }else if (c == 'X'){
                    intBoard[row][col++] = 1;
                    xNum++;
                }else{
                    intBoard[row][col++] = 0;
                }
            }
            row++;
            col = 0;
        }
        return isValid(intBoard,oNum,xNum);
    }

    private static boolean isValid(int[][] borad, int oNum, int xNum){
        // 数量不符合则不是合理棋盘, O必须小于等于X, 且差值不能大于1
        if (Math.abs(xNum - oNum) <= 1 && oNum <= xNum){
            int oConnect = connectNum(borad,-1);
            int xConnect = connectNum(borad,1);
            return oConnect * xConnect == 0 && ((xConnect > 0 && xNum > oNum) || (oConnect > 0 && oNum == xNum) || (xConnect == oConnect));
        }
        return false;
    }

    private static int connectNum(int[][] board, int point){
        int connectCount = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (board[i][j] == point){
                    if (board[(i+1)%3][j] == point && board[(i+2)%3][j] == point){
                        connectCount++;
                    }
                    if (board[i][(j+1)%3] == point && board[i][(j+2)%3] == point){
                        connectCount++;
                    }
                    if (i == j && board[(i+1)%3][(j+1)%3] == point && board[(i+2)%3][(j+2)%3] == point){
                        connectCount++;
                    }
                    if (i + j == 2 && board[(i+4)%3][(j+2)%3] == point && board[(i+5)%3][(j+4)%3] == point){
                        connectCount++;
                    }
                }
            }
        }
        return connectCount;
    }
}
