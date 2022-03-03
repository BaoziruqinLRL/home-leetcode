package com.yyhome.leetcode.other;

import java.util.Arrays;

/**
 * 求数列的最大偶数和
 */
public class EvenSum {

    public static void main(String[] args){
        // 2 4 6 8 9
        System.out.println(new EvenSum().evenSum(new int[]{4,9,8,2,6},3));
        System.out.println(new EvenSum().evenSum(new int[]{7,7,7,7,7},1));
        System.out.println(new EvenSum().evenSum(new int[]{5,6,3,4,2},5));
        System.out.println(new EvenSum().evenSum(new int[]{2,3,3,5,5},3));
    }

    private int evenSum(int[] array, int k){
        if (array.length < k){
            return -1;
        }
        Arrays.sort(array);
        return subEvenSum(array, k, true);
    }

    private int subEvenSum(int[] array, int k, boolean even){
        if (array.length < k){
            return -1;
        }
        if (k == 1){
            // k == 1时，最大和就是最大的奇数或偶数
            for (int i = array.length - 1; i >= 0; i--){
                if (even && array[i] % 2 == 0){
                    return array[i];
                }else if (!even && array[i] % 2 == 1){
                    return array[i];
                }
            }
            return -1;
        }
        int preEvenSum = subEvenSum(Arrays.copyOf(array,array.length - 1), k - 1, (array[array.length - 1] % 2 == 0) == even);
        if (preEvenSum < 0){
            return subEvenSum(Arrays.copyOf(array,array.length - 1),k,even);
        }else{
            return array[array.length - 1] + preEvenSum;
        }
    }
}
