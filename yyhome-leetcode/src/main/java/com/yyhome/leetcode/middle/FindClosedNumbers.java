package com.yyhome.leetcode.middle;

import java.util.Arrays;

/**
 * 面试题 05.04 下一个数
 * @author: lirl
 * @date: 2021/4/14
 */
public class FindClosedNumbers {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new FindClosedNumbers().findClosedNumbers(706348592)));
        System.out.println(Arrays.toString(new FindClosedNumbers().findClosedNumbers(10000)));
        System.out.println(Arrays.toString(new FindClosedNumbers().findClosedNumbers(34)));
        System.out.println(Arrays.toString(new FindClosedNumbers().findClosedNumbers(1156403390)));
        System.out.println(Arrays.toString(new FindClosedNumbers().findClosedNumbers(987654321)));
        System.out.println(Arrays.toString(new FindClosedNumbers().findClosedNumbers(124)));
        System.out.println(Arrays.toString(new FindClosedNumbers().findClosedNumbers(67)));
        System.out.println(Arrays.toString(new FindClosedNumbers().findClosedNumbers(2)));
        System.out.println(Arrays.toString(new FindClosedNumbers().findClosedNumbers(0b101100)));
        System.out.println(Arrays.toString(new FindClosedNumbers().findClosedNumbers(1)));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:36.2 MB,击败了11.30% 的Java用户
     * @param num
     * @return
     */
    public int[] findClosedNumbers(int num) {
        // 记录0之后的最低位1 和 1之后的最低位0
        int afterZero = 32;
        int afterOne = 32;
        int highestOne = -1;
        for (int i = 0, zero = 0, one = 0, va = 1; i < 31; i++, va <<= 1) {
            if ((num & va) == va) {
                if (zero > 0 && afterZero == 32 && va <= num) {
                    afterZero = i;
                }
                highestOne = Math.max(highestOne, i);
                one++;
            } else {
                if (one > 0 && afterOne == 32 && va <= num) {
                    afterOne = i;
                }
                zero++;
            }
        }
        int min, max;
        if (afterZero == 32) {
            min = -1;
        } else {
            min = exchange(afterZero, afterZero - 1, num);
            for (int i = 0, zeroPos = afterZero - 2; i < afterOne && zeroPos >= afterOne; i++, zeroPos--) {
                min = exchange(i, zeroPos, min);
            }
        }
        if (afterOne == 32) {
            // 高位左移一位
            if (highestOne == 30) {
                max = -1;
            } else {
                max = exchange(highestOne, highestOne + 1, num);
                for (int i = 0, onePos = highestOne - 1; i < afterZero && onePos >= afterZero; i++, onePos--) {
                    max = exchange(onePos, i, max);
                }
            }
        } else {
            max = exchange(afterOne - 1, afterOne, num);
            for (int i = 0, onePos = afterOne - 2; afterOne > afterZero + 1 && i < afterZero && onePos >= afterZero; i++, onePos--) {
                max = exchange(onePos, i, max);
            }
        }
        return new int[]{max, min};
    }

    public int exchange(int onePos, int zeroPos, int origin) {
        int lo = 1, lz = 1;
        for (int i = 0; i < onePos; i++) {
            lo <<= 1;
        }
        for (int i = 0; i < zeroPos; i++) {
            lz <<= 1;
        }
        return origin & (0x7FFFFFFF ^ lo) | lz;
    }
}
