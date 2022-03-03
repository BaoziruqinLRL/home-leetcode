package com.yyhome.leetcode.middle;

/**
 * 376 摆动序列
 * @author: lirl
 * @date: 2021/6/4
 */
public class WiggleMaxLength {

    public static void main(String[] args){
        System.out.println(new WiggleMaxLength().wiggleMaxLength(new int[]{1,7,4,9,2,5}));
        System.out.println(new WiggleMaxLength().wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}));
        System.out.println(new WiggleMaxLength().wiggleMaxLength(new int[]{1,2,3,4,5,6,7,8,9}));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:36.2 MB,击败了16.56% 的Java用户
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int asc = 1, desc = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] > nums[i-1]){
                asc=desc+1;
            }else if (nums[i] < nums[i-1]){
                desc=asc+1;
            }
        }
        return Math.max(desc,asc);
    }
}
