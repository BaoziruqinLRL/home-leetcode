package com.yyhome.leetcode.middle;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 1807 替换字符串中的括号内容
 * @author: lirl
 * @date: 2021/6/30
 */
public class Evaluate {

    public static void main(String[] args){
        System.out.println(new Evaluate().evaluate("(name)is(age)yearsold", Arrays.asList(Arrays.asList("name","bob"), Arrays.asList("age","two"))));
    }

    /**
     * 执行耗时:51 ms,击败了38.46% 的Java用户
     * 内存消耗:77.8 MB,击败了48.35% 的Java用户
     * @param s
     * @param knowledge
     * @return
     */
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = knowledge.stream()
                .collect(Collectors.toMap(k -> k.get(0), k -> k.get(1)));
        int ss = 0, ee = -1;
        StringBuilder sb = new StringBuilder();
        while (ss < s.length()) {
            if (s.charAt(ss) == '(') {
                sb.append(s, ee + 1, ss);
                ee = ss + 1;
                while (ee < s.length()) {
                    if (s.charAt(ee) == ')') {
                        sb.append(map.getOrDefault(s.substring(ss + 1, ee), "?"));
                        ss = ee + 1;
                        break;
                    }
                    ee++;
                }
            } else {
                ss++;
            }
        }
        if (ee != s.length() - 1) {
            sb.append(s, ee + 1, s.length());
        }
        return sb.toString();
    }
}
