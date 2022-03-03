package com.yyhome.leetcode.easy;

/**
 * 551 学生出勤记录Ⅰ
 * @author: lirl
 * @date: 2021/3/29
 */
public class CheckRecord {

    public static void main(String[] args){
        System.out.println(new CheckRecord().checkRecord("PPALLP"));
        System.out.println(new CheckRecord().checkRecord("PPALLL"));
        System.out.println(new CheckRecord().checkRecord("AAAA"));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:36.8 MB,击败了13.82% 的Java用户
     * @param s
     * @return
     */
    public boolean checkRecord(String s) {
        int a = 0;
        for (int i = 0; i < s.length() && a <= 1; i++){
            if (s.charAt(i) == 'A'){
                a++;
            }
            if (s.charAt(i) == 'L' && i + 2 < s.length() && s.charAt(i + 1) == 'L' && s.charAt(i + 2) == 'L'){
                return false;
            }
        }
        return a <= 1;
    }
}
