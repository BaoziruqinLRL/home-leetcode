package com.yyhome.leetcode.data;

import java.util.ArrayList;
import java.util.List;

/**
 * N叉树
 * @author: lirl
 * @date: 2021/4/6
 */
public class Node {

    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }

    /**
     * 以null为分界点
     * @param values
     * @return
     */
    public static Node createTree(Integer... values){
        int current = -1;
        Node[] allNode = new Node[values.length];
        int anIndex = 0;
        List<Node> sonNodes = new ArrayList<>();
        for (Integer v : values){
            if (v == null){
                if (!sonNodes.isEmpty()) {
                    allNode[current].children = sonNodes;
                    sonNodes = new ArrayList<>();
                }
                current++;
            } else {
                Node n = new Node(v);
                if (anIndex > 0) {
                    sonNodes.add(n);
                }
                allNode[anIndex++] = n;
            }
        }
        allNode[current].children = sonNodes.isEmpty() ? null : sonNodes;
        return allNode[0];
    }
}
