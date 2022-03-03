package com.yyhome.leetcode.middle;

/**
 * 面试题64. 求1+2+…+n
 * @author miluo
 * @date 2020-03-25
 */
public class SumNums {

    public static void main(String[] args){
        System.out.println(sumNums(3));
        System.out.println(sumNums(5));
    }

    private static int sumNums(int n) {
        int res = n;
        boolean f = (n > 0) && ((res += sumNums(n - 1)) > 0);
        return res;
    }
}
