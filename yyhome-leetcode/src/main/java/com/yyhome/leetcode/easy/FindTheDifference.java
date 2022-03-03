package com.yyhome.leetcode.easy;

/**
 * 389 找不同
 * @author: lirl
 * @date: 2021/3/23
 */
public class FindTheDifference {

    public static void main(String[] args){
        System.out.println(new FindTheDifference().findTheDifference("abcd","abcde"));
        System.out.println(new FindTheDifference().findTheDifference("","y"));
        System.out.println(new FindTheDifference().findTheDifference("a","aa"));
        System.out.println(new FindTheDifference().findTheDifference("ae","aea"));
    }

    /**
     * 执行耗时:3 ms,击败了55.28% 的Java用户
     * 内存消耗:37.1 MB,击败了8.10% 的Java用户
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        int sb = 0, tb = 0;
        for (int i = 0; i < s.length(); i++){
            sb = sb ^ (1 << ((s.charAt(i) - 'a') % 32));
            tb = tb ^ (1 << ((t.charAt(i) - 'a') % 32));
        }
        tb = tb ^ (1 << ((t.charAt(t.length() - 1) - 'a') % 32));
        int res = sb ^ tb;
        return (char) ('a' + ((int) (Math.log(res) / Math.log(2))));
    }
}
