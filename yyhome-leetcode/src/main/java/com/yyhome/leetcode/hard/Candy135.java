package com.yyhome.leetcode.hard;

/**
 * 135 分发糖果
 * @Author: linabell
 * @Date: 2023/2/22 16:38:06
 */
public class Candy135 {

    public static void main(String[] args) {
        System.out.println(new Candy135().candy(new int[]{1,2,3,5,4,3,2,1,4,3,2,1,3,2,1,1,2,3,4}));
        System.out.println(new Candy135().candy(new int[]{1,0,2}));
        System.out.println(new Candy135().candy(new int[]{1,2,3,5,4,3,2,1,4,3,2,1}));
        System.out.println(new Candy135().candy(new int[]{1,2,3,5,4,3,2,1}));
        System.out.println(new Candy135().candy(new int[]{1,3,2,2,1}));
        System.out.println(new Candy135().candy(new int[]{1,2,3,1,0}));
        System.out.println(new Candy135().candy(new int[]{5,4,3,2,1}));
        System.out.println(new Candy135().candy(new int[]{1,2,3,4,5}));
        System.out.println(new Candy135().candy(new int[]{1,2,2}));
    }

    /**
     * 执行耗时:2 ms,击败了98.62% 的Java用户
     * 内存消耗:42 MB,击败了55.67% 的Java用户
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        int total = 1, current = 1, lastUpIndex = -1, lastCandy = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] >= ratings[i-1]) {
                if (lastUpIndex != i - 1) {
                    // 开始新的递增
                    for (int j = lastUpIndex + 1, count = 1; j < i - 1; j++, count++) {
                        total += count;
                    }
                    if (lastUpIndex >= 0 && ratings[lastUpIndex] > ratings[lastUpIndex + 1] && lastCandy <= i - lastUpIndex - 1) {
                        total += i - lastUpIndex - lastCandy;
                    }
                }
            }
            if (ratings[i] == ratings[i-1]) {
                total++;
                current = 1;
                lastUpIndex = i-1;
            } else if (ratings[i] > ratings[i-1]) {
                total += (++current);
                lastUpIndex = i;
                lastCandy = current;
            } else {
                total++;
                current = 1;
            }
        }
        if (lastUpIndex != ratings.length - 1) {
            int i = ratings.length - 1;
            for (int j = lastUpIndex + 1, count = 1; j < i; j++, count++) {
                total += count;
            }
            if (lastUpIndex >= 0 && ratings[lastUpIndex] > ratings[lastUpIndex + 1] && lastCandy <= i - lastUpIndex) {
                total += i - lastUpIndex - lastCandy + 1;
            }
        }
        return total;
    }

}
