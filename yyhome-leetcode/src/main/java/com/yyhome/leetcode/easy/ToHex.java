package com.yyhome.leetcode.easy;

/**
 * 405 数字转十六进制
 * @author: lirl
 * @date: 2021/3/24
 */
public class ToHex {

    public static void main(String[] args) {
        System.out.println(new ToHex().toHex(1000));
        System.out.println(new ToHex().toHex(26));
        System.out.println(new ToHex().toHex(-1));
    }

    private static String[] map = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:35.6 MB,击败了80.00% 的Java用户
     * @param num
     * @return
     */
    public String toHex(int num) {
        if (num == 0){
            return map[0];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++){
            if (num != 0) {
                sb.insert(0,map[num & 0b1111]);
            }
            num = num >> 4;
        }
        return sb.toString();
    }
}
