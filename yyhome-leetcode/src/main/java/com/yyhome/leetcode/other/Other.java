package com.yyhome.leetcode.other;

import java.util.Arrays;

public class Other {

    public static void main(String[] args){
        System.out.println(new Other().solution(new int[]{2,1}));
    }

    public int solution(int [] A){
        Arrays.sort(A);
        int left = 0;
        int right = A.length - 1;
        if (A[right] == right + 1){
            return A[right] + 1;
        }
        while (left < right){
            if (A[right] == right + 1){
                // 左边数量是对的
                left = right + 1;
            }else{
                right = (left + right) / 2;
            }
        }
        return 0;
    }

}
