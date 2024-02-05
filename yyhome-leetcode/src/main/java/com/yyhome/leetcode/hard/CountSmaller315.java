package com.yyhome.leetcode.hard;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 计算右侧小于当前元素的个数 315
 * @Author: lrl
 * @Date: 2024/2/4 14:18:56
 */
public class CountSmaller315 {

    public static void main(String[] args) {
        System.out.println(new CountSmaller315().countSmaller(new int[]{4,3,2,1,2,3,4}));
        // 10,27,10,35,12,22,28,8,19,2,12,2,9,6,12,5,17,9,19,12,14,6,12,5,12,3,0,10,0,7,8,4,0,0,4,3,2,0,1,0
        System.out.println(new CountSmaller315().countSmaller(new int[]{26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41}));
        System.out.println(new CountSmaller315().countSmaller(new int[]{2,0,1}));
        System.out.println(new CountSmaller315().countSmaller(new int[]{5,2,6,1}));
        System.out.println(new CountSmaller315().countSmaller(new int[]{-1}));
        System.out.println(new CountSmaller315().countSmaller(new int[]{-1, -1}));
    }

    private int[] result;
    private int[] location;

    /**
     * 归并排序过程中计算
     * 每合并一个，则计算左数组和右数组的大小关系，
     * 若left[m] < right[n], 则找到right中第一个大于left[m]的数索引x，在x之前的所有数一定小于left[m]
     * 否则继续往后排序，直到有left[m] < right[n]
     * 执行耗时:92 ms,击败了28.62% 的Java用户
     * 内存消耗:56 MB,击败了91.64% 的Java用户
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
        result = new int[nums.length];
        location = new int[nums.length];
        IntStream.range(0, nums.length).forEach(i -> location[i] = -1);
        mergeSort(nums, 0);
        return Arrays.stream(result).boxed().collect(Collectors.toList());
    }

    private int[] mergeSort(int[] nums, int start) {
        if (nums.length < 2){
            return nums;
        }
        int mid = nums.length / 2;
        int[] left = Arrays.copyOfRange(nums,0,mid);
        int[] right = Arrays.copyOfRange(nums,mid,nums.length);
        return merge(mergeSort(left, start),mergeSort(right, start + mid), start, start + mid);
    }

    private int[] merge(int[] left, int[] right, int start, int mid){
        int[] res = new int[left.length + right.length];
        int lastIndex = -1;
        // 记录此次合并过程中左右数组被移动到的新位置
        int[] tempLocation = new int[left.length + right.length];
        for (int l = 0, r = 0, reIndex = 0; l < left.length || r < right.length; reIndex++){
            // 在原位置记录数组中的索引，location[realIndex]为此次合并前该元素在原始数组中的真实位置（若为-1表示从未记录过，那么realIndex就是真实位置，原因是数组合并是基于原始数组的位置分割的，
            // 每个元素进行第一次排序合并时它的start和mid计算出的元素位置就是原始数组的真实位置(因为归并排序一定会把数组分割到最小进行合并，也就是size=1时元素进行第一次排序合并)，那么得到的realIndex
            // 一定是真实位置，只有经过一次合并排序之后，同样的元素使用start和mid计算出来的位置才会变成相对位置，此相对位置是指此元素在排序后的数组中的位置而不是它在原始数组中的位置，所以后续需要location
            // 数组来记录相对位置所指向的真实位置）
            int realIndex;
            if (l == left.length) {
                realIndex = mid + r;
                res[reIndex] = right[r++];
            } else if (r == right.length) {
                realIndex = start + l;
                result[location[realIndex] == -1 ? realIndex : location[realIndex]] += right.length;
                res[reIndex] = left[l++];
            } else if (left[l] <= right[r]) {
                realIndex = start + l;
                if (lastIndex == l) {
                    // 说明上次比较left > right，那么此次left <= right时，说明right中从0到r-1都小于left，此时可以快速得到left的一个结果数为r
                    result[location[realIndex] == -1 ? realIndex : location[realIndex]] += r;
                } else {
                    // 上次是left <= right，则此时可能换了个left仍然 <= right，则需要找到right中第一个大于left的数索引tempR, 在tempR之前的所有数都小于left，于是得到一个结果数
                    int tempR = r;
                    while (tempR >= 0 && left[l] <= right[tempR]) {
                        tempR--;
                    }
                    if (tempR >= 0) {
                        result[location[realIndex] == -1 ? realIndex : location[realIndex]] += tempR + 1;
                    }
                }
                lastIndex = l;
                res[reIndex] = left[l++];
            } else {
                realIndex = mid + r;
                lastIndex = l;
                res[reIndex] = right[r++];
            }
            tempLocation[reIndex] = location[realIndex] == -1 ? realIndex : location[realIndex];
        }
        // 把新的位置置入全局的位置记录数组中
        for (int i = 0; i < left.length + right.length; i++) {
            location[i + start] = tempLocation[i];
        }
        return res;
    }
}
