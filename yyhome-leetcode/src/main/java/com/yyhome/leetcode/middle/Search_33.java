package com.yyhome.leetcode.middle;

/**
 * [33]搜索旋转排序数组
 * @Author: linabell
 * @Date: 2022/7/15 15:05:48
 */
public class Search_33 {

    public static void main(String[] args) {
        System.out.println(new Search_33().search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(new Search_33().search(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println(new Search_33().search(new int[]{1}, 0));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:41.1 MB,击败了44.67% 的Java用户
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        boolean inLeft;
        if (nums[0] <= target) {
            inLeft = true;
        } else if (nums[nums.length - 1] >= target) {
            inLeft = false;
        } else {
            return -1;
        }
        int middle = nums.length / 2, start = 0, end = nums.length - 1;
        while (start <= end) {
            if (nums[start] < nums[end]) {
                return normalSecond(nums, start, end, target);
            }
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                // middle大于target时, 分两种情况,
                // 1. target落在左段时, middle一定也落在左段, 此时start 和 middle一定能构成一段递增序列, 直接取start和middle-1进行正常二分
                // 2. target落在右段时, 无法得到递增序列, 且middle分两种情况.
                //    middle落在左段, 则取middle+1和end继续循环, 因为左段所有值都大于右段所有值.
                //    middle落在右段, 则取start和middle-1继续循环, 此时因为start可能在左段或右段, 因此仍无法找到递增序列
                if (inLeft) {
                    end = middle - 1;
                } else {
                    if (nums[middle] < nums[0]) {
                        end = middle - 1;
                    } else {
                        start = middle + 1;
                    }
                }
            } else {
                // middle小于target时, 分两种情况,
                // 1. target落在右段时, middle一定落在右段, 此时middle + 1和end一定构成一段递增序列
                // 2. target落在左段时, 无法得到递增序列, 且middle分两种情况.
                //    middle在左段, 则取middle+1和end继续循环
                //    middle在右段, 则取start和middle-1继续循环
                if (inLeft) {
                    if (nums[middle] < nums[0]) {
                        end = middle - 1;
                    } else {
                        start = middle + 1;
                    }
                } else {
                    start = middle + 1;
                }
            }
            middle = (start + end) / 2;
        }
        return -1;
    }

    public int normalSecond(int[] nums, int start, int end, int target) {
        int middle = (start + end) / 2;
        while (start <= end) {
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
            middle = (start + end) / 2;
        }
        return -1;
    }
}
