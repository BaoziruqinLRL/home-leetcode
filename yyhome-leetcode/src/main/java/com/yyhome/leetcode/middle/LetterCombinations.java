package com.yyhome.leetcode.middle;

import java.util.*;

/**
 * 17 电话号码的字母组合
 * @author: lirl
 * @date: 2021/4/9
 */
public class LetterCombinations {

    public static void main(String[] args){
        System.out.println(new LetterCombinations().letterCombinations("23"));
        System.out.println(new LetterCombinations().letterCombinations("2"));
        System.out.println(new LetterCombinations().letterCombinations("234"));
    }

    private static Map<Character, char[]> MAP = new HashMap<Character, char[]>(){{
        put('2', new char[]{'a','b','c'});
        put('3', new char[]{'d','e','f'});
        put('4', new char[]{'g','h','i'});
        put('5', new char[]{'j','k','l'});
        put('6', new char[]{'m','n','o'});
        put('7', new char[]{'p','q','r','s'});
        put('8', new char[]{'t','u','v'});
        put('9', new char[]{'w','x','y','z'});
    }};

    private List<String> res;

    /**
     * 执行耗时:1 ms,击败了83.28% 的Java用户
     * 内存消耗:37 MB,击败了81.52% 的Java用户
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0){
            return Collections.emptyList();
        }

        res = new ArrayList<>();
        dfs(digits, new StringBuilder());
        return res;
    }

    public void dfs(String s, StringBuilder sb){
        if (s == null || s.length() == 0){
            res.add(sb.toString());
            return;
        }
        char[] ca = MAP.get(s.charAt(0));
        for (char c : ca){
            sb.append(c);
            dfs(s.substring(1), sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
