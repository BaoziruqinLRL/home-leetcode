package com.yyhome.leetcode.easy;

/**
 * 231 2的幂
 * @author: lirl
 * @date: 2021/3/11
 */
public class IsPowerOfTwo {

    public static void main(String[] args) {
        System.out.println(new IsPowerOfTwo().isPowerOfTwo(-2147483646));
        System.out.println(new IsPowerOfTwo().isPowerOfTwo(3));
        System.out.println(new IsPowerOfTwo().isPowerOfTwo(1));
        System.out.println(new IsPowerOfTwo().isPowerOfTwo(16));
        System.out.println(new IsPowerOfTwo().isPowerOfTwo(218));

        System.out.println(new IsPowerOfTwo().isPowerOfTwo2(-2147483646));
        System.out.println(new IsPowerOfTwo().isPowerOfTwo2(3));
        System.out.println(new IsPowerOfTwo().isPowerOfTwo2(1));
        System.out.println(new IsPowerOfTwo().isPowerOfTwo2(16));
        System.out.println(new IsPowerOfTwo().isPowerOfTwo2(218));
    }

    /**
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:35.4 MB,击败了70.32% 的Java用户
     * @param n
     * @return
     */
    public boolean isPowerOfTwo(int n) {
        if (n <= 0){
            return false;
        }
        int binaryNum = 0;
        for (int i = 0; i < 31; i++){
            if ((n & 1) == 1){
                if (binaryNum >= 1) {
                    return false;
                }else{
                    binaryNum++;
                }
            }
            n = n >> 1;
        }
        return true;
    }

    /**
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:35.6 MB,击败了28.41% 的Java用户
     * @param n
     * @return
     */
    public boolean isPowerOfTwo2(int n){
        return n > 0 && (n & (n -1)) == 0;
    }
}
