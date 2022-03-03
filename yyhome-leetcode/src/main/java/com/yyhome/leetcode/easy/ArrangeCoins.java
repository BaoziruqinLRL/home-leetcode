package com.yyhome.leetcode.easy;

/**
 * 441 排列硬币
 * @author: lirl
 * @date: 2021/3/24
 */
public class ArrangeCoins {

    public static void main(String[] args){
        System.out.println(new ArrangeCoins().arrangeCoins(1804289383));
        System.out.println(new ArrangeCoins().arrangeCoins(8));
        System.out.println(new ArrangeCoins().arrangeCoins(5));
    }

    /**
     * 执行耗时:2 ms,击败了84.35% 的Java用户
     * 内存消耗:35.5 MB,击败了75.64% 的Java用户
     * @param n
     * @return
     */
    public int arrangeCoins(int n) {
        long start = 0;
        long end = n;
        long middle;
        while (start <= end){
            middle = (start + end) / 2;
            long res;
            if (middle % 2 == 0){
                res = (middle + 1) * (middle / 2);
            }else {
                res = middle * ((middle - 1) / 2) + middle;
            }
            if (res == n){
                return (int) middle;
            }
            if (res > n || res < 0){
                end = middle - 1;
            }else{
                start = middle + 1;
            }
        }
        return (int) end;
    }
}
