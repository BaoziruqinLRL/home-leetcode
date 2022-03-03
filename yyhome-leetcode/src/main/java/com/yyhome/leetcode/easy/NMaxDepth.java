package com.yyhome.leetcode.easy;

import com.yyhome.leetcode.data.Node;

/**
 * 559 N叉树的最大深度
 * @author: lirl
 * @date: 2021/4/6
 */
public class NMaxDepth {

    public static void main(String[] args){
        System.out.println(new NMaxDepth().maxDepth(Node.createTree(1,null,3,2,4,null,5,6)));
        System.out.println(new NMaxDepth().maxDepth(Node.createTree(1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12, null,13,null,null,14)));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.5 MB,击败了63.42% 的Java用户
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        return cycle(root, 1);
    }

    public int cycle(Node node, int depth){
        if (node == null){
            return depth - 1;
        }
        if (node.children == null){
            return depth;
        }
        int max = depth;
        for (Node n : node.children){
            max = Math.max(cycle(n, depth + 1), max);
        }
        return max;
    }
}
