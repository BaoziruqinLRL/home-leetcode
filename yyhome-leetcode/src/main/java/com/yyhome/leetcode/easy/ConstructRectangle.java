package com.yyhome.leetcode.easy;

import java.util.Arrays;

/**
 * 492 构造矩形
 * @author: lirl
 * @date: 2021/3/25
 */
public class ConstructRectangle {

    public static void main(String[] args){
        System.out.println(Arrays.toString(new ConstructRectangle().constructRectangle(4)));
        System.out.println(Arrays.toString(new ConstructRectangle().constructRectangle(9)));
        System.out.println(Arrays.toString(new ConstructRectangle().constructRectangle(10)));
        System.out.println(Arrays.toString(new ConstructRectangle().constructRectangle(15)));
        System.out.println(Arrays.toString(new ConstructRectangle().constructRectangle(16)));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:35.8 MB,击败了72.67% 的Java用户
     * @param area
     * @return
     */
    public int[] constructRectangle(int area) {
        int llong = (int) Math.sqrt(area);
        while (llong > 0){
            if (area % llong == 0){
                break;
            }
            llong--;
        }
        return new int[]{area / llong, llong};
    }
}
