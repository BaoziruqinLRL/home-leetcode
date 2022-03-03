package com.yyhome.leetcode.easy;

/**
 * 35 搜索插入位置
 * @author miluo
 * @date 2020-07-08
 */
public class SearchInsert {

    public static void main(String[] args) {
        System.out.println(new SearchInsert().searchInsert(new int[]{1,3,5,6},5));
        System.out.println(new SearchInsert().searchInsert(new int[]{1,3,5,6},2));
        System.out.println(new SearchInsert().searchInsert(new int[]{1,3,5,6},7));
        System.out.println(new SearchInsert().searchInsert(new int[]{1,3,5,6},0));
        System.out.println(new SearchInsert().searchInsert(new int[]{1},0));
        System.out.println(new SearchInsert().searchInsert(new int[]{1},1));
    }

    /**
     * 0ms
     * 39.4~39.7MB
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int head = 0;
        int tail = nums.length;
        while (head < tail){
            int middle = (head + tail) / 2;
            if (nums[middle] > target){
                tail = middle;
            }else if (nums[middle] < target){
                head = middle + 1;
            }else{
                return middle;
            }
        }
        return tail;
    }
}
