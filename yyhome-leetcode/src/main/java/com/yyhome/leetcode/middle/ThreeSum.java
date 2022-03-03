package com.yyhome.leetcode.middle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15 三数之和
 * @author miluo
 * @date 2020-06-28
 */
public class ThreeSum {

    public static void main(String[] args){
        System.out.println(new ThreeSum().threeSum(new int[]{-1,0,1}));
        // -4 -1 -1 0 1 2
        // -1
        //
        System.out.println(new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(new ThreeSum().threeSum(new int[]{-1, 0, 1, -1, -1, -1, 1, 0, -1, 1}));
        System.out.println(new ThreeSum().threeSum(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6}));
    }

    /**
     * 双指针
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int[] sortNums = mergeSort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int index = 0; index < sortNums.length - 2;index++){
            if (index > 0 && sortNums[index] == sortNums[index - 1]){
                continue;
            }
            if (sortNums[index] > 0){
                break;
            }
            // 左指针 和 右指针，执行index后面的开头和结尾
            int right = sortNums.length - 1;
            int left = index + 1;
            while(true){
                int sumNum = sortNums[index] + sortNums[right] + sortNums[left];
                if (sumNum == 0){
                    List<Integer> r = new ArrayList<>();
                    r.add(sortNums[index]);
                    r.add(sortNums[left]);
                    r.add(sortNums[right]);
                    result.add(r);
                    do{
                        left++;
                    }while (left < right && sortNums[left] == sortNums[left - 1]);
                    do{
                        right--;
                    }while (left < right && sortNums[right] == sortNums[right + 1]);
                }else if (sumNum < 0){
                    left++;
                }else{
                    right--;
                }
                if (left >= right){
                    break;
                }
            }
        }
        return result;
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
