package com.yyhome.leetcode.easy;

/**
 * 69 x的平方根
 * @author miluo
 * @date 2020-07-10
 */
public class MySqrt {

    public static void main(String[] args) {
        System.out.println(new MySqrt().mySqrt(3));
        System.out.println(new MySqrt().mySqrt(4));
        System.out.println(new MySqrt().mySqrt(8));
        System.out.println(new MySqrt().mySqrt(9));
        System.out.println(new MySqrt().mySqrt(10));
        System.out.println(new MySqrt().mySqrt(0));
        System.out.println(new MySqrt().mySqrt(1));
    }

    /**
     * 执行耗时:2 ms,击败了57.99% 的Java用户
     * 内存消耗:37.3 MB,击败了5.55% 的Java用户
     * 真辣鸡。。。
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int head = 0;
        int tail = (x / 2) + (x % 2);
        while (head < tail){
            int middle = ((head + tail) / 2) + ((head + tail) % 2);
            if (x >= middle * middle){
                head = middle;
            }else{
                tail = middle - 1;
            }
        }
        return tail;
    }
}
