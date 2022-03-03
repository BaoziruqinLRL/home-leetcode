package com.yyhome.leetcode.easy;

import lombok.var;

/**
 * 1160 拼写单词
 * @author miluo
 * @date 2020-03-17
 */
public class CountCharacters {

    public static void main(String[] args){
        System.out.println(countCharacters(new String[]{"cat","bt","hat","tree"},"atach"));
    }

    private static int countCharacters(String[] words, String chars) {
        int count = 0;
        int[] charsLog = new int[26];
        for (var ch : chars.toCharArray()){
            charsLog[ch - 97]++;
        }
        for (var word : words){
            int[] wordLog = new int[26];
            for (var ch : word.toCharArray()){
                wordLog[ch - 97]++;
            }
            int index = 0;
            while (index < 26){
                if (wordLog[index] > charsLog[index]){
                    break;
                }else{
                    index++;
                }
            }
            if (index == 26){
                count += word.length();
            }
        }
        return count;
    }
}
