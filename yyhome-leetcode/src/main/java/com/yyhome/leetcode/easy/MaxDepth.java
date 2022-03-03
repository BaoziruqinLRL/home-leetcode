package com.yyhome.leetcode.easy;

import com.yyhome.leetcode.data.TreeNode;

/**
 * 104 二叉树的最大深度
 * @author: lirl
 * @date: 2021/3/4
 */
public class MaxDepth {

    public static void main(String[] args){
        System.out.println(new MaxDepth().maxDepth(TreeNode.createTree(3,9,20,null,null,15,7)));
    }

    /**
     * 执行用时: 0 ms
     * 内存消耗: 38.6 MB
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        return loop(root,1);
    }

    public int loop(TreeNode node, int max){
        if (node == null){
            return max - 1;
        }
        int left = loop(node.left, max + 1);
        int right = loop(node.right, max + 1);
        return Math.max(left,right);
    }
}
