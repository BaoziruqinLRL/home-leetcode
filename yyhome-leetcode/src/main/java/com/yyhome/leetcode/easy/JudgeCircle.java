package com.yyhome.leetcode.easy;

/**
 * 657 机器人是否返回原点
 * @author: lirl
 * @date: 2021/3/31
 */
public class JudgeCircle {

    public static void main(String[] args) {
        System.out.println(new JudgeCircle().judgeCircle("UD"));
        System.out.println(new JudgeCircle().judgeCircle("LL"));
    }

    /**
     * 5 ms 93%
     * 38.5 MB 49%
     * @param moves
     * @return
     */
    public boolean judgeCircle(String moves) {
        int r = 0, l = 0;
        for (char c : moves.toCharArray()){
            if (c == 'U'){
                l++;
            } else if (c == 'D'){
                l--;
            } else if (c == 'L'){
                r++;
            } else if (c == 'R'){
                r--;
            }
        }
        return r == 0 && l == 0;
    }
}
