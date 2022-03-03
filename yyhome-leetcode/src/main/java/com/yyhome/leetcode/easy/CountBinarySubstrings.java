package com.yyhome.leetcode.easy;

/**
 * 696 计数二进制字串
 * @author: lirl
 * @date: 2021/4/1
 */
public class CountBinarySubstrings {

    public static void main(String[] args){
        System.out.println(new CountBinarySubstrings().countBinarySubstrings("00110"));
        System.out.println(new CountBinarySubstrings().countBinarySubstrings("1"));
        System.out.println(new CountBinarySubstrings().countBinarySubstrings("00110011"));
        System.out.println(new CountBinarySubstrings().countBinarySubstrings("10101"));
    }

    /**
     * 执行耗时:13 ms,击败了65.98% 的Java用户
     * 内存消耗:39.1 MB,击败了37.08% 的Java用户
     * @param s
     * @return
     */
    public int countBinarySubstrings(String s) {
        int count = 0;
        char current = s.charAt(0);
        for (int start = 0, nextStart, end = 0;end < s.length();){
            if (s.charAt(end) == current){
                end++;
            } else {
                nextStart = end;
                for (int i = end; i < end + (end - start) && end < s.length();end++){
                    if (s.charAt(end) == current){
                        break;
                    }
                }
                count += Math.min(end - nextStart, nextStart - start);
                start = nextStart;
                current = s.charAt(start);
            }
        }
        return count;
    }
}
