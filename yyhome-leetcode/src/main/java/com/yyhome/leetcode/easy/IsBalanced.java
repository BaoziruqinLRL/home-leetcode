package com.yyhome.leetcode.easy;

import com.yyhome.leetcode.data.TreeNode;

/**
 * 110 平衡二叉树
 * @author: lirl
 * @date: 2021/3/8
 */
public class IsBalanced {

    public static void main(String[] args) {
        System.out.println(new IsBalanced().isBalanced(TreeNode.createTree(3,9,20,null,null,15,7)));
        System.out.println(new IsBalanced().isBalanced(TreeNode.createTree(1,2,2,3,3,null,null,4,4)));
        System.out.println(new IsBalanced().isBalanced(TreeNode.createTree(1,2,2,3,null,null,3,4,null,null,4)));
        System.out.println(new IsBalanced().isBalanced(TreeNode.createTree(1,null,2,null,3)));
    }

    /**
     * 执行耗时:1 ms,击败了99.97% 的Java用户
     * 内存消耗:38.4 MB,击败了79.76% 的Java用户
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        return nodeDepth(root,1) >= 0;
    }

    public int nodeDepth(TreeNode node, int depth){
        if (node == null){
            return depth - 1;
        }
        int leftDepth = nodeDepth(node.left, depth + 1);
        int rightDepth = nodeDepth(node.right, depth + 1);
        if (leftDepth >= 0 && rightDepth >= 0 && Math.abs(leftDepth - rightDepth) <= 1){
            return Math.max(leftDepth, rightDepth);
        }else{
            return -1;
        }
    }
}
