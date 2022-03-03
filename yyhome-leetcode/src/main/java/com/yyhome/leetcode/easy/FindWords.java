package com.yyhome.leetcode.easy;

import java.util.*;

/**
 * 500 键盘行
 * @author: lirl
 * @date: 2021/3/26
 */
public class FindWords {

    public static void main(String[] args){
        System.out.println(Arrays.toString(new FindWords().findWords(new String[]{"Hello","Alaska","Dad","Peace"})));
        System.out.println(Arrays.toString(new FindWords().findWords(new String[]{"omk"})));
        System.out.println(Arrays.toString(new FindWords().findWords(new String[]{"adsdf","sfd"})));
    }

    private static Map<Character,Integer> map = new HashMap<Character,Integer>(){{
        put('q', 1);
        put('w', 1);
        put('e', 1);
        put('r', 1);
        put('t', 1);
        put('y', 1);
        put('u', 1);
        put('i', 1);
        put('o', 1);
        put('p', 1);
        put('a', 2);
        put('s', 2);
        put('d', 2);
        put('f', 2);
        put('g', 2);
        put('h', 2);
        put('j', 2);
        put('k', 2);
        put('l', 2);
        put('z', 3);
        put('x', 3);
        put('c', 3);
        put('v', 3);
        put('b', 3);
        put('n', 3);
        put('m', 3);
    }};

    /**
     * 执行耗时:1 ms,击败了62.58% 的Java用户
     * 内存消耗:36.4 MB,击败了69.96% 的Java用户
     * @param words
     * @return
     */
    public String[] findWords(String[] words) {
        List<String> res = new ArrayList<>();
        for (String w : words){
            int line = 0;
            for (char c : w.toLowerCase().toCharArray()){
                if (line == 0){
                    line = map.get(c);
                } else if (line != map.get(c)) {
                    line = 0;
                    break;
                }
            }
            if (line != 0){
                res.add(w);
            }
        }
        String[] re = new String[res.size()];
        int index = 0;
        for (String s : res){
            re[index++] = s;
        }
        return re;
    }
}
