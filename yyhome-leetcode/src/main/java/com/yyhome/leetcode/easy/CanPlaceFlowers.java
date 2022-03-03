package com.yyhome.leetcode.easy;

/**
 * 605 种花问题
 * @author: lirl
 * @date: 2021/3/30
 */
public class CanPlaceFlowers {

    public static void main(String[] args){
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(new int[]{1,0,0,0,1}, 1));
        System.out.println(new CanPlaceFlowers().canPlaceFlowers(new int[]{1,0,0,0,1}, 2));
    }

    /**
     * 执行耗时:1 ms,击败了99.96% 的Java用户
     * 内存消耗:39.9 MB,击败了61.46% 的Java用户
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int start = 0;n > 0 && start < flowerbed.length;){
            if (flowerbed[start] == 0){
                if (start == flowerbed.length - 1 || flowerbed[start + 1] == 0){
                    flowerbed[start] = 1;
                    start += 2;
                    n--;
                } else {
                    start++;
                }
            } else {
                start+=2;
            }
        }
        return n == 0;
    }
}
