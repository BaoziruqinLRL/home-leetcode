package com.yyhome.leetcode.middle;

import java.util.HashSet;
import java.util.Set;

/**
 * 3 无重复字符的最长子串
 * @author miluo
 * @date 2020-03-17
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("abcbbcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring(" "));
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }

    /**
     * 执行耗时:4 ms,击败了86.74% 的Java用户
     * 内存消耗:41.5 MB,击败了20.79% 的Java用户
     * @param s
     * @return
     */
    private static int lengthOfLongestSubstring(String s) {
        int length = 0;
        Set<Integer> charSet = new HashSet<>();
        char[] arr = s.toCharArray();
        int tempLength = 0;
        for (int left = 0, right = 0; left <= right && right < s.length();){
            if (left == right){
                charSet.add((int) arr[left]);
                right++;
                tempLength++;
            }else{
                if (!charSet.contains((int)arr[right])){
                    charSet.add((int)arr[right]);
                    right++;
                    tempLength++;
                }else{
                    // 存在重复，计算长度，左界收拢
                    length = Math.max(length,tempLength);
                    // 左界收拢到第一个等于right的元素的索引位置的后一位
                    while (arr[left] != arr[right]){
                        charSet.remove((int)arr[left]);
                        left++;
                        tempLength--;
                    }
                    left++;
                    right++;
                }
            }
        }
        return Math.max(length,tempLength);
    }

    /**
     * 执行耗时:2 ms,击败了93.94% 的Java用户
     * 内存消耗:41.4 MB,击败了19.52% 的Java用户
     * @param s
     * @return
     */
    private int lengthOfLongestSubstring2(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int maxLength = 1;
        int[] hash = new int[]{0, 0, 0};
        int index = s.charAt(0) - 32;
        int hashIndex = index / 32;
        hash[hashIndex] = hash[hashIndex] | (1 << (index % 32));
        int windowLeft = 0, windowRight = 1;
        while (windowRight < s.length()) {
            index = s.charAt(windowRight) - 32;
            hashIndex = index / 32;
            if ((hash[hashIndex] & (1 << (index % 32))) == 0) {
                // 代表未存在重复元素
                hash[hashIndex] = hash[hashIndex] | (1 << index % 32);
                windowRight++;
            } else {
                maxLength = Math.max(windowRight - windowLeft, maxLength);
                if (windowRight == s.length() - 1) {
                    return maxLength;
                }
                while (windowLeft < windowRight) {
                    if (s.charAt(windowLeft) == s.charAt(windowRight)) {
                        windowLeft++;
                        windowRight++;
                        break;
                    } else {
                        index = s.charAt(windowLeft) - 32;
                        hashIndex = index / 32;
                        hash[hashIndex] = hash[hashIndex] ^ (1 << index % 32);
                        windowLeft++;
                    }
                }
            }
        }
        return Math.max(windowRight -windowLeft, maxLength);
    }
}
