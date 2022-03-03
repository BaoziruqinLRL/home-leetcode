package com.yyhome.leetcode.middle;

/**
 * 1824 最少侧跳次数
 * @author: lirl
 * @date: 2021/5/28
 */
public class MinSideJumps {

    public static void main(String[] args) {
        System.out.println(new MinSideJumps().minSideJumps(new int[]{0,1,2,3,0}));
        System.out.println(new MinSideJumps().minSideJumps(new int[]{0,1,1,3,3,0}));
        System.out.println(new MinSideJumps().minSideJumps(new int[]{0,2,1,0,3,0}));
    }

    /**
     * 执行耗时:64 ms,击败了48.37% 的Java用户
     * 内存消耗:106.9 MB,击败了32.09% 的Java用户
     * @param obstacles
     * @return
     */
    public int minSideJumps(int[] obstacles) {
        int[][] last = new int[][]{{1,0,1},{0,0,0}};
        int wait = -1;
        for (int i = 1; i < obstacles.length; i++) {
            for (int num = 0; num < 3; num++) {
                if (obstacles[i] - 1 == num) {
                    last[1][num] = Integer.MAX_VALUE - 1;
                } else if (last[0][num] == Integer.MAX_VALUE - 1) {
                    wait = num;
                } else {
                    last[1][num] = Math.min(last[0][num], Math.min(last[0][(num + 1) % 3], last[0][(num + 2) % 3]) + 1);
                }
            }
            last[0][0] = last[1][0];
            last[0][1] = last[1][1];
            last[0][2] = last[1][2];
            if (wait != -1) {
                last[0][wait] = Math.min(last[0][(wait + 1) % 3], last[0][(wait + 2) % 3]) + 1;
                wait = -1;
            }
        }
        return Math.min(last[0][0], Math.min(last[0][1], last[0][2]));
    }
}
