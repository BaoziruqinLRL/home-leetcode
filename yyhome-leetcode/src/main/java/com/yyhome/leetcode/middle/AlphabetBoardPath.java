package com.yyhome.leetcode.middle;

/**
 * 1138 字母板上的路径
 * @author: lirl
 * @date: 2021/7/6
 */
public class AlphabetBoardPath {

    public static void main(String[] args){
        System.out.println(new AlphabetBoardPath().alphabetBoardPath("buzz"));
        System.out.println(new AlphabetBoardPath().alphabetBoardPath("zb"));
        System.out.println(new AlphabetBoardPath().alphabetBoardPath("zz"));
        System.out.println(new AlphabetBoardPath().alphabetBoardPath("zdz"));
        System.out.println(new AlphabetBoardPath().alphabetBoardPath("leet"));
        System.out.println(new AlphabetBoardPath().alphabetBoardPath("code"));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:36.4 MB,击败了79.35% 的Java用户
     * @param target
     * @return
     */
    public String alphabetBoardPath(String target) {
        StringBuilder sb = new StringBuilder();
        int x = 0, y = 0;
        for (char c : target.toCharArray()) {
            int ci = c - 'a';
            int taX = ci / 5, taY = ci % 5;
            boolean zChange = c == 'z' && (x != taX || y != taY);
            if (zChange) {
                taX = taX - 1;
            }
            if (taX > x) {
                int i = 0;
                while (i++ < Math.abs(taX - x)) {
                    sb.append('D');
                }
            } else {
                int i = 0;
                while (i++ < Math.abs(taX - x)) {
                    sb.append('U');
                }
            }
            if (taY > y) {
                int i = 0;
                while (i++ < Math.abs(taY - y)) {
                    sb.append('R');
                }
            } else {
                int i = 0;
                while (i++ < Math.abs(taY - y)) {
                    sb.append('L');
                }
            }
            if (zChange) {
                sb.append('D');
                taX++;
            }
            sb.append("!");
            x = taX;
            y = taY;
        }
        return sb.toString();
    }
}
