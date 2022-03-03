package com.yyhome.leetcode.easy;

/**
 * 202 快乐数
 * @author: lirl
 * @date: 2021/3/10
 */
public class IsHappy {

    public static void main(String[] args) {
        System.out.println(new IsHappy().isHappy(19));
        System.out.println(new IsHappy().isHappy(2));
        System.out.println(new IsHappy().isHappy(1999999999));
    }

    /**
     * 执行耗时:1 ms,击败了99.73% 的Java用户
     * 内存消耗:35.2 MB,击败了85.71% 的Java用户
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        int[] list = new int[23];
        while (true){
            int total = 0;
            while (n > 0) {
                int num = n % 10;
                total += num * num;
                n = n / 10;
            }
            if (total == 1){
                return true;
            }
            int index = total / 32;
            int position = total % 32;
            if (((list[index] >> position) & 1) == 1){
                return false;
            }
            list[index] = list[index] | (1 << position);
            n = total;
        }
    }
}
