package com.yyhome.leetcode.middle;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * 77 组合
 * @author: lirl
 * @date: 2021/4/20
 */
public class Combine {

    public static void main(String[] args) {
        System.out.println(JSON.toJSONString(new Combine().combine(4,2)));
        System.out.println(JSON.toJSONString(new Combine().combine(4,3)));
    }

    /**
     * 执行耗时:1 ms,击败了100.00% 的Java用户
     * 内存消耗:39.7 MB,击败了69.08% 的Java用户
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        back(res, new ArrayList<Integer>(), 1, n, k);
        return res;
    }

    public void back(List<List<Integer>> list, List<Integer> li, int start, int n, int k) {
        if (start > n || k == 0) {
            list.add(new ArrayList<>(li));
        } else {
            for (;start <= n && k > 0 && n - start >= k - 1; start++) {
                li.add(start);
                back(list, li, start + 1, n, k - 1);
                li.remove(li.size() - 1);
            }
        }
    }
}
