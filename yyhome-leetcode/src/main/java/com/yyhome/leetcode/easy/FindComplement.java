package com.yyhome.leetcode.easy;

/**
 * 476 数字的补位
 * @author: lirl
 * @date: 2021/3/25
 */
public class FindComplement {

    public static void main(String[] args){
        System.out.println(new FindComplement().findComplement(5));
        System.out.println(new FindComplement().findComplement(1));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:35.4 MB,击败了19.18% 的Java用户
     * @param num
     * @return
     */
    public int findComplement(int num) {
        int move = 0;
        for (int i = 30; i >= 0; i--){
            if (((num >> i) & 1) == 1){
                move = i + 1;
                break;
            }
        }
        int c = 0;
        for (int i = 0; i < move; i++){
            c = (c << 1) | 1;
        }
        return num ^ c;
    }
}
