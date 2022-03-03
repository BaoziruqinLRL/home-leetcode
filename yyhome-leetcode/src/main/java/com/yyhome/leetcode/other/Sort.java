package com.yyhome.leetcode.other;

import java.text.MessageFormat;
import java.util.Arrays;

/**
 * @author miluo
 * @date 2020-03-13
 */
public class Sort {

    public static void main(String[] args){
//        int[] readyArr = new int[]{19,2,67,-8,37,82,-90,100,7};
//        System.out.println("冒泡排序结果：" + Arrays.toString(bubblingSort(Arrays.copyOf(readyArr,readyArr.length))));
//        System.out.println("选择排序结果：" + Arrays.toString(selectSort(Arrays.copyOf(readyArr,readyArr.length))));
//        System.out.println("插入排序结果：" + Arrays.toString(insertSort(Arrays.copyOf(readyArr,readyArr.length))));
//        System.out.println("希尔排序结果：" + Arrays.toString(shellSort(Arrays.copyOf(readyArr,readyArr.length))));
//        System.out.println("归并排序结果：" + Arrays.toString(mergeSort(Arrays.copyOf(readyArr,readyArr.length))));
//        System.out.println("快速排序结果：" + Arrays.toString(quickSort(Arrays.copyOf(readyArr,readyArr.length))));
        yy();
    }

    /**
     * 冒泡排序
     * 时间 O(n²)
     * 无需额外空间
     * @param nums
     * @return
     */
    private static int[] bubblingSort(int[] nums){
        // 只需比较length - 1轮
        for (int round = 0; round < nums.length - 1;round++) {
            int index = 0;
            // 每轮里前一个跟后一个比较，以ASC顺序交换大小
            for (; index < nums.length - 1; index++) {
                if (nums[index] > nums[index + 1]) {
                    int temp = nums[index];
                    nums[index] = nums[index + 1];
                    nums[index + 1] = temp;
                }
            }
        }
        return nums;
    }

    /**
     * 选择排序
     * 时间 O(n²)
     * 无需额外空间
     * @param nums
     * @return
     */
    private static int[] selectSort(int[] nums){
        // 只需比较length - 1轮
        for (int round = 0; round < nums.length - 1;round++){
            int min = nums[round];
            int minIndex = round;
            // 找出每轮最小的值，放到round位，之后round++，再开始下一轮
            for (int i = round + 1; i < nums.length; i++){
                if (nums[i] < min){
                    min = nums[i];
                    minIndex = i;
                }
            }
            nums[minIndex] = nums[round];
            nums[round] = min;
        }
        return nums;
    }

    /**
     * 插入排序
     * 时间 O(n²)~O(n)
     * 空间 O(1)
     * @param nums
     * @return
     */
    private static int[] insertSort(int[] nums){
        // 长度为0的数组直接返回
        if (nums.length == 0){
            return nums;
        }
        // 遍历每个元素
        for (int index = 0; index < nums.length - 1; index++){
            int i = index + 1;
            int element = nums[i];
            // 遍历该元素之前的有序序列，决定element插在哪个位置
            while (i > 0 && nums[i - 1] > nums[i]){
                int temp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = temp;
                i--;
            }
            nums[i] = element;
        }
        return nums;
    }

    /**
     * 希尔排序
     * 时间 O(nlog2n)
     * 无需额外空间
     * @param nums
     * @return
     */
    private static int[] shellSort(int[] nums){
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

    /**
     * 归并排序
     * 时间 O(n) ~ O(nlogn)
     * 空间 O(n)
     * @param nums
     * @return
     */
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

    /**
     * 快速排序
     * 时间 O(nlogn) ~ O(n²)
     * 无需额外空间
     * @param nums
     * @return
     */
    private static int[] quickSort(int[] nums){
        if (nums.length < 2){
            return nums;
        }
        return startQuickSort(nums,0,nums.length);
    }

    private static int[] startQuickSort(int[] nums, int start, int end){
        if (start == end){
            return nums;
        }
        int middleIndex = partition(nums,start,end);
        startQuickSort(nums, start, middleIndex);
        startQuickSort(nums, middleIndex + 1, end);
        return nums;
    }

    /**
     * 排序数组，基准=nums[start]，数组小于基准置于左，大于基准置于右
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private static int partition(int[] nums, int start, int end){
        int pivot = nums[start];
        int pivotIndex = start;
        // 从右开始往回遍历
        boolean toLow = false;
        for (int low = start, high = end - 1; low < high;){
            if (toLow){
                // 左边若大于基准，则将其置为基准位，原基准位赋予左边的值
                if (nums[low] > pivot){
                    nums[pivotIndex] = nums[low];
                    pivotIndex = low;
                    high--;
                    toLow = false;
                }else{
                    low++;
                }
            }else{
                if (nums[high] < pivot) {
                    nums[pivotIndex] = nums[high];
                    pivotIndex = high;
                    low++;
                    toLow = true;
                }else {
                    high--;
                }
            }
        }
        nums[pivotIndex] = pivot;
        return pivotIndex;
    }

    private static void yy(){
        String json = "{\n" +
                "  \"countable\": true,\n" +
                "  \"name\": \"\",\n" +
                "  \"pageIndex\": 0,\n" +
                "  \"pageSize\": 10,\n" +
                "  \"standardCity\": \"\",\n" +
                "  \"standardProvince\": \"\"\n" +
                "}";

    }
}
