package com.yyhome.leetcode.easy;

import com.yyhome.leetcode.data.TreeNode;

/**
 * 404 左叶子之和
 * @author: lirl
 * @date: 2021/3/24
 */
public class SumOfLeftLeaves {

    public static void main(String[] args) {
        System.out.println(new SumOfLeftLeaves().sumOfLeftLeaves(TreeNode.createTree(3, 9, 20, null, null, 15, 7)));
    }

    /**
     * 执行耗时:0 ms,击败了100.00% 的Java用户
     * 内存消耗:36.4 MB,击败了19.01% 的Java用户
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null){
            return 0;
        }
        return sum(root.left, true) + sum(root.right, false);
    }

    public int sum(TreeNode node, boolean left){
        if (node == null){
            return 0;
        }
        if (node.left == null && node.right == null){
            return left ? node.val : 0;
        }
        return sum(node.left, true) + sum(node.right, false);
    }
}
