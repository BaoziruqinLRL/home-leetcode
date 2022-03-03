package com.yyhome.leetcode.middle;

import java.util.Arrays;

/**
 * 16 最接近的三数之和
 * @author miluo
 * @date 2020-06-29
 */
public class ThreeSumCloset {

    public static void main(String[] args){

        System.out.println(new ThreeSumCloset().threeSumClosest(new int[]{0,1,2},3));
//        System.out.println(new ThreeSumCloset().threeSumClosest(new int[]{1,1,1,0},100));
//        System.out.println(new ThreeSumCloset().threeSumClosest(new int[]{1,1,-1,-1,3},-1));
//        System.out.println(new ThreeSumCloset().threeSumClosest(new int[]{-3,-2,-5,3,-4},-1));
//        System.out.println(new ThreeSumCloset().threeSumClosest(new int[]{-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6},2));
    }

    /**
     * 双指针
     * @param nums
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        for (int index = 0; index < nums.length - 2;index++){
            if (index > 0 && nums[index] == nums[index - 1]){
                continue;
            }
            // 左指针 和 右指针，执行index后面的开头和结尾
            int right = nums.length - 1;
            int left = index + 1;
            while(true){
                int sumNum = nums[index] + nums[right] + nums[left];
                if (Math.abs(sumNum - target) < Math.abs(res - target)) {
                    res = sumNum;
                }
                if (sumNum == target){
                    return sumNum;
                }else if (sumNum < target){
                    left++;
                }else{
                    right--;
                }
                if (left >= right){
                    break;
                }
            }
        }
        return res;
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
