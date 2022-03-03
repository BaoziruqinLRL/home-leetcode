package com.yyhome.leetcode.middle;

/**
 * 91 解码方法
 * @author: lirl
 * @date: 2021/5/7
 */
public class NumDecodings {

    public static void main(String[] args) {
        System.out.println(new NumDecodings().numDecodings("17"));
        System.out.println(new NumDecodings().numDecodings("2611055971756562"));
        System.out.println(new NumDecodings().numDecodings("1"));
        System.out.println(new NumDecodings().numDecodings("12"));
        System.out.println(new NumDecodings().numDecodings("226"));
        System.out.println(new NumDecodings().numDecodings("0"));
        System.out.println(new NumDecodings().numDecodings("06"));
    }

    /**
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:36.7 MB,击败了53.12% 的Java用户
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int[] count = new int[s.length()];
        count[0] = 1;
        if (s.charAt(0) == '1' || (s.charAt(0) == '2' && s.charAt(1) <= '6')) {
            count[1] = s.charAt(1) == '0' ? 1 : 2;
        } else if (s.charAt(1) > '0'){
            count[1] = count[0];
        } else {
            return 0;
        }
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) > '0') {
                count[i] += count[i-1];
            }
            if (s.charAt(i-1) == '1' || (s.charAt(i-1) == '2' && s.charAt(i) <= '6')) {
                count[i] += count[i-2];
            }
        }
        return count[s.length() - 1];
    }
}
