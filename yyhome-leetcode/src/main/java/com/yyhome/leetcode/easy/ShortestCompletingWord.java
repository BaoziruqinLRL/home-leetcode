package com.yyhome.leetcode.easy;

import java.util.Arrays;

/**
 * 748 最短补全词
 * @author: lirl
 * @date: 2021/4/6
 */
public class ShortestCompletingWord {

    public static void main(String[] args){
        System.out.println(new ShortestCompletingWord().shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));
        System.out.println(new ShortestCompletingWord().shortestCompletingWord("1s3 456", new String[]{"looks", "pest", "stew", "show"}));
    }

    /**
     * 执行耗时:4 ms,击败了82.27% 的Java用户
     * 内存消耗:38.7 MB,击败了86.34% 的Java用户
     * @param licensePlate
     * @param words
     * @return
     */
    public String shortestCompletingWord(String licensePlate, String[] words) {
        licensePlate = licensePlate.toLowerCase();
        int[] nums = new int[26];
        for (char c : licensePlate.toCharArray()){
            if (c >= 'a' && c <= 'z'){
                nums[c - 'a']++;
            }
        }
        String res = null;
        for (String s : words){
            int[] sn = Arrays.copyOf(nums,26);
            for (char c : s.toLowerCase().toCharArray()){
                sn[c - 'a']--;
            }
            boolean isCompleting = true;
            for (int i : sn){
                if (i > 0){
                    isCompleting = false;
                    break;
                }
            }
            if (isCompleting && (res == null || s.length() < res.length())){
                res = s;
            }
        }
        return res;
    }
}
