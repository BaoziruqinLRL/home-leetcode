package com.yyhome.leetcode.easy;

import com.yyhome.leetcode.data.TreeNode;

/**
 * 226 翻转二叉树
 * @author: lirl
 * @date: 2021/3/11
 */
public class InvertTree {

    public static void main(String[] args) {
        TreeNode.print(new InvertTree().invertTree(TreeNode.createTree(4,2,7,1,3,6,9)),2);
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:35.7 MB,击败了89.21% 的Java用户
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return root;
        }
        TreeNode node = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(node);
        return root;
    }
}
