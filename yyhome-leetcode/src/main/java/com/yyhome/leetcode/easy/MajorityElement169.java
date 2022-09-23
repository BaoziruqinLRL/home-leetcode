package com.yyhome.leetcode.easy;

/**
 * 169 多数元素
 * @Author: linabell
 * @Date: 2022/9/23 14:14:32
 */
public class MajorityElement169 {

    /**
     * 执行耗时:5 ms,击败了29.34% 的Java用户
     * 内存消耗:44.9 MB,击败了67.72% 的Java用户
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        return shellSort(nums)[nums.length / 2];
    }

    private int[] shellSort(int[] nums){
        // 长度为0的数组直接返回
        if (nums.length == 0){
            return nums;
        }
        // 选择希尔增量，默认为长度/2
        int defaultGap = nums.length / 2;
        while(defaultGap > 0){
            // 从增量开始遍历，表示从分组的第二个元素开始遍历
            for (int index = defaultGap; index < nums.length;index++){
                int i = index;
                int element = nums[i];
                // 遍历该元素之前的有序序列，决定element插在哪个位置，与插入排序不同的是，序列为0 0+defaultGap 0+defaultGap+defaultGap......
                // 以defaultGap为间隔当做一个序列
                while (i >= defaultGap && nums[i - defaultGap] > nums[i]){
                    int temp = nums[i];
                    nums[i] = nums[i - defaultGap];
                    nums[i - defaultGap] = temp;
                    i-=defaultGap;
                }
                nums[i] = element;
            }
            // 缩小增量
            defaultGap = defaultGap / 2;
        }
        return nums;
    }
}
