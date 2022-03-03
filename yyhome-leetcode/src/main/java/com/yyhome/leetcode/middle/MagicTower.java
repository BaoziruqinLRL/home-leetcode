package com.yyhome.leetcode.middle;

import java.util.PriorityQueue;

/**
 * LCP 30 魔塔游戏
 * @author: lirl
 * @date: 2021/6/25
 */
public class MagicTower {

    public static void main(String[] args){
        System.out.println(new MagicTower().magicTower(new int[]{100,100,100,-60,-140,-250,-80,-80,-80,400,300}));
        System.out.println(new MagicTower().magicTower(new int[]{-200,-300,400,0}));
    }

    /**
     * 执行耗时:19 ms,击败了34.77% 的Java用户
     * 内存消耗:55.2 MB,击败了18.31% 的Java用户
     * @param nums
     * @return
     */
    public int magicTower(int[] nums) {
        long curBlood = 1;
        long moveEnd = 0;
        int count = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Integer::compareTo);
        for (int n : nums) {
            if (n < 0) {
                queue.add(n);
            }
            if (curBlood + n <= 0) {
                moveEnd += queue.peek();
                curBlood -= queue.poll();
                curBlood += n;
                count++;
            } else {
                curBlood += n;
            }
        }
        return (curBlood + moveEnd) <= 0 ? -1 : count;
    }
}
