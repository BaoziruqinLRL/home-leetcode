package com.yyhome.leetcode.easy;

/**
 * 504 七进制数
 * @author: lirl
 * @date: 2021/3/26
 */
public class ConvertToBase7 {

    public static void main(String[] args){
        System.out.println(new ConvertToBase7().convertToBase7(100));
        System.out.println(new ConvertToBase7().convertToBase7(-7));
    }

    /**
     * 执行耗时:6 ms,击败了15.51% 的Java用户
     * 内存消耗:35.9 MB,击败了36.82% 的Java用户
     * @param num
     * @return
     */
    public String convertToBase7(int num) {
        boolean po = (num >= 0);
        int res = 0;
        int v = 1;
        num = Math.abs(num);
        while (num > 0){
            res += v * (num % 7);
            num = num / 7;
            v *= 10;
        }
        return po ? String.valueOf(res) : "-" + res;
    }
}
