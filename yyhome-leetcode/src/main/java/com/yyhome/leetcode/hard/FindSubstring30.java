package com.yyhome.leetcode.hard;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * 30 串联所有单词的字串
 * @Author: linabell
 * @Date: 2022/11/4 15:03:13
 */
public class FindSubstring30 {

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new FindSubstring30().findSubstring2("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"})));
        System.out.println(JSON.toJSONString(new FindSubstring30().findSubstring2("barfoothefoobarman", new String[]{"foo","bar"})));
        System.out.println(JSON.toJSONString(new FindSubstring30().findSubstring2("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"})));
        System.out.println(JSON.toJSONString(new FindSubstring30().findSubstring2("barfoofoobarthefoobarman", new String[]{"bar","foo","the"})));

        System.out.println(JSON.toJSONString(new FindSubstring30().findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"})));
        System.out.println(JSON.toJSONString(new FindSubstring30().findSubstring("barfoothefoobarman", new String[]{"foo","bar"})));
        System.out.println(JSON.toJSONString(new FindSubstring30().findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"})));
        System.out.println(JSON.toJSONString(new FindSubstring30().findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"})));
    }

    /**
     * 执行耗时:1748 ms,击败了5.02% 的Java用户
     * 内存消耗:42.8 MB,击败了5.04% 的Java用户
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        int wordLength = words.length * words[0].length();
        int oneWordLength = words[0].length();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= s.length() - wordLength; i++) {
            int exist = exist(s.substring(i, i + oneWordLength), words, Collections.emptySet());
            if (exist >= 0) {
                Set<Integer> set = new HashSet<>();
                set.add(exist);
                for (int j = i + oneWordLength; j < i + wordLength; j += oneWordLength) {
                    exist = exist(s.substring(j, j + oneWordLength), words, set);
                    if (exist >= 0) {
                        set.add(exist);
                    } else {
                        break;
                    }
                }
                if (set.size() == words.length) {
                    result.add(i);
                }
            }
        }
        return result;
    }

    private int exist(String w, String[] words, Set<Integer> existIndex) {
        for (int i = 0; i < words.length; i++) {
            if (!existIndex.contains(i) && words[i].equals(w)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 执行耗时:12 ms,击败了89.12% 的Java用户
     * 内存消耗:41.8 MB,击败了92.09% 的Java用户
     * 移动窗口 每次移动words[0].length,得到map记录,当map中的记录达到单词数量时比对每个单词数量是否一致,
     * 之后移除左边第一个单词, 往后移动一个单词,依次反复计算map中的记录即可
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring2(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int oneWordLength = words[0].length();
        Map<String, Integer> map, targetMap = new HashMap<>();
        for (String w : words) {
            Integer orDefault = targetMap.getOrDefault(w, 0);
            targetMap.put(w, orDefault + 1);
        }
        for (int i = 0; i < oneWordLength; i++) {
            int left = i, right = i + oneWordLength;
            int count = 0;
            map = new HashMap<>();
            while (left < right && right <= s.length()) {
                String thisWord = s.substring(right - oneWordLength, right);
                if (map.containsKey(thisWord)) {
                    map.put(thisWord, map.get(thisWord) + 1);
                } else {
                    map.put(thisWord, 1);
                }
                count++;
                if (count == words.length) {
                    int q = 0;
                    for (;q < words.length; q++) {
                        if (!targetMap.get(words[q]).equals(map.get(words[q]))) {
                            break;
                        }
                    }
                    if (q == words.length) {
                        result.add(left);
                    }
                    String w = s.substring(left, left + oneWordLength);
                    map.put(w, map.get(w) - 1);
                    left += oneWordLength;
                    right += oneWordLength;
                    count--;
                } else {
                    right += oneWordLength;
                }
            }
        }
        return result;
    }
}
