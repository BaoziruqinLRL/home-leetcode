package com.yyhome.leetcode.easy;

/**
 * 541 反转字符串Ⅱ
 * @author: lirl
 * @date: 2021/3/29
 */
public class ReverseStr {

    public static void main(String[] args){
        System.out.println(new ReverseStr().reverseStr("abcdefg", 2));
    }

    StringBuilder sb = new StringBuilder();

    /**
     * 执行耗时:2 ms,击败了32.83% 的Java用户
     * 内存消耗:38.6 MB,击败了29.58% 的Java用户
     * @param s
     * @param k
     * @return
     */
    public String reverseStr(String s, int k) {
        if (s.length() <= k){
            return reverse(s);
        } else if (s.length() <= 2*k){
            return reverse(s.substring(0, k)) + s.substring(k);
        } else {
            while (s.length() > 2*k){
                sb.append(reverse(s.substring(0, k)) + s.substring(k, 2*k));
                s = s.substring(2*k);
            }
            sb.append(s.length() <= k ? reverse(s) : reverse(s.substring(0, k)) + s.substring(k));
            return sb.toString();
        }
    }

    public String reverse(String s){
        return new StringBuilder(s).reverse().toString();
    }
}
