package com.yyhome.leetcode.easy;

/**
 * 7 整数反转
 * @author miluo
 * @date 2020-05-25
 */
public class IntegerReverse {

    public static void main(String[] args){
//        System.out.println(new IntegerReverse().reverse(-122030));
//        System.out.println(new IntegerReverse().reverse(1220301));
//        System.out.println(new IntegerReverse().reverse(1000100062));
        System.out.println(new IntegerReverse().reverse(-2147483648));
    }

    public int reverse(int x) {
        boolean negative = x < 0;
        char[] intArr = String.valueOf(x).substring(negative ? 1 : 0).toCharArray();
        for (int i = 0,j = intArr.length - 1; i < j;i++,j--){
            char temp = intArr[i];
            intArr[i] = intArr[j];
            intArr[j] = temp;
        }
        long reverse = Long.valueOf(new String(intArr)) * (negative ? -1 : 1);
        if ((negative && reverse < Integer.MIN_VALUE) ||
                (!negative && reverse > Integer.MAX_VALUE)){
            return 0;
        }
        return (int) reverse * (negative ? -1 : 1);
    }
}