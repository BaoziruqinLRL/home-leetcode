package com.yyhome.leetcode.easy;

/**
 * 836 矩形重叠
 * @author miluo
 * @date 2020-03-18
 */
public class IsRectangleOverlap {

    public static void main(String[] args){
        System.out.println(isRectangleOverlap(new int[]{0,0,2,2},new int[]{1,1,3,3}));
        System.out.println(isRectangleOverlap(new int[]{0,0,1,1},new int[]{1,0,2,1}));
        // [5,15,8,18]
        //[0,3,7,9]
        /**
         * 18                *
         * 17
         * 16
         * 15           *
         * 14
         * 13
         * 12
         * 11
         * 10
         * 9                *
         * 8
         * 7
         * 6
         * 5
         * 4
         * 3  *
         * 2
         * 1
         * 0
         *    0 1 2 3 4 5 6 7 8
         */
        System.out.println(isRectangleOverlap(new int[]{5,15,8,18},new int[]{0,3,7,9}));
        System.out.println(isRectangleOverlap(new int[]{-257926405,-680763313,702840196,454409669},new int[]{-275916328,-417802221,22808107,675629469}));
    }

    private static boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // true表示重叠，false表示不重叠
        boolean xRectangleOver = ((long) (rec1[2] - rec1[0]) + (long) (rec2[2] - rec2[0])) > Math.max(Math.abs(rec2[2] - rec1[0]), Math.abs(rec1[2] - rec2[0]));
        boolean yRectangleOver = ((long) (rec1[3] - rec1[1]) + (long) (rec2[3] - rec2[1])) > Math.max(Math.abs(rec2[3] - rec1[1]), Math.abs(rec1[3] - rec2[1]));
        return xRectangleOver && yRectangleOver;
    }
}
