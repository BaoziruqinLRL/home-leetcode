package com.yyhome.leetcode.easy;

/**
 * 383 赎金信
 * @author: lirl
 * @date: 2021/3/23
 */
public class CanConstruct {

    public static void main(String[] args){
        System.out.println(new CanConstruct().canConstruct("", ""));
        System.out.println(new CanConstruct().canConstruct("a", ""));
        System.out.println(new CanConstruct().canConstruct("a", "b"));
        System.out.println(new CanConstruct().canConstruct("aa", "ab"));
        System.out.println(new CanConstruct().canConstruct("aa", "aab"));
    }

    /**
     * 执行耗时:2 ms,击败了93.72% 的Java用户
     * 内存消耗:38.3 MB,击败了96.36% 的Java用户
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()){
            return false;
        }
        if (magazine.length() == 0){
            return true;
        }
        int[] array = new int[26];
        int index = 0;
        for (; index < ransomNote.length(); index++){
            array[magazine.charAt(index) - 'a']++;
            array[ransomNote.charAt(index) - 'a']--;
        }
        for (; index < magazine.length(); index++){
            array[magazine.charAt(index) - 'a']++;
        }
        for (int v : array){
            if (v < 0){
                return false;
            }
        }
        return true;
    }
}
