package com.yyhome.leetcode.easy;

/**
 * 367 有效的完全平方数
 * @author: lirl
 * @date: 2021/3/23
 */
public class IsPerfectSquare {

    public static void main(String[] args){
        System.out.println(new IsPerfectSquare().isPerfectSquare(35));
        System.out.println(new IsPerfectSquare().isPerfectSquare(25));
        System.out.println(new IsPerfectSquare().isPerfectSquare(16));
        System.out.println(new IsPerfectSquare().isPerfectSquare(14));
        System.out.println(new IsPerfectSquare().isPerfectSquare(8));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:35.2 MB,击败了63.51% 的Java用户
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        long start = 0;
        long end = num / 2 + 1;
        long middle = (start + end) / 2;
        while (start <= end){
            long res = middle * middle;
            if (res == num){
                return true;
            } else if (res < num){
                start = middle + 1;
                middle = (start + end) / 2;
            } else {
                end = middle - 1;
                middle = (start + end) / 2;
            }
        }
        return false;
    }
}
