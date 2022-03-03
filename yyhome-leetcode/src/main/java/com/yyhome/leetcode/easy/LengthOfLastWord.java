package com.yyhome.leetcode.easy;

/**
 * 58 最后一个单词长度
 * @author miluo
 * @date 2020-07-09
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        System.out.println(new LengthOfLastWord().lengthOfLastWord("Hello world"));
        System.out.println(new LengthOfLastWord().lengthOfLastWord("Hello world abcdefg"));
        System.out.println(new LengthOfLastWord().lengthOfLastWord(""));
        System.out.println(new LengthOfLastWord().lengthOfLastWord(" g"));
        System.out.println(new LengthOfLastWord().lengthOfLastWord("a"));
        System.out.println(new LengthOfLastWord().lengthOfLastWord("a "));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.1 MB,击败了6.38% 的Java用户
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        if (s.length() == 0){
            return 0;
        }
        char[] arr = s.toCharArray();
        int index = arr.length - 1;
        int trimLength = 0;
        while (index >= 0 && arr[index] == ' '){
            trimLength++;
            index--;
        }
        while (index >=0 && arr[index] != ' '){
            index--;
        }
        return arr.length - index - trimLength - 1;
    }
}
