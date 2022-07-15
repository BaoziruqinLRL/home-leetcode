package com.yyhome.leetcode.middle;

import java.util.*;

/**
 * @Author: linabell
 * @Date: 2022/3/8 18:32
 */
public class TopKFrequent {

    public static void main(String[] args){
        System.out.println(new TopKFrequent().topKFrequent(new String[]{"a","aa","aaa"},2));
        System.out.println(new TopKFrequent().topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"},2));
        System.out.println(new TopKFrequent().topKFrequent(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"},4));
    }

    /**
     * 执行耗时:16 ms,击败了5.79% 的Java用户
     * 内存消耗:42 MB,击败了5.26% 的Java用户
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent(String[] words, int k) {
        HashTree root = new HashTree(' ');
        for (String word: words) {
            doInTree(root, word, 0);
        }
        // 遍历树, 获取频率
        List<String> res = new ArrayList<>();
        Map<Integer, String[]> map = new TreeMap<>(Comparator.reverseOrder());
        findFrequent(map, root.getNodes(), "");
        for (Map.Entry<Integer, String[]> e : map.entrySet()) {
            Arrays.sort(e.getValue());
            for (String s : e.getValue()) {
                res.add(s);
                if (res.size() == k) {
                    return res;
                }
            }
        }
        return res;
    }

    private void findFrequent(Map<Integer, String[]> map, List<HashTree> nodes, String word) {
        for (HashTree t : nodes) {
            if (t.getFrequent() > 0) {
                String[] orDefault = map.getOrDefault(t.getFrequent(), new String[0]);
                String[] newArr = Arrays.copyOf(orDefault, orDefault.length + 1);
                newArr[newArr.length - 1] = word + t.getVal();
                map.put(t.getFrequent(), newArr);
            }
            findFrequent(map, t.getNodes(), word + t.getVal());
        }
    }

    private void doInTree(HashTree node, String word, int index) {
        for (HashTree t : node.getNodes()) {
            if (t.getVal() == word.charAt(index)) {
                if (index == word.length() - 1) {
                    t.incrementFrequent();
                } else {
                    doInTree(t, word, index + 1);
                }
                return;
            }
        }
        while (index < word.length()) {
            HashTree newNode = new HashTree(word.charAt(index));
            node.addNode(newNode);
            node = newNode;
            index++;
        }
        node.incrementFrequent();
    }

    private static class HashTree {
        int frequent;
        char val;
        List<HashTree> nodes;

        public HashTree(char val) {
            this.val = val;
            this.nodes = new LinkedList<>();
            this.frequent = 0;
        }

        public void addNode(HashTree node) {
            nodes.add(node);
        }

        public void incrementFrequent() {
            this.frequent++;
        }

        public int getFrequent() {
            return frequent;
        }

        public char getVal() {
            return val;
        }

        public List<HashTree> getNodes() {
            return nodes;
        }
    }
}
