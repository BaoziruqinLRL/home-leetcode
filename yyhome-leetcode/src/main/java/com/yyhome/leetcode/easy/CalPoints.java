package com.yyhome.leetcode.easy;

/**
 * 682 棒球比赛
 * @author: lirl
 * @date: 2021/3/31
 */
public class CalPoints {

    public static void main(String[] args){
        System.out.println(new CalPoints().calPoints(new String[]{"5","2","C","D","+"}));
        System.out.println(new CalPoints().calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
    }

    /**
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:36.4 MB,击败了96.03% 的Java用户
     * @param ops
     * @return
     */
    public int calPoints(String[] ops) {
        int[] nums = new int[ops.length];
        int total = 0;
        int index = -1;
        for (String s : ops){
            if (s.equals("C")){
                total -= nums[index];
                index--;
            } else if (s.equals("D")){
                nums[index + 1] = 2 * nums[index];
                total += nums[index + 1];
                index++;
            } else if (s.equals("+")){
                nums[index + 1] = nums[index] + nums[index - 1];
                total += nums[index + 1];
                index++;
            } else {
                nums[index + 1] = Integer.parseInt(s);
                total += nums[index + 1];
                index++;
            }
        }
        return total;
    }
}
