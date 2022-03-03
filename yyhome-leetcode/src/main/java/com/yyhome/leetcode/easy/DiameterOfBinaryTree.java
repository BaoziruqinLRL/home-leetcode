package com.yyhome.leetcode.easy;

import com.yyhome.leetcode.data.TreeNode;

/**
 * 543 二叉树的直径
 * @author: lirl
 * @date: 2021/3/29
 */
public class DiameterOfBinaryTree {

    public static void main(String[] args){
        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(TreeNode.createTree(1,2,3,4,5)));
        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(TreeNode.createTree(1,2,3,4,5,6,7)));
    }

    int max = Integer.MIN_VALUE;

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:38.6 MB,击败了17.51% 的Java用户
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        cycle(root);
        return max - 1;
    }

    public int cycle(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = 1 + cycle(root.left);
        int right = 1 + cycle(root.right);
        max = Math.max(max, left + right - 1);
        return Math.max(left, right);
    }
}
