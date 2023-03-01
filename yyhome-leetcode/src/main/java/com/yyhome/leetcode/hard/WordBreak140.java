package com.yyhome.leetcode.hard;

import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: linabell
 * @Date: 2023/3/1 8:45:29
 */
public class WordBreak140 {

    public static void main(String[] args) {
        System.out.println(new WordBreak140().wordBreak("catsanddog", Arrays.asList("cat","cats","and","sand","dog")));
        System.out.println(new WordBreak140().wordBreak("pineapplepenapple", Arrays.asList("apple","pen","applepen","pine","pineapple")));
        System.out.println(new WordBreak140().wordBreak("catsandog", Arrays.asList("cats","dog","sand","and","cat")));
    }

    /**
     * 执行耗时:5 ms,击败了10.09% 的Java用户
     * 内存消耗:40 MB,击败了29.48% 的Java用户
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        return back(s, 0, wordDict);
    }

    private Map<Integer, List<String>> map = new HashMap<>();

    public List<String> back(String s, int index, List<String> wordDict) {
        if (map.containsKey(index)) {
            return map.get(index);
        }
        for (int i = index + 1; i <= s.length(); i++) {
            String substring = s.substring(index, i);
            if (wordDict.contains(substring)) {
                List<String> back = back(s, i, wordDict);
                if (back != null && back.size() > 0) {
                    List<String> orDefault = map.getOrDefault(index, new ArrayList<>());
                    List<String> collect = back.stream().map(b -> substring + " " + b).collect(Collectors.toList());
                    orDefault.addAll(collect);
                    map.put(index, orDefault);
                } else if (i == s.length()) {
                    List<String> orDefault = map.getOrDefault(index, new ArrayList<>());
                    orDefault.add(substring);
                    map.put(index, orDefault);
                }
            }
        }
        return map.getOrDefault(index, Collections.emptyList());
    }
}
