package com.yyhome.leetcode.easy;

/**
 * @Author: linabell
 * @Date: 2022/9/16 16:38:34
 */
public class ConvertToTitle168 {

    public static void main(String[] args){
        System.out.println(new ConvertToTitle168().convertToTitle(1));
        System.out.println(new ConvertToTitle168().convertToTitle(26));
        System.out.println(new ConvertToTitle168().convertToTitle(52));
        System.out.println(new ConvertToTitle168().convertToTitle(28));
        System.out.println(new ConvertToTitle168().convertToTitle(701));
        System.out.println(new ConvertToTitle168().convertToTitle(2147483647));
    }

    /**
     * 执行耗时:7 ms,击败了7.79% 的Java用户
     * 内存消耗:39.6 MB,击败了5.01% 的Java用户
     * @param columnNumber
     * @return
     */
    public String convertToTitle(int columnNumber) {
        if (columnNumber == 0) {
            return "";
        }
        int right = (columnNumber - 1) % 26;
        int left = right == 25 ? (columnNumber / 26) - 1 : columnNumber / 26;
        return convertToTitle(left) + (char) ('A' + right);
    }
}
