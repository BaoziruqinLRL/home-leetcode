package com.yyhome.leetcode.easy;

/**
 * 204 计算质数
 * @author: lirl
 * @date: 2021/3/11
 */
public class CountPrimes {

    public static void main(String[] args){
        System.out.println(new CountPrimes().countPrimes(10));
        System.out.println(new CountPrimes().countPrimes(0));
        System.out.println(new CountPrimes().countPrimes(2));
        System.out.println(new CountPrimes().countPrimes(100));

        System.out.println(new CountPrimes().countPrimes2(10));
        System.out.println(new CountPrimes().countPrimes2(0));
        System.out.println(new CountPrimes().countPrimes2(2));
        System.out.println(new CountPrimes().countPrimes2(100));
    }

    /**
     * 执行耗时:734 ms,击败了5.28% 的Java用户
     * 内存消耗:35 MB,击败了97.83% 的Java用户
     * 穷举法
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        if (n <= 2){
            return 0;
        }
        // 2一定是质数
        int count = 1;
        for (int i = 3; i < n; i++){
            int j = 2;
            for (; j * j <= i; j++){
                if (i % j == 0){
                    break;
                }
            }
            if (j * j > i){
                count++;
            }
        }
        return count;
    }

    /**
     * 执行耗时:75 ms,击败了28.69% 的Java用户
     * 内存消耗:35.5 MB,击败了75.21% 的Java用户
     * 埃氏筛
     * @param n
     * @return
     */
    public int countPrimes2(int n){
        if (n <= 2){
            return 0;
        }
        int[] hash = new int[n / 32 + 1];
        int count = 0;
        for (int i = 2; i < n; i++){
            int index = i / 32;
            int position = i % 32;
            if (((hash[index] >> position) & 1) == 0){
                for (int j = 2; i * j < n; j++){
                    int jIndex = (i * j) / 32;
                    int jPos = (i * j) % 32;
                    hash[jIndex] = hash[jIndex] | (1 << jPos);
                }
                count++;
            }
        }
        return count;
    }
}
