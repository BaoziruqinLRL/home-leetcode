package com.yyhome.leetcode.easy;

import java.util.Arrays;

/**
 * mst40 最小k个数
 * @author miluo
 * @date 2020-03-20
 */
public class GetLeastNumbers {

    public static void main(String[] args){
        System.out.println(Arrays.toString(getLeastNumbers(new int[]{3, 2, 1}, 2)));
        System.out.println(Arrays.toString(getLeastNumbers(new int[]{0, 1, 2, 1}, 1)));
    }

    private static int[] getLeastNumbers(int[] arr, int k) {
        return Arrays.copyOfRange(mergeSort(arr),0,k);
    }

    private static int[] mergeSort(int[] nums){
        if (nums.length < 2){
            return nums;
        }
        int[] left = Arrays.copyOfRange(nums,0,nums.length / 2);
        int[] right = Arrays.copyOfRange(nums,nums.length / 2,nums.length);
        return merge(mergeSort(left),mergeSort(right));
    }

    private static int[] merge(int[] left, int[] right){
        int[] res = new int[left.length + right.length];
        for (int l = 0, r = 0, reIndex = 0; l < left.length || r < right.length;){
            res[reIndex++] =
                    l == left.length ? right[r++] :
                            r == right.length ? left[l++] :
                                    left[l] < right[r] ? left[l++] : right[r++];
        }
        return res;
    }
}
