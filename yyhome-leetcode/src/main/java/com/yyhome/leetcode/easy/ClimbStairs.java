package com.yyhome.leetcode.easy;

/**
 * 70 爬楼梯
 * @author miluo
 * @date 2020-07-10
 */
public class ClimbStairs {

    public static void main(String[] args) {
        System.out.println(new ClimbStairs().climbStairs(1));
        System.out.println(new ClimbStairs().climbStairs(2));
        System.out.println(new ClimbStairs().climbStairs(3));
        System.out.println(new ClimbStairs().climbStairs(4));
        System.out.println(new ClimbStairs().climbStairs(5));
        System.out.println(new ClimbStairs().climbStairs(6));
        System.out.println(new ClimbStairs().climbStairs(43));


        System.out.println(new ClimbStairs().climbStairs2(1));
        System.out.println(new ClimbStairs().climbStairs2(2));
        System.out.println(new ClimbStairs().climbStairs2(3));
        System.out.println(new ClimbStairs().climbStairs2(4));
        System.out.println(new ClimbStairs().climbStairs2(5));
        System.out.println(new ClimbStairs().climbStairs2(6));
        System.out.println(new ClimbStairs().climbStairs2(43));
    }

    /**
     * 递归超时
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 3){
            return n;
        }else{
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:36.4 MB,击败了5.66% 的Java用户
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if (n <= 3){
            return n;
        }
        int pre2 = 2;
        int pre1 = 3;
        int i = 4;
        while (i <= n){
            int temp = pre2 + pre1;
            pre2 = pre1;
            pre1 = temp;
            i++;
        }
        return pre1;
    }
}
