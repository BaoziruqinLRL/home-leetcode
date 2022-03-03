package com.yyhome.leetcode.easy;

import java.util.stream.IntStream;

/**
 * 1013 数组三等分
 * @author miluo
 * @date 2020-03-11
 */
public class CanThreePartsEqualSum {

    public static void main(String[] args){
        System.out.println(canThreePartsEqualSum(new int[]{0,2,1,-6,6,-7,9,1,2,0,1}));
        System.out.println(canThreePartsEqualSum(new int[]{0,2,1,-6,6,7,9,-1,2,0,1}));
        System.out.println(canThreePartsEqualSum(new int[]{3,3,6,5,-2,2,5,1,-9,4}));
        System.out.println(canThreePartsEqualSum(new int[]{18,12,-18,18,-19,-1,10,10}));
    }

    private static boolean canThreePartsEqualSum(int[] A) {
        int total = IntStream.of(A).sum();
        if (total % 3 != 0){
            return false;
        }
        int everyPart = total / 3;
        int left = A[0];
        int right = A[A.length - 1];
        for (int i = 0,j=A.length - 1; i + 1 < j;){
            if (left == everyPart && right == everyPart){
                return true;
            }
            if (left != everyPart){
                i++;
                left += A[i];
            }
            if (right != everyPart){
                j--;
                right += A[j];
            }
        }
        return false;
    }
}
