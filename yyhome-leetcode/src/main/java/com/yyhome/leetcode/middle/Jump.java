package com.yyhome.leetcode.middle;

import com.alibaba.fastjson.JSON;

/**
 * 45 跳跃游戏Ⅱ
 * @author: lirl
 * @date: 2021/4/12
 */
public class Jump {

    public static void main(String[] args){
        System.out.println(new Jump().jump(new int[]{2,3,1}));
        System.out.println(new Jump().jump(new int[]{2,3,1,1,4}));
        System.out.println(new Jump().jump(new int[]{2,2,2,4,1,1,1,1,1}));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:36.1 MB,击败了55.18% 的Java用户
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int index = 0;
        int step = 0;
        while (index < nums.length - 1) {
            if (index + nums[index] >= nums.length - 1){
                step++;
                break;
            }
            int largestStep = 1;
            for (int i = index + 1; i < nums.length && i <= index + nums[index]; i++){
                largestStep = (largestStep + nums[index + largestStep]) > (i - index + nums[i]) ? largestStep : i - index;
            }
            step++;
            index += largestStep;
        }
        return step;
    }
}
