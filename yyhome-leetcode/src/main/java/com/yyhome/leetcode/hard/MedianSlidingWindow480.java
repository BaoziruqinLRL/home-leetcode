package com.yyhome.leetcode.hard;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 480 滑动窗口中位数
 * @Author: lrl
 * @Date: 2023/12/15 16:14:21
 */
public class MedianSlidingWindow480 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MedianSlidingWindow480().medianSlidingWindow(new int[]{1, 1, 1, 1}, 2)));
        System.out.println(Arrays.toString(new MedianSlidingWindow480().medianSlidingWindow(new int[]{2147483647,1,2,3,4,5,6,7,2147483647}, 2)));
        System.out.println(Arrays.toString(new MedianSlidingWindow480().medianSlidingWindow(new int[]{2147483647,2147483647}, 2)));
        System.out.println(Arrays.toString(new MedianSlidingWindow480().medianSlidingWindow(new int[]{1,2}, 1)));
        System.out.println(Arrays.toString(new MedianSlidingWindow480().medianSlidingWindow(new int[]{1,4,2,3}, 4)));
        System.out.println(Arrays.toString(new MedianSlidingWindow480().medianSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }

    int leftSize = 0, rightSize = 0;

    /**
     * 双堆惰性删除
     * 执行耗时:46 ms,击败了52.86% 的Java用户
     * 内存消耗:54.8 MB,击败了27.61% 的Java用户
     * @param nums
     * @param k
     * @return
     */
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        if (k == 1) {
            int i = 0;
            for (int n : nums) {
                res[i++] = n;
            }
            return res;
        }
        // 左队列是递增队列  右队列是递减队列
        PriorityQueue<double[]> leftQueue = new PriorityQueue<>((newArray, oldArray) -> {
            if (newArray[0] > oldArray[0]) {
                return -1;
            } else if (newArray[0] < oldArray[0]) {
                return 1;
            } else {
                return newArray[1] > oldArray[1] ? -1 : 1;
            }
        });
        PriorityQueue<double[]> rightQueue = new PriorityQueue<>((newArray, oldArray) -> {
            if (newArray[0] < oldArray[0]) {
                return -1;
            } else if (newArray[0] > oldArray[0]) {
                return 1;
            } else {
                return newArray[1] < oldArray[1] ? -1 : 1;
            }
        });
        int index = 0;
        while (index < k) {
            leftQueue.add(new double[]{nums[index], index++});
        }
        // 若k为偶数，l r 数量相等; 若k为奇数， l = r + 1
        for (int i = 0; i < k / 2; i++) {
            rightQueue.add(leftQueue.poll());
        }
        leftSize = leftQueue.size();
        rightSize = rightQueue.size();
        int leftValid = 0;
        res[0] = getMiddle(leftQueue, rightQueue, leftValid++, k);
        for (int i = 1; i < res.length; i++, leftValid++) {
            intoQueue(leftQueue, rightQueue, nums, leftValid, k);
            res[i] = getMiddle(leftQueue, rightQueue, leftValid, k);
        }
        return res;
    }

    private double getMiddle(PriorityQueue<double[]> lq, PriorityQueue<double[]> rq, int leftValid, int k) {
        if (leftSize == rightSize) {
            // 偶数
            double[] leftPeek, rightPeek;
            while ((leftPeek = lq.peek())[1] < leftValid) {
                lq.poll();
            }
            while ((rightPeek = rq.peek())[1] < leftValid) {
                rq.poll();
            }
            return (leftPeek[0] + rightPeek[0]) / 2;
        } else {
            double[] leftPeek;
            while ((leftPeek = lq.peek())[1] < leftValid) {
                lq.poll();
            }
            return leftPeek[0];
        }
    }

    private void intoQueue(PriorityQueue<double[]> lq, PriorityQueue<double[]> rq, int[] nums, int leftValid, int k) {
        int index = leftValid + k - 1;
        double[] intoNum = new double[]{nums[index], index};
        double removeNum = nums[leftValid - 1];
        if (removeNum <= lq.peek()[0]) {
            leftSize--;
        } else {
            rightSize--;
        }
        if (intoNum[0] >= rq.peek()[0]) {
            rq.add(intoNum);
            rightSize++;
        } else {
            lq.add(intoNum);
            leftSize++;
        }
        while (leftSize < rightSize) {
            lq.add(pollValid(rq, leftValid));
            leftSize++;
            rightSize--;
        }
        while (rightSize + 1 < leftSize) {
            rq.add(pollValid(lq, leftValid));
            leftSize--;
            rightSize++;
        }
    }

    private double[] pollValid(PriorityQueue<double[]> queue, int leftValid) {
        double[] poll;
        while ((poll = queue.poll())[1] < leftValid) {

        }
        return poll;
    }
}
