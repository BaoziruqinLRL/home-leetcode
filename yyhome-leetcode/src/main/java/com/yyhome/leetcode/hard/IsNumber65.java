package com.yyhome.leetcode.hard;

/**
 * 65 有效数字
 * @Author: linabell
 * @Date: 2023/1/17 10:39:39
 */
public class IsNumber65 {

    public static void main(String[] args) {
        System.out.println("under is true");
        System.out.println(new IsNumber65().isNumber("46.e3"));
        System.out.println(new IsNumber65().isNumber("3."));
        System.out.println(new IsNumber65().isNumber("0"));
        System.out.println(new IsNumber65().isNumber("+.8"));
        System.out.println(new IsNumber65().isNumber("+3.14"));
        System.out.println(new IsNumber65().isNumber("-90E3"));
        System.out.println(new IsNumber65().isNumber("-123.456e789"));
        System.out.println(new IsNumber65().isNumber(".1"));
        System.out.println("under is false");
        System.out.println(new IsNumber65().isNumber("+E3"));
        System.out.println(new IsNumber65().isNumber("+."));
        System.out.println(new IsNumber65().isNumber(".e1"));
        System.out.println(new IsNumber65().isNumber("6+1"));
        System.out.println(new IsNumber65().isNumber("e"));
        System.out.println(new IsNumber65().isNumber("."));
        System.out.println(new IsNumber65().isNumber("-"));
        System.out.println(new IsNumber65().isNumber("+"));
        System.out.println(new IsNumber65().isNumber("e9"));
        System.out.println(new IsNumber65().isNumber("0e"));
        System.out.println(new IsNumber65().isNumber("4e+"));
        System.out.println(new IsNumber65().isNumber("95a54e53"));
        System.out.println(new IsNumber65().isNumber("99e2.5"));
        System.out.println(new IsNumber65().isNumber("--6"));
        System.out.println(new IsNumber65().isNumber("1a"));
    }

    /**
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:41.3 MB,击败了81.18% 的Java用户
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        if (s.equals(".") || s.equals("e") || s.equals("-") || s.equals("+")) {
            return false;
        }
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (c == 'e' || c == 'E') {
                return isInteger(ch, i+1, ch.length) && isNumber(s.substring(0, i));
            }
        }
        for (char c : ch) {
            if (c == '.') {
                return isFloat(ch);
            }
        }
        return isInteger(ch, 0, ch.length);
    }

    /**
     * 是否整数
     * @param ch
     * @param start
     * @param end
     * @return
     */
    public boolean isInteger(char[] ch, int start, int end) {
        if (start >= ch.length) {
            return false;
        }
        if (ch[start] == '-' || ch[start] == '+') {
            start++;
        }
        if (start < ch.length && (ch[start] < '0' || ch[start] > '9')){
            return false;
        }
        if (start >= end) {
            return false;
        }
        for (; start < end; start++) {
            if (ch[start] < '0' || ch[start] > '9') {
                return false;
            }
        }
        return true;
    }

    /**
     * 是否小数
     * @param ch
     * @return
     */
    public boolean isFloat(char[] ch) {
        int start = 0;
        if (ch[0] == '-' || ch[0] == '+') {
            start++;
        }
        // 判断.的前半部分
        for (; start < ch.length; start++) {
            if (ch[start] == '.') {
                start++;
                break;
            }
            if (ch[start] < '0' || ch[start] > '9') {
                return false;
            }
        }
        // 判断.的后半部分
        if (start < ch.length && !(ch[start] >= '0' && ch[start] <= '9')) {
            return false;
        }
        if (!(start-2 >= 0 && ch[start-2] >= '0' && ch[start-2] <= '9') && !(start < ch.length && ch[start] >= '0' && ch[start] <= '9')) {
            return false;
        }
        for (; start < ch.length; start++) {
            if (ch[start] < '0' || ch[start] > '9') {
                return false;
            }
        }
        return true;
    }
}
