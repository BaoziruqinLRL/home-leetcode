package com.yyhome.leetcode.middle;

import com.yyhome.leetcode.data.TreeNode;

/**
 * 面试题 04.06 后继者
 * @author: lirl
 * @date: 2021/4/14
 */
public class InorderSuccessor {

    public static void main(String[] args) {
        TreeNode.print(new InorderSuccessor().inorderSuccessor(TreeNode.createTree(5,3,6,2,4,null,null,1), TreeNode.createTree(1)));
        TreeNode.print(new InorderSuccessor().inorderSuccessor(TreeNode.createTree(2, 1, 3), TreeNode.createTree(1)));
        TreeNode.print(new InorderSuccessor().inorderSuccessor(TreeNode.createTree(5,3,6,2,4,null,null,1), TreeNode.createTree(6)));
    }

    private TreeNode res = null;
    long last = Long.MIN_VALUE;

    /**
     * 执行耗时:3 ms,击败了100.00% 的Java用户
     * 内存消耗:39.2 MB,击败了53.69% 的Java用户
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        middleSort(root, p.val);
        return res;
    }

    public void middleSort(TreeNode node, int val) {
        if (node == null) {
            return;
        }
        middleSort(node.left, val);
        if (last == val) {
            last = node.val;
            res = node;
            return;
        } else {
            last = node.val;
        }
        middleSort(node.right, val);
    }
}
