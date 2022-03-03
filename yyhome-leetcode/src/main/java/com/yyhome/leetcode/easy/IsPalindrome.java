package com.yyhome.leetcode.easy;

/**
 * 9 回文数
 * @author miluo
 * @date 2020-07-07
 */
public class IsPalindrome {

    public static void main(String[] args){
        System.out.println(new IsPalindrome().isPalindrome(121));
        System.out.println(new IsPalindrome().isPalindrome(0));
        System.out.println(new IsPalindrome().isPalindrome(-121));
        System.out.println(new IsPalindrome().isPalindrome(10));
        System.out.println(new IsPalindrome().isPalindrome(18781));
    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x >= 10 && x % 10 == 0)){
            return false;
        }else{
            int revert = 0;
            while (x > revert){
                revert = revert * 10 + x % 10;
                x /= 10;
            }
            return x == revert || x == (revert / 10);
        }
    }
}
