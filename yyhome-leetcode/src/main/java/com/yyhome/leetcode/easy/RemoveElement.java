package com.yyhome.leetcode.easy;

/**
 * 27 移除元素
 * @author miluo
 * @date 2020-07-08
 */
public class RemoveElement {

    public static void main(String[] args){
        System.out.println(new RemoveElement().removeElement(new int[]{3,2,2,3},3));
        System.out.println(new RemoveElement().removeElement(new int[]{0,1,2,2,3,0,4,2},2));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.4 MB,击败了5.68% 的Java用户
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        int newPoint = 0;
        int index = 0;
        while (index < nums.length){
            while (index < nums.length && nums[index] != val){
                newPoint++;
                index++;
            }
            if (index < nums.length){
                while (++index < nums.length && nums[index] == val){
                    continue;
                }
                if (index < nums.length){
                    int temp = nums[newPoint];
                    nums[newPoint] = nums[index];
                    nums[index] = temp;
                    newPoint++;
                    index = newPoint;
                }
            }
        }
        return newPoint;
    }
}
