package com.yyhome.leetcode.middle;

/**
 * 79 单词搜索
 * @author lirl
 * @date 2021-4-28 17:58:23
 */
public class Exist {

    public static void main(String[] args){
        System.out.println(new Exist().exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
        System.out.println(new Exist().exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "SEE"));
        System.out.println(new Exist().exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB"));
    }

    private int[][] loop = new int[][]{{-1, 0},{1, 0}, {0, -1}, {0, 1}};

    /**
     * 执行耗时:98 ms,击败了29.12% 的Java用户
     * 内存消耗:36.7 MB,击败了75.30% 的Java用户
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        int[][] cut = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                cut[i][j] = -1;
                if (back(0, board, word, cut, i, j)){
                    return true;
                }
                cut[i][j] = 0;
            }
        }
        return false;
    }

    private boolean back(int position, char[][] board, String word, int[][] cut, int i, int j) {
        if (position >= word.length() || board[i][j] != word.charAt(position)) {
            return false;
        } else if (position == word.length() - 1 && board[i][j] == word.charAt(position)) {
            return true;
        } else {
            for (int[] dir : loop) {
                int it = i + dir[0], jt = j + dir[1];
                if (0 <= it && it < board.length && 0 <= jt && jt < board[it].length && cut[it][jt] == 0) {
                    cut[it][jt] = -1;
                    if (back(position + 1, board, word, cut, it, jt)){
                        return true;
                    } else {
                        cut[it][jt] = 0;
                    }
                }
            }
            return false;
        }
    }
}
