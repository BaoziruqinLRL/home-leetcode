package com.yyhome.leetcode.easy;

import java.util.Arrays;

/**
 * 66 加一
 * @author miluo
 * @date 2020-07-09
 */
public class PlusOne {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{4, 3, 2, 1})));
        System.out.println(Arrays.toString(new PlusOne().plusOne(new int[]{9,9,9,9})));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.2 MB,击败了5.63% 的Java用户
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int move = 1;
        int index = digits.length - 1;
        while (move == 1 && index >= 0){
            if (digits[index] + 1 == 10){
                digits[index] = 0;
            }else{
                digits[index] = digits[index] + 1;
                move = 0;
            }
            index--;
        }
        if (move == 1){
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            System.arraycopy(digits,0,newDigits,1,digits.length);
            return newDigits;
        }
        return digits;
    }
}
