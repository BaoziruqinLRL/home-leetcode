package com.yyhome.leetcode.middle;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 22 括号生成
 * @author: lirl
 * @date: 2021/4/9
 */
public class GenerateParenthesis {

    public static void main(String[] args){
        System.out.println(JSON.toJSONString(new GenerateParenthesis().generateParenthesis(3)));
        System.out.println(JSON.toJSONString(new GenerateParenthesis().generateParenthesis(1)));
    }

    private List<String> res = new ArrayList<>();

    /**
     * 先组装所有的左括号，后用回溯法决定右括号插在哪里
     * 如 n = 4 (((( -> ()((( 则，递归计算下一步 n = 3 ((( -> ()((，同时每一次递归，右括号都有不同的插法，因此能够遍历出所有的组合
     * 执行耗时:1 ms,击败了96.47% 的Java用户
     * 内存消耗:38.3 MB,击败了97.69% 的Java用户
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++){
            sb.append("(");
        }
        cycle(n, 0, 0, sb);
        return res;
    }

    /**
     * 递归回溯
     * @param n 剩n个右括号待插入
     * @param start 下一次右括号要插入的开始位置
     * @param left start左边左括号比右括号多的个数
     * @param sb 回溯字符串
     */
    public void cycle(int n, int start, int left, StringBuilder sb) {
        if (n == 0){
            res.add(sb.toString());
        } else {
            // i为实际开始插入位置，如果left大于0，表示start左边左括号比右括号多，此时右括号可以插入到start位置
            // 举个例子，((()( 这个字符串，start = 4，left = 2，n = 3，此时右括号可以插入在start的位置
            // 而 (())(( 这个字符串，start = 4，left = 0，n = 2，此时如果右括号插入在start的位置就不是有效的括号了，所以left决定了实际的开始插入位置
            for (int i = start + (left > 0 ? 0 : 1); i <= sb.length(); i++) {
                if (i >= sb.length()) {
                    sb.append(")");
                    cycle(n - 1, sb.length(), 1, sb);
                    sb.deleteCharAt(sb.length() - 1);
                } else {
                    sb.insert(i, ")");
                    cycle(n - 1, i + 1, left + i - start - 1, sb);
                    sb.deleteCharAt(i);
                }
            }
        }
    }
}
